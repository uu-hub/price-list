import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Index from '@/components/Index'
import NotFound from '@/components/error/404'
import JobResultDetail from '@/components/rct/JobResultDetail'

import API from '@/api/api.js'
import { store } from '@/vuex/store.js'
import { isEmpty } from '@/utils/validate.js'

Vue.use(Router)

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login,
      hidden: true
    },
    {
      path: '/',
      name: 'index',
      component: Index,
      children: [
        {
          name: 'pricelist',
          path: '/list/priceList',
          component: PriceList
        }, {
          name: 'jobResultDetail',
          path: '/rct/jobResultDetail',
          component: JobResultDetail
        }
      ]
    },
    {
      path: '/404',
      component: NotFound,
      name: '404',
      hidden: true
    },
    {
      path: '*',
      hidden: true,
      redirect: { path: '/404' }
    }
  ]
})

export default router

router.beforeEach((to, from, next) => {
  let user = store.getters.getUser
  let toPath = to.path
  if (toPath !== '/login' && (isEmpty(user) || isEmpty(user.userId) || isEmpty(user.userName) || isEmpty(user.userRole))) {
    let code = to.query.code
    if (!isEmpty(code)) {
      let url = '/user/oauth2Login?code=' + code
      API.get(
        url,
        null,
        response => {
          let result = response.data
          if (result.code === 0) {
            store.dispatch('setUser', result.data)
            next()
          } else {
            next({ path: 'login' })
          }
        },
        () => {
          next({ path: 'login' })
        }
      )
    } else {
      next({ path: 'login' })
    }

    // admin
  } else if (user.userRole === 1 && toPath.indexOf('group-manage') > 0) {
    next({ name: 'dashboard', params: { groupId: store.getters.getCurrentGroup.groupId } })
  } else if (user.userRole === 2 && (toPath.indexOf('group-manage') > 0 || toPath.indexOf('user-manage') > 0 ||
    toPath.indexOf('machine-manage') > 0 || toPath.indexOf('installation') > 0 ||
    toPath.indexOf('channel-manage') > 0 || toPath.indexOf('rule-manage') > 0 ||
    toPath.indexOf('redis-manage') > 0 || toPath.indexOf('alert-manage') > 0 ||
    toPath.indexOf('edit-history') > 0)) {
    next({ name: 'dashboard', params: { groupId: store.getters.getCurrentGroup.groupId } })
  } else {
    next()
  }
})
