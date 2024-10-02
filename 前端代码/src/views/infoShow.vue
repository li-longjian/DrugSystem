<template>
  <div class="wrapper">
    <el-row>
      <el-col :span="8" class="left">
        <img  src="../assets/img/user.png" alt="" class="avatar">
      </el-col>
      <el-col :span="16" class="right">
        <div class="rightContent">
          <div class="rightContentItem">
            <img src="../assets/img/user_mini.png" alt="">
            <span class="username">{{user.name}}</span>
          </div>
          <div class="rightContentItem">
            <img src="../assets/img/setting.png" alt="">
            <span class="identity">{{user.identity}}</span>
          </div>
        </div>


      </el-col>

    </el-row>
  </div>
</template>

<script>
  export default {
    name: "infoShow",
    data(){
      return {
        user:this.$store.state.user
      }
    }
  }
</script>

<style scoped>
  .wrapper{
    width:100%;
    height:700px;
  }
.left{
  background-color: #ffffff;
  height:700px;

  position: relative;
}
  .right{
    background-color: rgba(100,100,100,.2);
    height:700px;

    position: relative;

  }
  .right .rightContent{
    position: absolute;
    top:40%;
    left:50px;


  }
  .rightContent img {
    width:20px;
    height:20px;
    position: relative;
    top:5px;
  }
  .rightContentItem{
    margin-bottom: 20px;
  }
  .avatar{
    position: absolute;
    margin: auto;
    left:0;
    right:0;
    top:40%;
    width:64px;
    height:64px;

    border-radius: 50%;
    /*vertical-align: middle;*/
    display: inline-block;
    background-color: #a6a6a6;
    border: 1px solid #fff;
    padding: 5px;
  }
</style>