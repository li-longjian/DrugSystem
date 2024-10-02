import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  user:{},
  isAdmin: 0,
}
const mutations = {

  setAdmin(state,isAdmin){
    state.user.isAdmin = isAdmin;
  },
  setUser(state,user){
    if(user){
      state.user = user
    }else{
      state.user = {}
    }

  },
  clearUserInfo(state){
    state.user = {}
  }
}

export default new Vuex.Store({
  state,
  mutations
})
