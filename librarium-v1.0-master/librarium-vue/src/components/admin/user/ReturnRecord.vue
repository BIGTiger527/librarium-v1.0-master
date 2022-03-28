<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>归还记录</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="returned.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        stripe
        ref="multipleTable"
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
          label="归还日期"
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
              @click="deleteRecord(scope.row)"
              type="danger"
              size="mini"
              class="el-icon-delete">
              删除记录
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 20px 0;float: left">
        <el-button type="warning"  class="el-icon-close" @click="toggleSelection">取消选择</el-button>
        <el-button type="danger"  class="el-icon-delete" @click="deletes">批量删除</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
  /* eslint-disable */

  export default {
    name: "ReturnedRecord",

    data () {
      return {
        returned: [],
        search:'',
        multipleSelection: []
      }
    },
    mounted () {
      this.listAllReturned()
    },
    computed: {
      tableHeight () {
        return window.innerHeight - 320
      },
    },
    methods: {
      deletes() {
        var arr=[];
        var datas = this.$refs.multipleTable.selection;
        datas.forEach(function(item){
          arr.push(item.id)
        });
        this.$confirm(`此操作将删除所有所选记录，是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.post('/multipleDelete/',arr).then( resp =>{
            if(resp && resp.data.code === 200){
              this.listAllReturned()
              this.$notify.success({
                title: '删除记录成功！',
                message: `你已经删除所有所选记录！`
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
      deleteRecord (row) {
        this.$confirm(`此操作将强制归还${row.title}，是否继续?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          const rowName = row.name;
          const rowTitle = row.title;
          this.$axios.delete('/deleteReturned/'+row.id).then( resp =>{
            if(resp && resp.data.code === 200){
              this.listAllReturned()
              this.$notify.success({
                title: '删除记录成功！',
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
      listAllReturned () {
        var _this = this
        this.$axios.get('/getAllReturned').then(resp => {
          if (resp && resp.data.code === 200) {
            this.returned = resp.data.result
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
