<template>
  <div class="wrapper">
    <el-row class="LeftMenu">
      <el-col :span="12">

        <el-menu
                class="el-menu-vertical-demo"
                background-color="#324057"
                text-color="#fff"
                active-text-color="#409eff">

          <router-link to="/home">
            <el-menu-item index="0">
              <i class="el-icon-menu"></i>
              <span slot="title">欢迎</span>
            </el-menu-item>
          </router-link>
<!--          公共服务-->
          <router-link to="/news"   v-if=" user.identity  !== '管理员' ">
            <el-menu-item index="1">
              <i class="el-icon-s-opportunity"></i>
              <span slot="title">公共服务</span>
            </el-menu-item>
          </router-link>



       <!--   留言板 message board-->
          <router-link to="/board">
            <el-menu-item index="3">
              <i class="el-icon-s-comment"></i>
              <span slot="title">留言板</span>
            </el-menu-item>
          </router-link>
<!--            //v-if="item.children"   -->
<!--          -->
            <el-submenu v-if=" user.identity  === '管理员' "  v-for="item in items" :index="item.path" :key="item.name">
              <template slot="title">
                <i class="el-icon-circle-plus-outline"></i>
                <span>{{item.name}}</span>
              </template>
              <router-link v-for="(citem,cindex) in  item.children "
                           :key="cindex" :to="citem.path"
              >
                <el-menu-item :index="citem.path"><span slot="title">{{citem.name}}</span></el-menu-item>
              </router-link>
            </el-submenu>


<!--          投标页面-->
          <router-link to="/tender" v-if="user.identity === '药品投标单位' ">
            <el-menu-item index="4">
              <i class="el-icon-s-order"></i>
              <span slot="title">进行投标</span>
            </el-menu-item>
          </router-link>

<!--          招标页面;-->
          <router-link to="/mytander" v-if="user.identity === '药品招标单位' ">
            <el-menu-item index="5">
              <i class="el-icon-s-order"></i>
              <span slot="title">进行招标</span>
            </el-menu-item>
          </router-link>
        <!--  <router-link to="/bids" v-if="user.identity === '药品招标单位' ">
            <el-menu-item index="3">
              <i class="el-icon-s-order"></i>
              <span slot="title">进行招标</span>
            </el-menu-item>
          </router-link>-->

<!--展示投标单位发布的个人投标信息-->

          <router-link to="/mybids" v-if="user.identity === '药品投标单位' ">
            <el-menu-item index="6">
              <i class="el-icon-s-claim"></i>
              <span slot="title">我的投标</span>
            </el-menu-item>
          </router-link>
<!--         消息页-->
          <router-link to="/mymessage" >
            <el-menu-item index="7">
              <i class="el-icon-message"></i>
              <span slot="title">我的消息</span>
            </el-menu-item>
          </router-link>
<!--          个人信息页-->
          <router-link to="/infoShow" >
            <el-menu-item index="8">
              <i class="el-icon-s-claim"></i>
              <span slot="title">个人信息</span>
            </el-menu-item>
          </router-link>
        </el-menu>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  export default {
    name: "LeftMenuNav",
    data(){
      return {
        //获取用户
        user:this.$store.state.user,
        //处理具有多个子集的目录
        items:[
          {
            path:'fund',
            name:'管理与维护',
            children:[
              // {path: 'board',name:'留言板管理'},
              {path:'tender',name:'招标信息管理'},
              {path:'mybids',name:'投标信息管理'}

                ]
          },
          {
            path:'info',
            name:'信息管理',
            children:[

              {path:'setadmin',name:'用户信息管理'},


            ]
          }
        ]
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    width:180px;
    height:calc(100vh - 80px);
   /* height: 100vh;*/
    background-color: #324057;


  }
  .el-menu {
    border: none;
  }
  .fa-margin {
    margin-right: 5px;
  }
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 180px;
    min-height: 350px;
  }
  .el-menu-vertical-demo {
    width: 35px;
  }
  .el-submenu .el-menu-item {
    min-width: 180px;
  }

  .hiddenDropdown,
  .hiddenDropname {
    display: none;
  }
  a {
    text-decoration: none;
  }
</style>