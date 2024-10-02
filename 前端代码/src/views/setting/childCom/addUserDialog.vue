<template>
  <div class="logFund">
    <el-dialog
            :title="dialog.title"
            :visible.sync="dialog.isShow"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body="false">
      <div class="form">
        <el-form :model="form_data" status-icon :rules="form_rules" ref="registerForm" label-width="80px"
                 class="registerForm">
          <el-form-item label="用户名" prop="name" class="el-form-item">
            <el-input type="text" v-model="form_data.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email" class="el-form-item">
            <el-input type="email" v-model="form_data.email" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item  label="密码" prop="password" class="el-form-item">
            <el-input type="password" v-model="form_data.password" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="选择身份" class="el-form-item">
            <el-select v-model="form_data.identity" prop="identity" placeholder="请选择身份">
               <el-option label="系统管理员" value="系统管理员" class="option"></el-option>
              <el-option label="药品招标单位" value="药品招标单位" class="option"></el-option>
              <el-option label="药品投标单位" value="药品投标单位" class="option"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item class="el-form-item">
            <el-button v-if="dialog.option==='add' " type="primary" class="submit_btn" @click="submitForm('registerForm')">添加</el-button>
            <el-button v-if="dialog.option==='edit' " type="primary" class="submit_btn" @click="submitForm('registerForm')">编辑</el-button>

          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "addUserDialog",
    props: {
      dialog: Object,
      form_data: {}

    },
    data() {
      return {


        form_rules: {
          email: [
            {required: true, message: "邮箱必填！", trigger: "blur"}
          ],
          password: [
            {required: true, message: "密码必填！", trigger: "blur"}
          ],
          identity: [
            {required: true, message: "身份必填！", trigger: "blur"}
          ]

        }
      };
    },
    methods: {
      onCancel() {
        this.dialog.isShow = false
      },

      //----------------------------------

      submitForm(form) {
        this.$refs[form].validate(async valid => {
          if (valid) {

            const option = this.dialog.option
            //设置管理员
            if (this.form_data.identity === '管理员') {
              this.form_data.isAdmin = 1
            }
            if (option === 'add') {
              try {
                let res = await this.$axios.post('/user/register', this.$qs.stringify({
                  email:this.form_data.email,
                  name:this.form_data.name,
                  password:this.form_data.password,
                  identity:this.form_data.identity,
                  isAdmin:this.form_data.isAdmin
                }))
                console.log(res);
                this.$message({
                  message: '增加用户成功',
                  type: 'success',
                  center: true
                })
              } catch(error) {
                console.log(error);
                this.$message({
                  message: '邮箱已被注册',
                  type: 'error'
                })

              }
              this.$parent.getUsers()
              //关闭弹窗
              this.dialog.isShow = false
              // //清除输入框内容
              // this.form_data = {}
              // 并且自定义事件到父组件刷新

            }

            //处理编辑功能：
            if (option === 'edit'){
              try {
                let res = await this.$axios.post('/user/update',this.$qs.stringify(this.form_data))
                this.$message({
                  message:'修改成功',
                  type: 'success',
                  center: true
                })
              } catch(err) {
                console.log(err);
                this.$message({
                  message:'修改失败',
                  type: 'error',
                  center: true
                })
              }
              //关闭弹窗
              this.dialog.isShow = false
              //重新刷新页面
              this.$parent.getUsers()

            }

          }
        })

      }


    }
  }
</script>

