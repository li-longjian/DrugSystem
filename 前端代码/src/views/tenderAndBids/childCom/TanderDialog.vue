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

<!-- 
          <el-form-item label="招标项目编号:" prop="number">
            <el-input  v-model="form_data.number"></el-input>
          </el-form-item> -->
          <el-form-item prop='durgName' label="药品名称">
            <el-input  v-model="form_data.durgName"></el-input>
          </el-form-item>

          <el-form-item prop='companyName' label="制药单位">
            <el-input  v-model="form_data.companyName"></el-input>
          </el-form-item>

          <el-form-item prop='packaged' label="包装要求">
            <el-input  v-model="form_data.packaged"></el-input>
          </el-form-item>

          <el-form-item prop='total' label="总量">
            <el-input  v-model="form_data.total"></el-input>
          </el-form-item>

          <!-- <el-form-item label="招标截止日期" prop="expirationDate">
            <el-input  v-model="form_data.expirationDate"></el-input>
          </el-form-item> -->
          <!-- <el-form-item label="招标截止日期:" prop="expirationDate">
            <el-date-picker
                    v-model="form_data.expirationDate"
                    type="datetime"
                    placeholder="选择日期时间"
                    >
            </el-date-picker>
          </el-form-item> -->

          <el-form-item label="发布者邮箱" prop="announcer">
            <el-input  v-model="form_data.announcer" readOnly></el-input>
          </el-form-item>

          <el-form-item label="当前状态" prop="status ">
            <el-input  v-model="form_data.status " readOnly></el-input>
          </el-form-item>

          <el-form-item label="留言信息" prop="marked">
            <el-input  v-model="form_data.marked"></el-input>
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
    name: "TanderDialog",
    props: {
      dialog: Object,
      form_data:{},
      // form_data:{
      //   number,
      //   durgName,
      //   companyName,
      //   packaged,
      //   total,
      //   announcer,
      //   status,
      //   marked
      // }

    },
    data() {
      return {

        user:this.$store.state.user,
        form_rules: {
          drugName: [
            { required: true, message: "药品名称不能为空！", trigger: "blur" }
          ],
          Package: [
            { required: true, message: "包装要求不能为空！", trigger: "blur" }
          ],
          // number: [
          //   { required: true, message: "招标项目编号不能为空！", trigger: "blur" }
          // ],
          companyName: [
            { required: true, message: "制药单位不能为空！", trigger: "blur" }
          ],
          expirationDate: [
            { required: true, message: "招标截止日期不能为空！", trigger: "blur" }
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

            // this.form_data.announcer = this.user.id;//获取信息发布者账号id

            if(option === 'add'){

              let res = await this.$axios.post('/zb/add',this.$qs.stringify({
                // number:'',
                durgName:this.form_data.durgName,
                companyName:this.form_data.companyName,
                packaged:this.form_data.packaged,
                total:this.form_data.total,
                // expirationDate:this.form_data.expirationDate,
                announcer:this.form_data.announcer,
                status:this.form_data.status,
                marked:this.form_data.marked,
                }))
                  console.log(res);
                this.$message({
                  message:'发布招标成功',
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
              //修改招标信息请求
              let res = await this.$axios.post('/zb/update',this.$qs.stringify({
                number:this.form_data.number,
                durgName:this.form_data.durgName,
                companyName:this.form_data.companyName,
                packaged:this.form_data.packaged,
                total:this.form_data.total,
                announcer:this.form_data.announcer,
                status:this.form_data.status,
                marked:this.form_data.marked,
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

