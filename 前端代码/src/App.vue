<template>
  <div id="app">
    <router-link to="/index"></router-link>
    <router-view/>
  </div>
</template>

<script>

  export default {
    name: "App",
    created() {
    },
    methods:{
    }
  }
</script>




<style>

*{ margin: 0;padding: 0}
#app{
  width: 100vw;
  height:100vh;

}
</style>
