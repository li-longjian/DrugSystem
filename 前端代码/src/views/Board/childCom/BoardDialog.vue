<template>
  <div class="logFund">
    <el-dialog
            :title="dialog.title"
            :visible.sync="dialog.isShow"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body="false">
      <div class="form">
        <el-form
                ref="form"
                :model="form_data"
                :rules="form_rules"
                label-width="120px"
                style="margin:10px;width:auto;">

          <el-form-item label="注册公司名称:" prop="companyName">
            <el-input type="textarea" v-model="form_data.companyName"></el-input>
          </el-form-item>

          <el-form-item label="发布者:" prop="announcer">
            <el-input type="textarea" v-model="form_data.announcer" readOnly ></el-input>
          </el-form-item>

          <el-form-item label="留言信息:" prop="describe">
            <el-input type="textarea" v-model="form_data.describe"></el-input>
          </el-form-item>

          <el-form-item  class="text_right">
            <el-button @click="onCancel">取 消</el-button>
            <el-button type="primary" @click='onSubmit("form")'>提  交</el-button>
          </el-form-item>

        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "BoardDialog",
    props: {
      dialog: Object,
      form_data:{},
    },
    data() {
      return {
        // user:this.$store.state.user,
        form_rules: {
          describe: [
            { required: true, message: "留言不能为空！", trigger: "blur" }
          ]
        }
      };
    },
    methods: {
      onCancel(){
        this.dialog.isShow = false
      },
       onSubmit(form) {
        this.$refs[form].validate(async valid => {
          if (valid) {

            const option = this.dialog.option
            // this.form_data.announcer = this.user.id;
            if(option === 'add'){

              let res = await this.$axios.post('/msg/add',this.$qs.stringify(this.form_data))
                console.log(res);
                this.$message({
                  message:'发布留言成功',
                  type: 'success',
                  center: true
                })
          
              // 并且自定义事件到父组件刷新
              this.$parent.getMessages()
              //关闭弹窗
              this.dialog.isShow = false
              // //清除输入框内容
              this.form_data = {}
            }
            else if(option === 'edit'){

              let res = await this.$axios.post('/msg/update',this.$qs.stringify({
                id:this.form_data.id,
                announcer:this.form_data.announcer,
                describe:this.form_data.describe,
                companyName:this.form_data.companyName
              }))
                this.$message({
                  message:'修改成功',
                  type: 'success',
                  center: true
                })
        
              //关闭弹窗
              this.dialog.isShow = false
              // //清除输入框内容
              // this.form_data = {}
              // 并且自定义事件到父组件刷新
              this.$parent.getMessages()
            }




          }
        })
      }
    }
  };
</script>

