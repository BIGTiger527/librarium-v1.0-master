<template>
  <div>
    <el-dialog
      title="修改个人信息"
      :visible.sync="dialogFormVisible">
      <el-form v-model="selectedUser" style="text-align: left" ref="dataForm">
        <el-form-item label="用户名" label-width="120px" prop="username">
          <label>{{selectedUser.username}}</label>
        </el-form-item>
        <el-form-item label="真实姓名" label-width="120px" prop="name">
          <el-input v-model="selectedUser.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" label-width="120px" prop="phone">
          <el-input v-model="selectedUser.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" label-width="120px" prop="email">
          <el-input v-model="selectedUser.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" label-width="120px" prop="password">
          <el-button type="warning" @click="resetPassword(selectedUser.username)">重置密码</el-button>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit(selectedUser)">确 定</el-button>
      </div>
    </el-dialog>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>个人信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="users"
        stripe
        :default-sort = "{prop: 'id', order: 'ascending'}"
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          prop="id"
          label="id"
          width="50">
        </el-table-column>
        <el-table-column
          prop="username"
          label="用户名"
          width="150">
        </el-table-column>
        <el-table-column
          prop="name"
          label="真实姓名"
          width="150">
        </el-table-column>
        <el-table-column
          prop="phone"
          label="手机号"
          width="150">
        </el-table-column>
        <el-table-column
          prop="email"
          label="邮箱"
          show-overflow-tooltip
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button
              @click="editUser(scope.row)"
              type="primary"
              size="mini" class="el-icon-edit">
              编辑
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
  /* eslint-disable */
  import BulkRegistration from './BulkRegistration'
  export default {
    name: 'UserProfile',
    data () {
      return {
        users: [],
        dialogFormVisible: false,
        selectedUser: []
      }
    },
    mounted () {
      this.listUser()
    },
    computed: {
      tableHeight () {
        return window.innerHeight - 320
      }
    },
    methods: {
      listUser () {
        var _this = this
        const username = this.$store.state.username
        this.$axios.get(`/user/${username}`).then(resp => {
          if (resp && resp.data.code === 200) {
            this.users = resp.data.result
          }
        })
      },
      commitStatusChange (value, user) {
        if (user.username !== 'admin') {
          this.$axios.put('/user/status', {
            enabled: value,
            username: user.username
          }).then(resp => {
            if (resp && resp.data.code === 200) {
              if (value) {
                this.$message('用户 [' + user.username + '] 已启用')
              } else {
                this.$message('用户 [' + user.username + '] 已禁用')
              }
            }
          })
        } else {
          user.enabled = true
          this.$alert('不能禁用管理员账户哦！')
        }
      },
      onSubmit (user) {
        let _this = this
        this.$axios.put('/userEdit', {
          username: user.username,
          name: user.name,
          phone: user.phone,
          email: user.email
          /*roles: roles*/
        }).then(resp => {
          if (resp && resp.data.code === 200) {
            this.$alert('用户信息修改成功！')
            this.dialogFormVisible = false
            // 修改角色后重新请求用户信息，实现视图更新
            this.listUser()
          }
        })
      },
      editUser (user) {
        this.dialogFormVisible = true
        this.selectedUser = user

      },
      resetPassword (username) {
        this.$axios.put('/user/password', {
          username: username
        }).then(resp => {
          if (resp && resp.data.code === 200) {
            this.$alert('密码已重置为 123！')
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
