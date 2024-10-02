import axios from 'axios'
import { Loading,Message  } from 'element-ui'
import router from '../router'
axios.defaults.baseURL = 'http://localhost:3000'
axios.defaults.timeout = 10000


let loading
//开始显示loading图标
function startLoading() {
  loading = Loading.service({
    lock:true,
    text:'加载中',
    background:'rgba(0,0,0,.6)'
  })
}

//关闭lodaing图标
function endLoading() {
  loading.close()

}


/**
 * 请求拦截
 *
 * 用户登录后，在localStorage里缓存有token，在用户请求之前应当把token放在请求头里面
 */
// axios.interceptors.request.use(config =>{
//   //请求之前显示Loading动画
//   startLoading()
//   if(localStorage.eleToken){
//     config.headers.Authorization = localStorage.eleToken
//   }

//   return config
// },error => {
//   return Promise.reject(error)
// })

/**
 * 响应拦截
 */
// axios.interceptors.response.use(response =>{
//   //结束Loading显示
//   endLoading()
//   return response
// },error =>{
//   endLoading()
//   // Message.error(error.response.data)
//   //获取错误状态码
//   const {status } = error.response
//   //如果=== 401 这说明token失效
//   if(status === 401){
//     //需要将失效的token清除并返回登录页面
//     Message.error('登录过期，请重新登录')
//     localStorage.removeItem("eleToken")
//     router.push('/login')
//   }
//   return Promise.reject(error)
// })


export default axios