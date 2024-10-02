<template>
  <div id="Board">
    <h2>我的招标信息</h2>
    <div class="form">
      <el-form class="filter" :model="filterData">
        <el-date-picker
                v-model="filterData.startTime"
                type="datetime"
                placeholder="选择开始时间"
                default-time="12:00:00">
        </el-date-picker>
        --
        <el-date-picker
                v-model="filterData.endTime"
                type="datetime"
                placeholder="选择结束时间"
                default-time="12:00:00">
        </el-date-picker>
        <el-button type="primary" class="filter_btn" size="small" @click="handleFilter">筛选</el-button>
        <el-button type="primary" class="filter_btn" size="small" @click="reSetFilter">重置</el-button>
      </el-form>

      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-button type="primary" class="add_btn" size="small" @click="onAddMessage">发布招标信息</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div>
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
                  label="公司名称"
                  width="130"
                  align="center">
            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.companyName }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="number"
                  label="招标项目编号"
                  width="120"
                  align="center">

            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.number }}</span>
            </template>
          </el-table-column>


          <el-table-column
                  prop="drugName"
                  label="药品名称"
                  width="150"
                  align="center">
            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.drugName }}</span>
            </template>
          </el-table-column>

          <el-table-column
                  prop="companyName"
                  label="制药单位"
                  width="155"
                  align="center">
            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.companyName }}</span>
            </template>
          </el-table-column>

          <el-table-column
                  prop="Package"
                  label="包装要求"
                  width="225"
                  align="center">
            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.Package }}</span>
            </template>
          </el-table-column>

          <el-table-column
                  prop="Total"
                  label="总量"
                  width="200"
                  align="center">
            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.Total }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="expirationDate"
                  label="截止日期"
                  width="200"
                  align="center">
            <template slot-scope="scope">

              <span style="margin-left: 10px">{{ scope.row.expirationDate }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="bail"
                  label="保证金"
                  width="200"
                  align="center">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.bail }}</span>
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
    </div>
<tander-dialog :form_data="form_data" :dialog="dialog" @LoadRefresh="LoadRefresh"></tander-dialog>
  </div>

</template>

<script>

import TanderDialog from "./childCom/TanderDialog";


  export default {
    name: "Bids",
    components: {TanderDialog},
    data() {
      return {
        user:this.$store.state.user,
        filterData: {
          startTime: '',
          endTime: ''
        },

        tableData: [],//一页的数据
        allTableData: [],//全部页一共有的数据
        form_data: {
          number: '',
          drugName: '',
          companyName: '',
          Package:'',
          Total:'',
          expirationDate:'',
          bail:'',
          announcer:''

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
      this.getMessages();

    },
    methods:{
      async getMessages(){
        let res = await this.$axios.get("/tender")

          this.allTableData = res.data
         /* console.log(this.allTableData)*/
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
      LoadRefresh(){
        //再次调用，刷新页面
        this.getMessages()
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
      handleFilter(){
        //如果筛选的时间区域为空
        if(!this.filterData.startTime || !this.filterData.endTime){
          this.$message({
            message:'请选择筛选时间段',
            type:'warning'
          })
          this.getProfiles()
          return
        }

        const start = this.filterData.startTime.getTime()
        const end = this.filterData.endTime.getTime()

        this.allTableData = this.allTableData.filter(item =>{
          //格式化获取的时间
          const time = new Date(item.date).getTime()
          return time >= start && time<=end

        })
        //必须重新设置分页设置，否则无法显示筛选结果
        this.setPagination()


      },
      reSetFilter(){
        //重新获取数据
        this.getMessages()
        //清除筛选框内容
        this.filterData = {}
        //重新设置分页设置
        this.setPagination()
      },

      onAddMessage(){
        this.form_data = {}
        this.dialog.isShow = true
        this.dialog.title = "发布招标信息"
        this.dialog.option ="add"
      },
      //编辑：
      handleEdit(index, row){
        this.form_data.number = row.number
        this.form_data.drugName = row.drugName
        this.form_data.companyName = row.companyName
        this.form_data.id = row._id;
        this.form_data.Package = row.Package
        this.form_data.Total = row.Total
        this.form_data.expirationDate = row.expirationDate
        this.form_data.bail = row.bail



        this.dialog.isShow = true
        this.dialog.title = '编辑招标信息'
        this.dialog.option = 'edit'
      },
      //删除一条信息
      async handleDelete(index, row) {
        let res = await this.$axios.get(`/tender/delete/${row.id}`)
          this.$message({
            message:'删除成功',
            type: 'success',
            center: true
          })
          //重新刷新
          this.getMessages()
      },


    }

  }
</script>

<style scoped>
  #Board{
    margin:10px;
  }
  .filter {
    margin-top: 20px;

    box-sizing: border-box;
  }

  .filter_btn {
    margin-left: 30px;
  }

  .demo-form-inline {
    float: right;
    height: 60px;

  }

  .add_btn {
    position: absolute;
    right: 200px;
    top: -45px;
  }

  .pagination {
    text-align: right;
    margin: 30px 100px ;
  }
</style>