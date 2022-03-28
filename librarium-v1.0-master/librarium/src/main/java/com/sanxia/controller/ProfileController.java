package com.sanxia.controller;

import com.sanxia.entity.User;
import com.sanxia.result.Result;
import com.sanxia.result.ResultFactory;
import com.sanxia.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/api/user/{username}")
    public Result listUser(@PathVariable("username") String username){
        return ResultFactory.buildSuccessResult(profileService.getUserInfo(username));
    }

    @PutMapping("/api/user/status")
    public Result updateUserStatus(@RequestBody User requestUser) {
        if (profileService.updateUserStatus(requestUser)) {
            return ResultFactory.buildSuccessResult("用户状态更新成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，更新失败");
        }
    }

    @PutMapping("/api/user/password")
    public Result resetPassword(@RequestBody User requestUser) {
        if (profileService.resetPassword(requestUser)) {
            return ResultFactory.buildSuccessResult("重置密码成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，重置失败");
        }
    }

    @PutMapping("/api/userEdit")
    public Result editUser(@RequestBody User requestUser) {
        if(profileService.editUserProfile(requestUser)) {
            return ResultFactory.buildSuccessResult("修改用户信息成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，修改失败");
        }
    }
}
