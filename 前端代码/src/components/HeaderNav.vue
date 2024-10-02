<template>
  <div id="Head">
    <header class="head-nav">
      <el-row>
        <el-col :span="6" class="logo-container">
          <img src="../assets/img/logo.png" class="logo">
          <span class="title">药品在线招投标系统</span>
        </el-col>

        <el-col :span="6" class="user">
          <div class="userInfo">
            <img src="../assets/img/user.png" alt="" class="avatar">
            <div class="welcome">
              <p class="comename">欢迎</p>
              <p class="avatarname">{{user.name}}</p>
            </div>
            <span class="usernameInfo">
              <el-dropdown trigger="click" @command="handleUserInfo" >
              <span class="el-dropdown-link">
             <i class="el-icon-caret-bottom el-icon--right"></i>
              </span>
                <el-dropdown-menu slot="dropdown" >
                  <el-dropdown-item command="userInfo">个人信息</el-dropdown-item>
                   <el-dropdown-item command="loginOut">退出登录</el-dropdown-item>

               </el-dropdown-menu>
              </el-dropdown>
            </span>
          </div>
        </el-col>
      </el-row>

    </header>

  </div>
</template>

<script>
  export default {
    name: "HeaderNav",
    data(){
      return {
        user: this.$store.state.user
      }
    },
    methods:{
      handleUserInfo(command){
        switch (command) {
          case "userInfo" :
            this.toUserInfoPage()
            break;
          case "loginOut" :
            this.toLoginPage()
            break;
        }
      },
      toUserInfoPage(){
          this.$router.push('/infoShow')
      },
      toLoginPage(){

        //将本地缓存中的token清除
        // localStorage.removeItem('eleToken')
        //  并且将store中的存储的用户信息清除
        this.$store.commit('clearUserInfo')
        //退出页面并跳转回登录页
        this.$router.push('/login')
      }
    }
  }
</script>

<style scoped>
  *{margin:0;padding: 0}
  .head-nav {
    width: 100%;
    height: 60px;
    min-width: 600px;
    padding: 5px;
    background: #324057;
    color: #fff;
    border-bottom: 1px solid #1f2d3d;

  }
  .logo-container {
    line-height: 60px;
    min-width: 400px;
  }
  .logo {
    height: 50px;
    width: 50px;
    margin-right: 5px;
    vertical-align: middle;
    display: inline-block;
  }
  .title {
    vertical-align: middle;
    font-size: 22px;
    padding-left: 10px;
    letter-spacing: 5px;
  }
  .userInfo{
    height:60px;
    line-height: 60px;


  }
  .user {
    height:60px;
    line-height: 60px;
    text-align: right;
    float: right;
    padding-right: 50px;
  }
  .avatar {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    /*vertical-align: middle;*/
    display: inline-block;
    background-color: #a6a6a6;
    border: 1px solid #fff;
    padding: 5px;
  }
  .welcome {
    display: inline-block;
    width: auto;
    vertical-align: middle;
    padding: 0 5px;

  }

  .comename {
    font-size: 12px;
    padding-right: 10px;
  }
  .avatarname {
    color: #409eff;
    font-weight: bolder;
    position: relative;
    top:-35px;
  }
  .el-dropdown-link {
    cursor: pointer;
    color: #ffffff;

  }

</style>