<template>
  <div style="margin-top: 40px">
    <div class="articles-area">
      <el-card style="text-align: left">
        <Carousel></Carousel>
        <br>
        <br>
        <br>
        <br>
        <div v-for="article in articles" :key="article.id">
          <div style="float:left;width:85%;height: 150px;">
            <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"><span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span></router-link>
            <el-divider content-position="left">{{article.articleDate}}</el-divider>
            <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"><p>{{article.articleAbstract}}</p></router-link>
          </div>
          <el-image
            style="margin:18px 0 0 30px;width:100px;height: 100px"
            :src="article.articleCover"
            fit="cover"></el-image>
          <el-divider></el-divider>
        </div>
      </el-card>
      <Module class="Module"></Module>
      <AppIndex class="AppIndex"></AppIndex>
    </div>
    <el-pagination
      background
      layout="total, prev, pager, next, jumper"
      @current-change="handleCurrentChange"
      :page-size="pageSize"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
  import Module from '@/components/jotter/Module'
  import AppIndex from '@/components/home/AppIndex'
  import Carousel from '@/components/home/Carousel'
  export default {
    components: {
      Carousel,
      Module,
      AppIndex
    },
    name: 'Articles',
    data () {
      return {
        articles: [],
        pageSize: 2,
        total: 0
      }
    },
    mounted () {
      this.loadArticles()
    },
    methods: {
      loadArticles () {
        var _this = this
        this.$axios.get('/article/' + this.pageSize + '/1').then(resp => {
          if (resp && resp.data.code === 200) {
            _this.articles = resp.data.result.content
            _this.total = resp.data.result.totalElements
          }
        })
      },
      handleCurrentChange (page) {
        var _this = this
        this.$axios.get('/article/' + this.pageSize + '/' + page).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.articles = resp.data.result.content
            _this.total = resp.data.result.totalElements
          }
        })
      }
    }
  }
</script>

<style scoped>
  .articles-area {
    width: 990px;
    height: 750px;
    margin-left: auto;
    margin-right: auto;
  }

  .article-link {
    text-decoration: none;
    color: #606266;
  }

  .article-link:hover {
    color: #409EFF;
  }
</style>
