<template>
  <div id="NewsShow">
    <template>
      <el-table
              :data="tableData"
              style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="时间">
                <span>{{ props.row.date }}</span>
              </el-form-item>
              <el-form-item label="项目编号">
                <span>{{ props.row.number }}</span>
              </el-form-item>
              <el-form-item label="公司名称">
                <span>{{  props.row.companyName }}</span>
              </el-form-item>

              <el-form-item label="药品名称">
                <span>{{ props.row.drugName }}</span>
              </el-form-item>
              <el-form-item label="制药单位">
                <span>{{ props.row.companyName }}</span>
              </el-form-item>
              <el-form-item label="包装要求">
                <span>{{ props.row.Package }}</span>
              </el-form-item>
              <el-form-item label="截止日期">
                <span>{{ props.row.expirationDate }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
                label="项目编号"
                prop="number">
        </el-table-column>
        <el-table-column
                label="公司名称"
                prop="companyName">
        </el-table-column>
        <el-table-column
                label="时间"
                prop="date">
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
  export default {
    name: "NewsShow",
    props:{
      tableData:[]
    },
    data(){
      return{

      }

    },
    methods:{

    }
  }
</script>

<style scoped>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>