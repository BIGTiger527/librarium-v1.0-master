<template>
  <div>
    <el-menu
      :default-active="currentPath"
      class="el-menu-admin"
      router
      mode="vertical"
      background-color="#606266"
      text-color="#fff"
      active-text-color="#E6A23C"
      :collapse="isCollapse">
      <!--index 没有用但是必需字段-->
      <el-submenu class="parent"
                  v-for="(item,i) in adminMenus"
                  :key="i"
                  :index="(i).toString()">
        <span slot="title" style="font-size: 16px;">
          <i :class="item.iconCls" style="color: white; "></i>
          {{item.nameZh}}
        </span>
        <el-menu-item class="items" v-for="child in item.children" :key="child.path" :index="child.path">
          <i :class="child.icon"></i>
          {{ child.nameZh }}
        </el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
  /* eslint-disable */
    export default {
      name: 'AdminMenu',
      data () {
        return {
          isCollapse: false
        }
      },
      computed: {
        adminMenus () {
          return this.$store.state.adminMenus
        },
        currentPath () {
          return this.$route.path
        }
      }
    }
</script>

<style scoped>
  .el-menu-admin {
    border-radius: 1px;
    height: auto;
  }
  .items{
    text-align: center;
    font-size: 12px;
    border-radius:5px;
    border: 2px #EBEEF5 none;
    background-color:#fff;
    overflow:hidden;
    color:#303133;
    -webkit-transition:.3s;
    transition:.3s;
    box-shadow:0 2px 12px 0 rgba(0,0,0,.4);
  }
  .items:hover{
    padding-right: 3px;
    font-size: 14px;
   }
  .parent{
    text-align: left;
    border-radius: 1px;
    border: 2px #EBEEF5 none;
    box-shadow:0 2px 12px 0 rgba(0,0,0,.9);
  }
  .parent:hover{
    padding-left: 10px;
    -webkit-transition:.3s;
    transition:.3s;
  }
</style>
