<template>
  <div id="app">
    <router-view/>
  </div>
</template>
<script>

  import NavMenu from '@/components/common/NavMenu'

  export default {
    name: 'App',
    components: {NavMenu}
  }
</script>
<style>
  #app {
    background:url("../static/img/carousel/background.png");
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    /*抗锯齿*/
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
</style>
