<template>
  <div class="Login">
    <section class="from_container">
      <div class="manager_title">
        <span>药品在线招投标系统</span>
      </div>
      <el-form :model="LoginUser" status-icon :rules="rules" ref="loginForm" label-width="80px" class="LoginForm">

        <el-form-item label="邮箱" prop="email" class="el-form-item">
          <el-input type="email" v-model="LoginUser.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" class="el-form-item">
          <el-input type="password" v-model="LoginUser.password" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item class="el-form-item">
          <el-button type="primary" class="submit_btn"  @click="submitForm('loginForm')">登录</el-button>

        </el-form-item>

        <div class="toRegister">还没有账号？ <router-link to="/register">立即注册</router-link></div>

      </el-form>
    </section>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data(){

      return {
        LoginUser:{

          email:'',
          password:'',

        },
        rules:{

          email:[{type:'email',required:true,message:'邮箱格式不正确',trigger:'blur'}],
          password: [
            {required:true,message:'密码不能为空',trigger:'blur'},
            {min:6,max:20,message: '长度在 6 到 20 个字符',trigger: 'blur'}
          ],


        }
      }
    },
    methods:{
      submitForm(formName){
        this.$refs[formName].validate(async(valid) =>{
          if(valid){
            let res = await this.$axios.post('/user/login',this.$qs.stringify({
                email: this.LoginUser.email,
                password: this.LoginUser.password
            })
            )
                
              if(res.status == 200) {
                    console.log(res);
                    localStorage.setItem('email',res.data.user.email)
                    this.$store.commit('setUser',res.data.user)
                    //进入主页
                    this.$router.push('/index')
                  } else {
                      this.$message({
                      message: '密码或账号错误',
                      type: 'error'
                  })
                }

          }
        })

      }
    }

  }
</script>

<style scoped>
  *{
    margin:0;
    padding:0;

  }
  .Login{
    position: relative;
    width:100%;
    height:800px;
    /*height:100%;*/
    background: url('../assets/img/bg.jpg') no-repeat ;
    background-size: 100% 100%;

  }
  .from_container{
    position: relative;
    top:50px;
    left:35%;
    width:450px;
    height:550px;

  }
  .manager_title{
    width:100%;
    height:40px;

    line-height: 40px;
    text-align: center;
    color:#ffffff;
    font-size:24px;
    letter-spacing: 3px;
  }
  .LoginForm {
    margin-top: 20px;
    background-color: #fff;
    padding: 20px 40px 20px 20px;
    border-radius: 5px;
    box-shadow: 0px 5px 10px #cccc;
  }
  .el-form-item{
    margin-bottom: 20px;
  }

  .toRegister{
    margin:20px;
    position: absolute;
    right:20px;
    top:230px;
  }
  .submit_btn {
    width: 100%;
    height:40px;
  }
</style>