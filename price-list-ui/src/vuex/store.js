import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import { isEmpty } from '@/utils/validate.js'
import apiConfig from '@/api/apiConfig.js'
import * as Cookies from 'js-cookie'

Vue.use(Vuex)

// 应用初始状态
const state = {
  user: {}
}

const mutations = {
  setUser (state, user) {
    state.user = user
  }
}

const getters = {
  getUser: state => {
    return state.user
  }
}

const actions = {
  setUser (context, user) {
    let avatar = user.avatar
    if (!isEmpty(apiConfig.baseUrl) && !isEmpty(avatar) && !avatar.startsWith(apiConfig.baseUrl) && !avatar.startsWith('http')) {
      user.avatar = apiConfig.baseUrl + avatar
    }
    context.commit('setUser', user)
  }
}

export const store = new Vuex.Store({
  state,
  getters,
  actions,
  mutations,
  plugins: [createPersistedState(
    {
      storage: {
        getItem: key => Cookies.get(key),
        setItem: (key, value) => Cookies.set(key, value, { expires: 1 }),
        removeItem: key => Cookies.remove(key)
      },
      reducer (val) {
        return {
          user: val.user
        }
      }
    }
  )]
})
