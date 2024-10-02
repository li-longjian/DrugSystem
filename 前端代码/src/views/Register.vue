<template>
  <div class="register">
    <section class="from_container">
      <div class="manager_title">
        <span>药品在线招投标系统</span>
      </div>
      <el-form :model="registerUser" status-icon :rules="rules" ref="registerForm" label-width="80px" class="registerForm">
        <el-form-item label="用户名" prop="name" class="el-form-item">
          <el-input type="text" v-model="registerUser.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email" class="el-form-item">
          <el-input type="email" v-model="registerUser.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" class="el-form-item">
          <el-input type="password" v-model="registerUser.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass" class="el-form-item">
          <el-input type="password" v-model="registerUser.checkPass" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="选择身份"  class="el-form-item">
          <el-select v-model="registerUser.identity" prop="identity" placeholder="请选择身份">
           <!-- <el-option label="系统管理员" value="系统管理员" class="option"></el-option>-->
            <el-option label="药品招标单位" value="药品招标单位" class="option"></el-option>
            <el-option label="药品投标单位" value="药品投标单位" class="option"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="el-form-item">
          <el-button type="primary" class="submit_btn" @click="submitForm('registerForm')">注册</el-button>

        </el-form-item>
      </el-form>
    </section>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data(){
      let validatePass2 = (rule, value, callback) => {
        if (value !== this.registerUser.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        registerUser:{
          name:'',
          email:'',
          password:'',
          checkPass:'',
          identity:''
        },
        rules:{
          name: [
            { required: true, message: '用户名不能为空', trigger: 'blur' },
            { min: 1, max: 15, message: '长度在 1 到 15 个字符', trigger: 'blur' }
          ],
          email:[{type:'email',required:true,message:'邮箱格式不正确',trigger:'blur'}],
          password: [
            {required:true,message:'密码不能为空',trigger:'blur'},
            {min:6,max:20,message: '长度在 6 到 20 个字符',trigger: 'blur'}
          ],
          checkPass:[
            {required:true,message:'确认密码不能为空',trigger:'blur'},
            {min:6,max:20,message: '长度在 6 到 20 个字符',trigger: 'blur'},
            {
              validator:validatePass2,
              trigger: 'blur'
            }
          ],

        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate(async(valid) => {
          if (valid) {
            try {
              let res = await this.$axios.post('/user/register', this.$qs.stringify(this.registerUser))
                  // console.log(res);
                  this.$message({
                    message: '注册成功',
                    type: 'success'
                  })
                  this.$router.push('/login')
            }
            catch(error)  {
              console.log(error);
              this.$message({
                message: '邮箱已被注册',
                type: 'error'
              })

            }

          }
        });
      }
    }
    }
</script>

<style scoped>
  *{
    margin:0;
    padding:0;
  }
  .register{
    position: relative;
    width:100%;
    height:800px;

    background: url('../assets/img/bg.jpg') no-repeat center center;
    background-size: 100% 100%;

  }
  .from_container{
    position: relative;
    top:50px;
    left:37%;
    width:350px;
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
  .registerForm {
    margin-top: 20px;
    background-color: #fff;
    padding: 20px 40px 20px 20px;
    border-radius: 5px;
    box-shadow: 0 5px 10px #cccc;
  }
  .el-form-item{
    margin-bottom: 20px;
  }
  .option{
    padding-left:15px;
  }
  .submit_btn {
    width: 100%;
    height:40px;
  }
</style>