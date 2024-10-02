<template>
  <div class="Home">
    <div class="content">
      <p >欢迎访问药品在线投招标系统</p>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Home"
  }
</script>

<style scoped>
.Home{
  background: url("../assets/img/showcase.png") no-repeat  ;
  width: 90%;
  height:92%;
  background-size: cover;

}
  .content{
    width:100%;
    height:100%;

    background-color: rgba(0,0,0,.5);
  }
.content p{
  position: absolute;
  left:40%;
  top:10%;
  color:#fff;
  font-size:24px;
}
</style>