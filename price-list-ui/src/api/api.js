/* eslint-disable indent */
import axios from 'axios'
import message from '@/utils/message.js'
import router from '@/router'
import { store } from '@/vuex/store.js'

// 封装axios
// eslint-disable-next-line space-before-function-paren
function apiAxios(method, url, params, successHandler, failureHandler) {
    // if (store.getters.getUser) {
        axios({
            method: method,
            url: url,
            headers: {'UserIp': store.getters.getUserIp},
            data: method === 'POST' || method === 'PUT' ? params : null,
            params: method === 'GET' || method === 'DELETE' ? params : null
            // baseURL: root,
            // withCredentials: true //开启cookies
        }).then(function (res) {
            successHandler(res)
        }).catch(function (err) {
            if (err.response && (err.response.code === 401 || err.response.status === 404)) {
                message.warning('user infomation has expried,please login!')
                router.push({ name: 'login' })
              } else {
                failureHandler(err)
            }
            // if (err.response.status === 401) {
            //     message.warning('Session timeout')
            //     router.push({ name: 'login' })
            // }
        })
    }
    // else {
    //     message.error('user infomation has expried,please login!')
    //     router.push({ name: 'login' })
    //   }
// }

export default {
    get: function (url, params, successHandler, failureHandler) {
        return apiAxios('GET', url, params, successHandler, failureHandler)
    },
    post: function (url, params, successHandler, failureHandler) {
        return apiAxios('POST', url, params, successHandler, failureHandler)
    },
    put: function (url, params, successHandler, failureHandler) {
        return apiAxios('PUT', url, params, successHandler, failureHandler)
    },
    delete: function (url, params, successHandler, failureHandler) {
        return apiAxios('DELETE', url, params, successHandler, failureHandler)
    }
}
