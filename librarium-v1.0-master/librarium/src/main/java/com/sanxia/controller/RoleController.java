package com.sanxia.controller;

import com.sanxia.entity.AdminRole;
import com.sanxia.service.AdminRoleMenuService;
import com.sanxia.service.AdminRolePermissionService;
import com.sanxia.result.Result;
import com.sanxia.result.ResultFactory;
import com.sanxia.service.AdminPermissionService;
import com.sanxia.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;


@RestController
public class RoleController {
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    @GetMapping("/api/admin/role")
    public Result listRoles(){
        return ResultFactory.buildSuccessResult(adminRoleService.list());
    }

    @PutMapping("/api/admin/role/status")
    public Result updateRoleStatus(@RequestBody AdminRole requestRole) {
        AdminRole adminRole = adminRoleService.updateRoleStatus(requestRole);
        String message = "用户" + adminRole.getNameZh() + "状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @DeleteMapping("/api/admin/role/deleteRole/{roleId}")
    public Result deleteRoleById(@PathVariable("roleId") Integer rid){
        adminRoleService.deleteRoleById(rid);
        return ResultFactory.buildSuccessResult(rid);
    }

    @PutMapping("/api/admin/role")
    public Result editRole(@RequestBody AdminRole requestRole) {
        adminRoleService.addOrUpdate(requestRole);
        adminRolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        String message = "修改角色信息成功";
        return ResultFactory.buildSuccessResult(message);
    }


    @PostMapping("/api/admin/role")
    public Result addRole(@RequestBody AdminRole requestRole) {
        if (adminRoleService.editRole(requestRole)) {
            return ResultFactory.buildSuccessResult("修改用户成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，修改失败");
        }
    }

    @GetMapping("/api/admin/role/perm")
    public Result listPerms() {
        return ResultFactory.buildSuccessResult(adminPermissionService.list());
    }

    @PutMapping("/api/admin/role/menu")
    public Result updateRoleMenu(@RequestParam int rid, @RequestBody LinkedHashMap menusIds) {
        if(adminRoleMenuService.updateRoleMenu(rid, menusIds)) {
            return ResultFactory.buildSuccessResult("更新成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，更新失败");
        }
    }
}
