<template>
  <div>
    <h3 class="title">用户信息管理</h3>
      <el-button type="success" round size="medium" @click="addUser" class="addUser">添加用户</el-button>
    <template>
      <el-table
              :data="tableData"
              style="width: 100%"
              max-height="450"
              border
      >

        <el-table-column
                type="index"
                label="序号"
                width="75"
                align="center">

        </el-table-column>
        <el-table-column
                prop="date"
                label="创建时间"
                width="230"
                align="center">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.date }}</span>
          </template>
        </el-table-column>
        <el-table-column
                prop="name"
                label="用户账号"
                width="130"
                align="center">
          <template slot-scope="scope">

            <span style="margin-left: 10px">{{ scope.row.name }}</span>
          </template>
        </el-table-column>

        <el-table-column
                prop="email"
                label="用户邮箱"
                width="130"
                align="center">
          <template slot-scope="scope">

            <span style="margin-left: 10px">{{ scope.row.email }}</span>
          </template>
        </el-table-column>

        <el-table-column
                prop="name"
                label="用户身份"
                width="130"
                align="center">
          <template slot-scope="scope">

            <span style="margin-left: 10px">{{ scope.row.identity}}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作1" align="center" width="100">
          <template slot-scope="scope">
            <el-button
                    type="warning"

                    @click="handleEdit(scope.$index, scope.row)">编辑</el-button>

            <!-- <el-button
                     size="mini"
                     type="danger"
                     @click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
          </template>

        </el-table-column>
        <el-table-column label="操作2" align="center" width="100">
          <template slot-scope="scope">
            <el-popconfirm
                    title="确定删除吗？"
                    icon="el-icon-info"
                    @confirm="handleDelete(scope.$index, scope.row)"

            >
              <el-button slot="reference" >删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>


        <!--<el-table-column
                prop="name"
                label="设置管理员"
                width="130"
                align="center">
          <template slot-scope="scope">
&lt;!&ndash;            :content="'Switch value: ' + value"  placement="top"&ndash;&gt;
            <el-switch
                    v-model="value"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    active-value= true
                    inactive-value=false
                    @change="switchChange(scope.$index, scope.row)"

            >
            </el-switch>
          </template>
        </el-table-column>-->

      </el-table>


      <!--        分页-->
      <el-row>
        <el-col :span="24">
          <div class="pagination">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page.sync="pagination.current_page"
                    :page-sizes="pagination.page_sizes"
                    :page-size="pagination.page_size"
                    :layout="pagination.layout"
                    :total="pagination.total">
            </el-pagination>
          </div>

        </el-col>
      </el-row>

    </template>
    <add-user-dialog :form_data="form_data" :dialog="dialog"></add-user-dialog>
  </div>


</template>

<script>

  import addUserDialog from "./childCom/addUserDialog";

  export default {
    name: "SetAdmin",
    components:{addUserDialog},
    data() {
      return {

        user:this.$store.state.user,


        tableData: [],//一页的数据
        allTableData: [],//全部页一共有的数据
        form_data: {
          name: '',
          email: '',
          passwoed:'',
          identity: '',
          id:''
        },

        pagination: {
          current_page: 1,//当前的页数
          total: 0,//总共多少页
          page_size: 5,//默认每页显示多少条
          page_sizes: [5, 10, 15, 20],//选择每页显示多少条
          layout: "total, sizes, prev, pager, next, jumper"//组件布局
        },
        //增加留言信息
        dialog:{
          isShow:false,//默认编辑框隐藏
          title:'',//操作标题
          option:''//操作

        },
      }
    },
    created() {
      this.getUsers()
    },
    methods:{

      async getUsers() {
        let res = await this.$axios.get('/user/getAll')
          this.allTableData = res.data
          this.setPagination()
      },
      setPagination(){

        //初始化Pagination的数据
        this.pagination.total = this.allTableData.length
        this.pagination.current_page = 1
        this.pagination.page_size = 5

        //设置默认的分页数据
        this.tableData = this.allTableData.filter( (item,index) => {
          return index < this.pagination.page_size
        })
      },
      handleSizeChange(page_size){
        this.pagination.page_size = page_size
        //设置分页数据
        this.tableData = this.allTableData.filter( (item,index) => {
          return index < this.pagination.page_size
        })

      },
      handleCurrentChange(page){
        this.pagination.current_page = page
        // 此页最小值在全部数据中的下标
        const index = this.pagination.page_size * (page-1)
        // //此页最大值在全部数据中的下标
        const nums = this.pagination.page_size * page
        //
        let tabDate = []
        for(let i = index;i< nums;i++ ){
          //判断下标是否越界
          if(this.allTableData[i]){
            tabDate.push(this.allTableData[i])
          }
          this.tableData = tabDate
        }

      },
      //注销用户
      async handleDelete(index, row) {
        let res = await this.$axios.get(`/user/del/${row.id}`)
          this.$message({
            message:'删除成功',
            type: 'success',
            center: true
          })
          //重新刷新
          this.getUsers()
      },
      addUser(){
        this.dialog.isShow = true
        this.dialog.title = '添加用户'
        this.dialog.option = 'add'
      },
      handleEdit(index, row){
        this.form_data.email = row.email
        this.form_data.name = row.name
        this.form_data.identity =row.identity
        this.form_data.id = row._id


        this.dialog.isShow = true
        this.dialog.title = '编辑用户信息'
        this.dialog.option = 'edit'
      }
  },
  //增加用户

      //获取身份

      //设置管理员身份
     /* switchChange(index,row){

      }*/


  }
</script>

<style scoped>
  title{
    padding-left: 50px !important;
  }
  .addUser{
    margin-top: 20px;
    margin-bottom: 20px;
    margin-left: 20px;
  }
</style>