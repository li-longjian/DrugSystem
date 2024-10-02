<template>

  <div id="wrapper">

    <el-row>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="headerMenu">
            <div class="headerMenuItem">
              <template >
                <el-carousel class="swipper" :interval="2000" arrow="always" height="330px" indicator-position="outside">
                  <el-carousel-item v-for="item in swiper" :key="item.id">
                    <img :src="item.url" width="700px" height="330px">
                    <span class="swipper_cover_tite">{{item.title}}</span>
                  </el-carousel-item>
                </el-carousel>

              </template>

            </div>
          </div>

          <div class="headerMenuItem">
            <el-tabs class="rightMenu" type="border-card"  >
              <el-tab-pane label="热点新闻" >
                <ul v-for="(item,index) in newsList[0].newsTitle" :key="index" class="newsList">
                  <a href="http://www.cebpubservice.com/monitorindustry/monitorplat/2021/09/12052.shtml" class="title_a-link"><li><span class="newsTitle">{{item}}</span></li></a>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="政策动向">
                <ul v-for="(item,index) in newsList[1].newsTitle" :key="index" class="newsList">
                  <a href="http://www.cebpubservice.com/monitorindustry/monitorpolicy/2019/04/11090.shtml" class="title_a-link"><li><span class="newsTitle">{{item}}</span></li></a>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="页内观察">
                <ul v-for="(item,index) in newsList[2].newsTitle" :key="index" class="newsList">
                  <a href="http://www.cebpubservice.com/monitorindustry/monitorplat/2021/09/12044.shtml" class="title_a-link"><li><span class="newsTitle">{{item}}</span></li></a>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="页内研究">
                <ul v-for="(item,index) in newsList[3].newsTitle" :key="index" class="newsList">
                  <a href="" class="title_a-link"><li><span class="newsTitle">{{item}}</span></li></a>
                </ul>
              </el-tab-pane>
            </el-tabs>
          </div>

      </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple-light">
          <div class="tranderMessageShow">
            <div><h3 class="titleShow">招标项目公示</h3></div>
            <news-show :tableData="tableData"></news-show>
          </div>

        </div>
      </el-col>

    </el-row>




  </div>
</template>

<script>
  import NewsShow from "../components/NewsShow";
  export default {
    name: "News",
    components:{NewsShow},
     data(){
      return{
       swiper:[
          {id:0,url:require("../assets/img/01.jpg"),title:"协同共建招标采购全流程数字化实践应用研讨会"},
          {id:1,url:require("../assets/img/02.jpg"),title: "国家发改委法规司杨洁司长莅临指导"},
          {id:2,url:require("../assets/img/03.png"),title:"中国招标投标公共服务平台网站开通"},
          {id:3,url:require("../assets/img/04.jpg"),title: "协同共建招标采购全流程数字化实践应用研讨会"},
        ],
        newsList:[
          {
          title:"行业动态",
           newsTitle:[
               "2021年中级招采人员测试报名工作正式启动",
             "国家发展改革委法规司杨洁司长听取中国招标投标协会、中国招标投标公共服务平台工作汇报",
               "住建部发布《关于开展工程建设领域整治工作的通知》",
               "关于举办“招标代理与全过程工程咨询”论坛的通知",
               "新书征订——《中国招标采购常用法规选编（2021）》",
               "国务院印发《关于深化“证照分离”改革进一步激发市场主体发展活力的通知》"
           ]
          },
          {
            title:"政策动向",
            newsTitle:[
              "国务院办公厅转发国家发展改革委关于深化公共资源交易平台整合共享指导意见的通知",
              "国家发展改革委办公厅关于印发《公共资源交易平台服务标准（试行）》的通知、中国招标投标公共服务平台工作汇报",
              "全国人民代表大会常务委员会关于修改《中华人民共和国建筑法》等八部法律的决定",
              "国务院办公厅关于全面开展工程建设项目审批制度改革的实施意见",
              "关于印发住房和城乡建设部建筑市场监管司2019年工作要点的通知",
              "住房和城乡建设部关于修改部分部门规章的决定"
            ]
          },
          {
            title:"页内观察",
            newsTitle:[
              "区块链技术在供应链管理中的应用前景分析",
              "关于征集北京市建设工程应急评标专家的通知",
              "全国人大代表戴雅萍：把决策权和责任归还给招标人",
              "全国人大代表田春艳：建议取消工程建设领域最低价中标法",
              "加强联动协作 提升招投标监管水平",
              "大疆采购腐败损失10亿 企业采购反腐败要这样做"
            ]
          },
          { title:"业务研究",
            newsTitle:[
              "《投标及履约非现金保证机制研究》课题组成立并举行第一次工作会议",
              "失信被执行人能参与招投标吗？",
              "常见评标方法对比",
              "法定代表人加盖伪造公章的合同是否有效?",
              "恶意低价中标和最低评标价法之辩",
              "从评标办法和评审的视角探讨投标竞争规范化"
            ]},
            ],
        tableData:[],

      }
    },
    created() {
      this.getMessages()
    },
    methods: {
      getMessages(){

        this.$axios.get("/zb/getAll").then(res =>{
          if(res.data.length >=5){
            this.tableData = res.data.splice(0,5);
            return;
          }
          this.tableData = res.data

        })

      }
    }



  }
</script>

<style scoped>




  .swipper_cover_tite{

    width:625px;
    height:45px;
    line-height: 45px;
    letter-spacing: 5px;
    color:#fff;
    font-size: 28px;
    position: absolute;
   text-align: center;
    bottom: 0;
    z-index: 99;
  }


.newsList li{
  list-style: none;

  width:700px;
  height:40px;
  line-height:40px;
  display: block;

}
.rightMenu{
  width:100%;
}
  .title_a-link{
    text-decoration: none;
  }
  .newsList li .newsTitle{

    display: block;
    width:100%;
    height:40px;
    overflow:hidden ;
    text-overflow:ellipsis ;
    white-space:nowrap;

    border-bottom: 1px dashed rgba(0,0,0,.1);
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .tranderMessageShow{
    width:700px;

  }
  .tranderMessageShow .titleShow{
    color: #ffffff;
    background-color: red;

    width:150px;
    text-align: center;
    height:35px;
    line-height: 35px;
  }



  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>