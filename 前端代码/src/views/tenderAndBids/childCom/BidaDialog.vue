
<!--投标信息弹窗-->

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


          <!-- <el-form-item label="投标日期:" prop="bidsTime">
            <el-date-picker
                    v-model="form_data.date"
                    type="datetime"
                    placeholder="选择日期时间"
                    >
            </el-date-picker>
          </el-form-item> -->
          <el-form-item prop='legalName' label="法人姓名">
            <el-input  v-model="form_data.legalName"></el-input>
          </el-form-item>

          <el-form-item prop='phone' label="联系电话">
            <el-input  v-model="form_data.phone"></el-input>
          </el-form-item>

          <el-form-item prop='zbnumber' label="招标项目编号">
            <el-input  v-model="form_data.zbnumber"></el-input>
          </el-form-item>

          <el-form-item label="状态" prop="status">
            <el-input  v-model="form_data.status"></el-input>
          </el-form-item>

          <el-form-item label="投标单位" prop="companName">
            <el-input  v-model="form_data.companName"></el-input>
          </el-form-item>

          <el-form-item prop='bailTotal' label="投标总金额">
            <el-input  v-model="form_data.bailTotal"></el-input>
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
    name: "BidDialog",
    props: {
      dialog: Object,
      form_data:{}

    },
    data() {
      return {

        user:this.$store.state.user,//获取当前账户登录信息

        form_rules: {
          LegalName: [
            { required: true, message: "法人姓名不能为空！", trigger: "blur" }
          ],
          phone: [
            { required: true, message: "联系电话不能为空！", trigger: "blur" }
          ],
          number: [
            { required: true, message: "招标项目编号不能为空！", trigger: "blur" }
          ],
          companyName: [
            { required: true, message: "投标单位不能为空！", trigger: "blur" }
          ],
          bailTotal: [
            { required: true, message: "投标总金额不能为空！", trigger: "blur" }
          ],
          paymentDate: [
            { required: true, message: "保证缴款日期不能为空！", trigger: "blur" }
          ],

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

              let res = await this.$axios.post('/tb/add',this.$qs.stringify({
                // date:this.form_data.date,
                legalName:this.form_data.legalName,
                phone:this.form_data.phone,
                zbnumber:this.form_data.zbnumber,
                companName:this.form_data.companName,
                bailTotal:this.form_data.bailTotal,
                announcer:localStorage.email
              }))
                this.$message({
                  message:'申请投标成功',
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
            else if(option === 'edit'){


              this.$axios.post('/tb/update',this.$qs.stringify({
                date:this.form_data.date,
                legalName:this.form_data.legalName,
                phone:this.form_data.phone,
                zbnumber:this.form_data.zbnumber,
                number:this.form_data.number,
                companName:this.form_data.companName,
                bailTotal:this.form_data.bailTotal,
                announcer:localStorage.email
              })).then(res =>{
                this.$message({
                  message:'修改成功',
                  type: 'success',
                  center: true
                })
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

