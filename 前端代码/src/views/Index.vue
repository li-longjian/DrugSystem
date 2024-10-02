<template>
<!--  首页-->
  <div class="IndexBox">
    <header-nav ></header-nav>
    <left-menu-nav class="left-menu"></left-menu-nav>
    <router-view class="rightContent"></router-view>
   <!-- <div class="rightContent">

    </div>-->


  </div>


</template>

<script>
  
  import HeaderNav from "../components/HeaderNav";
  import LeftMenuNav from "../components/LeftMenuNav";
  export default {
    name: "Index",
    components:{
      HeaderNav,
      LeftMenuNav
    }
  }
</script>

<style scoped>

.IndexBox{

  width: 100vw;
  height:100vh;

}
.left-menu{
  margin: 0;
}
  .rightContent{

    /*float: left;*/
    position: absolute;
    top:70px;
    width: calc(100vw - 180px);
    height:calc(100vh - 80px);
    left:180px;
  }
</style>