import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from './network/request'
import qs from 'qs'
Vue.prototype.$axios = axios
Vue.prototype.$qs = qs
Vue.config.productionTip = false

Vue.use(ElementUI);


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
