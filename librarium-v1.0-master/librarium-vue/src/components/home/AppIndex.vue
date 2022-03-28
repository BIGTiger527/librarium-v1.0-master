<template>
  <div style="margin-top: 40px">
    <side-menu id="side-menu"></side-menu>
      <div class="home">
        <div id="header-div">
          <div style="height: 150px"></div>
          <quick-nav style="float: right;margin-top: -450px;margin-right: 480px"></quick-nav>
        </div>
        <update-card id="update-card"></update-card>
        <Download id="download"></Download>
        <about id="about"></about>
      </div>
  </div>
</template>

<script>
  /* eslint-disable */
  import QuickNav from './QuickNav'
  import Download from './Download'
  import About from '@/components/common/About'
  import UpdateCard from './UpdateCard'
  import SideMenu from './SideMenu'
  export default {
    name: 'AppIndex',
    components: {
      QuickNav,
      About,
      Download,
      UpdateCard,
      SideMenu
    }
  }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;

  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -680px;
    top: 100px;
  }
</style>
