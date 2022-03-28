<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">最新动态</span>
    </div>
    <div class="block">
      <el-timeline>
        <el-timeline-item timestamp="2020/3/15" placement="top">
          <el-card>
            <h4>实现上传至服务器和输入 URL 两种方式添加封面</h4>
            <p>提交于 2022/2/15</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2020/3/17" placement="top">
          <el-card>
            <h4>实现图书分类功能</h4>
            <p>提交于 2022/3/17</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2022/3/18" placement="top">
          <el-card>
            <h4>实现图书分页，修复图书添加的 BUG</h4>
            <p>提交于 2022/3/18</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2022/3/19" placement="top">
          <el-card>
            <h4>实现搜索框模糊查询</h4>
            <p> 提交于 2022/3/19</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2022/3/20" placement="top">
          <el-card>
            <h4>美化前端页面布局</h4>
            <p>提交于 2022/3/20 </p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: 'UpdateCard'
  }
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 1050px;
    text-align: left;
  }
</style>
