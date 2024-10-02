<template>
  <div>
    <div class="form">
      <el-form   class="filter" :model="filterData" >
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

      <el-form :inline="true"  class="demo-form-inline">


        <el-form-item>
          <el-button type="primary" class="add_btn" size="small" @click="onAdd">添加</el-button>
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
                  width="70"
                  align="center">

          </el-table-column>
          <el-table-column
                  prop="date"
                  label="创建时间"
                  width="250"
                  align="center">
            <template slot-scope="scope">
              <i class="el-icon-time"></i>
              <span style="margin-left: 10px">{{ scope.row.date }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="type"
                  label="收支类型"
                  width="130"
                  align="center">

          </el-table-column>
          <el-table-column
                  prop="describe"
                  label="收支描述"
                  width="200"
                  align="center">

          </el-table-column>
          <el-table-column
                  prop="income"
                  label="收入"
                  width="130"
                  align="center"

          >
            <template slot-scope="scope">

              <span style="color:#00d053">{{ scope.row.income }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="expend"
                  label="支出"
                  width="130"
                  align="center">
            <template slot-scope="scope">

              <span style="color:#f56767">{{ scope.row.expend }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="cash"
                  label="账户现金"
                  width="130"
                  align="center">
            <template slot-scope="scope">

              <span style="color:#4db3ff">{{ scope.row.cash }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  prop="remark"
                  label="备注"
                  width="100"
                  align="center">

          </el-table-column>
          <el-table-column label="操作" align="center">
            <template slot-scope="scope">
              <el-button
                      type="warning"
                      size="mini"
                      @click="handleEdit(scope.$index, scope.row)">编辑</el-button>

              <el-button
                      size="mini"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
    <DialogForm :dialog="dialog" :form_data="form_data" @LoadRefresh="LoadRefresh"></DialogForm>
  </div>

</template>

<script>

  import DialogForm from "../components/DialogForm";
  export default {
    name: "FoundList",
    components:{
      DialogForm
    },
    data(){
      return {
        filterData:{
          startTime:'',
          endTime:''
        },

        tableData:[],//一页的数据
        allTableData:[],//全部页一共有的数据
        form_data:{
          type:'',
          describe:'',
          income:'',
          expend:'',
          cash:'',
          remark:''

        },
        dialog:{
          isShow:false,
          title:'',
          option:''

        },
        pagination:{
          current_page:1 ,//当前的页数
          total:0 ,//总共多少页
          page_size:5,//默认每页显示多少条
          page_sizes:[5,10,15,20],//选择每页显示多少条
          layout:"total, sizes, prev, pager, next, jumper"//组件布局
        }
      }
    },
    created() {
      this.getProfiles()
    },
    methods: {
      getProfiles() {
        this.$axios.get('/profile').then(res => {
          // console.log(res.data);
          //获取到所有数据
          this.allTableData = res.data

          //设置分页数据
          this.setPagination()
        }).catch(err => {
          console.log(err);
        })
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
      handleEdit(index, row) {
        this.form_data.type = row.type
        this.form_data.describe = row.describe
        this.form_data.income = row.income
        this.form_data.expend = row.expend
        this.form_data.cash = row.cash
        this.form_data.id = row._id
        this.form_data.remark = row.remark

        this.dialog.isShow = true
        this.dialog.title = '编辑资金信息'
        this.dialog.option = 'edit'


      },
      handleDelete(index, row) {
        this.$axios.get(`/profile/delete/${row.id}`).then(res =>{
          this.$message({
            message:'删除成功',
            type: 'success',
            center: true
          })
          this.getProfiles()
        })
      },
      onAdd(){
        this.form_data = {}

        this.dialog.isShow = true
        this.dialog.title = '添加资金信息'
        this.dialog.option = 'add'
      },
      LoadRefresh(){
       //再次调用，刷新页面
        this.getProfiles()
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
        this.getProfiles()
        //清除筛选框内容
        this.filterData = {}
        //重新设置分页设置
        this.setPagination()
      }

    }
  }
</script>

<style scoped>
  .filter{
    margin-top:20px;

    box-sizing: border-box;
  }
  .filter_btn{
    margin-left: 30px;
  }
  .demo-form-inline{
    float: right;
    height:60px;

  }
  .add_btn{
    position: absolute;
    right:100px;
    top:-30px;
  }
  .pagination{
    text-align: right;
    margin: 30px;
  }
</style>