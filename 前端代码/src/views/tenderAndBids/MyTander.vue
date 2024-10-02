<template>
  <div>
    <rl-row :gutter="20">
      <h2>我的招标信息</h2>

        <el-button type="success" class="add_btn" size="medium" @click="onAddMessage">发布招标信息</el-button>



    </rl-row>


    <el-row :gutter="20" class="content">

     <el-col :span="12"  v-for="(item,index) in tableData" :key="index">
        <div class="grid-content bg-purple">
          <el-descriptions title="招标信息" column="2" border>
            <el-descriptions-item label="时间">{{item.date}}</el-descriptions-item>
            <el-descriptions-item label="项目编号">{{item.number}}</el-descriptions-item>
            <el-descriptions-item label="公司名称">{{item.companyName}}</el-descriptions-item>
            <el-descriptions-item label="药品名称">{{item.durgName}}</el-descriptions-item>
            <el-descriptions-item label="包装要求">{{item.packaged}}</el-descriptions-item>
            <!-- <el-descriptions-item label="截止日期">{{item.expirationDate}}</el-descriptions-item> -->
            <el-descriptions-item label="状态">

              <el-tag size="small">待投标</el-tag>

            </el-descriptions-item>
            <el-descriptions-item label="操作一">
              <el-button
                      type="warning"
                      size="mini"
                      @click="handleEdit(index,item)">
                编辑
              </el-button>
            </el-descriptions-item>
            <el-descriptions-item label="操作二">
              <el-popconfirm
                      title="确定删除吗？"
                      icon="el-icon-info"

                      @confirm="handleDelete(index,item)"
              >
                <el-button slot="reference" size="mini" type="danger">删除</el-button>
              </el-popconfirm>
            </el-descriptions-item>

          </el-descriptions>
        </div>
      </el-col>

    </el-row>

    <tander-dialog
        :dialog="dialog" :form_data="form_data"
    ></tander-dialog>
  </div>
</template>

<script>
  import TanderDialog from "./childCom/TanderDialog";
  export default {
    name: "MyTander",
    components:{TanderDialog},
    data(){
      return{
        user :this.$store.state.user,
        tableData:[],
        //增加留言信息
        dialog:{
          isShow:false,//默认编辑框隐藏
          title:'',//操作标题
          option:''//操作

        },
        form_data: {
          durgName: '',
          companyName: '',
          total: '',
          packaged:'',
          announcer:'',
          status: 0,
          marked:'',

        },

      }
    },
    created() {
      this.getMessages()
    },
    methods:{
      /**
       * 根据用户id查找用户发表的招标信息
       */
      async getMessages(){
        let res = await this.$axios.get('/zb/get/ema', {
          params:{
            email: localStorage.email
          }
        })
          console.log(res);
          this.tableData = res.data
      },

      onAddMessage(){
        this.form_data = {}
        this.form_data.announcer = localStorage.email
        this.form_data.status = 0
        this.dialog.isShow = true
        this.dialog.title = "发布招标信息"
        this.dialog.option ="add"
      },
      handleEdit(index,item){
        this.form_data = item
        this.form_data.id = item.id

        this.dialog.isShow = true
        this.dialog.title = '编辑招标信息'
        this.dialog.option = 'edit'
      },

      async handleDelete(index,item){
        let res = await this.$axios.get(`/zb/del/${item.id}`)
          this.$message({
            message:'删除成功',
            type: 'success',
            center: true
          })
          //重新刷新
          this.getMessages()
      }



    }

  }
</script>

<style scoped>
.content{
  margin-top: 20px;
}
  .add_btn{
    margin-top:20px;
    margin-left: 10px;
  }

</style>