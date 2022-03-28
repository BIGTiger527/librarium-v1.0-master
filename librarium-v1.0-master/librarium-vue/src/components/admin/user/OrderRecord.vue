<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>借阅记录</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="borrowed.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        stripe
        :default-sort = "{prop: 'id', order: 'ascending'}"
        style="width: 100%"
        :header-cell-style="{ textAlign: 'center' }"
        :cell-style="{ textAlign: 'center'}"
        :max-height="tableHeight"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="45">
        </el-table-column>
        <el-table-column
          prop="id"
          label="id"
          sortable
          width="50">
        </el-table-column>
        <el-table-column
          prop="name"
          label="用户名"
          width="120">
        </el-table-column>
        <el-table-column
          prop="title"
          label="图书名称"
          width="120">
        </el-table-column>
        <el-table-column
          prop="time"
          label="借阅日期"
          sortable
          fit>
        </el-table-column>
        <el-table-column>
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="mini"
            placeholder="输入用户名搜索"/>
        </template>
          <template slot-scope="scope">
            <el-button
              @click="returnByAdmin(scope.row)"
              type="danger"
              size="mini"
              class="el-icon-delete">
              强制归还
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 20px 0;float: left">
        <el-button type="warning"  class="el-icon-close">取消选择</el-button>
        <el-button type="danger"  class="el-icon-delete">批量删除</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
  /* eslint-disable */

  export default {
    name: "OrderRecord",

    data () {
      return {
        borrowed: [],
        selectedBorrowed: [],
        search:''
      }
    },
    mounted () {
      this.listAllBorrowed()
    },
    computed: {
      tableHeight () {
        return window.innerHeight - 320
      },
    },
    methods: {
      returnByAdmin (row) {
        this.$confirm(`此操作将强制归还${row.title}，是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          const rowName = row.name;
          const rowTitle = row.title;
          this.$axios.delete('/bookReturn1/'+row.id).then( resp =>{
            if(resp && resp.data.code === 200){
              this.listAllBorrowed()
              this.$notify.success({
                title: '强制归还成功！',
                message: `你已经移除了${rowName}借阅的${rowTitle}！`
              })
            }
          }).catch(error=> {
            this.$notify.error({
              title: '网络错误！',
              message: '请稍后重试！'
            })
          })
        })
      },
      listAllBorrowed () {
        var _this = this
        this.$axios.get('/getAllBorrowed').then(resp => {
          console.log('listed')
          if (resp && resp.data.code === 200) {
            console.log("return success!")
            this.borrowed = resp.data.result
          }
        })
      },
      toggleSelection(){
        this.$refs.multipleTable.clearSelection();
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      }
    }
    }
</script>

<style scoped>

</style>
