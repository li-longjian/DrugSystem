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

          <el-form-item label="收支类型:" >
            <el-select v-model="form_data.type" placeholder="收支类型">
              <el-option
                      v-for="(formtype, index) in format_type_list"
                      :key="index"
                      :label="formtype" :value="formtype"
              ></el-option>
            </el-select>
          </el-form-item>

          <el-form-item prop='describe' label="收支描述:">
            <el-input type="describe" v-model="form_data.describe"></el-input>
          </el-form-item>

          <el-form-item prop='income'  label="收入:">
            <el-input type="income" v-model="form_data.income"></el-input>
          </el-form-item>

          <el-form-item prop='expend' label="支出:">
            <el-input type="expend" v-model="form_data.expend"></el-input>
          </el-form-item>

          <el-form-item prop='cash' label="账户现金:">
            <el-input type="cash" v-model="form_data.cash"></el-input>
          </el-form-item>

          <el-form-item label="备注:">
            <el-input type="textarea" v-model="form_data.remark"></el-input>
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
    name: "DialogForm",
    props: {
      dialog: Object,
      form_data:{}

    },
    data() {
      return {

        format_type_list: [
          "提现",
          "提现手续费",
          "充值",
          "优惠券",
          "充值礼券",
          "转账"
        ],
        form_rules: {
          describe: [
            { required: true, message: "收支描述不能为空！", trigger: "blur" }
          ],
          income: [
            { required: true, message: "收入不能为空！", trigger: "blur" }
          ],
          expend: [
            { required: true, message: "支出不能为空！", trigger: "blur" }
          ],
          cash: [{ required: true, message: "账户不能为空！", trigger: "blur" }]
        }
      };
    },
    methods: {
      onCancel(){
        this.dialog.isShow = false
        // this.form_data = {}

      },
      onSubmit(form) {
        this.$refs[form].validate(valid => {
          if (valid) {

            const option = this.dialog.option

            if(option === 'add'){

              this.$axios.post('/profile/add',this.form_data).then(res =>{
                // console.log(res);
                this.$message({
                  message:'保存成功',
                  type: 'success',
                  center: true
                })
              })
              //关闭弹窗
              this.dialog.isShow = false
              // //清除输入框内容
              // this.form_data = {}
              // 并且自定义事件到父组件刷新
              this.$emit('LoadRefresh')
            }
            else if(option === 'edit'){

              this.$axios.post(`/edit/${this.form_data.id}`,this.form_data).then(res =>{
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
              this.$emit('LoadRefresh')
            }




          }
        })
      }
    }
  };
</script>

