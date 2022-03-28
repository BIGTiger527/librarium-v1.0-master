package com.sanxia.service;

import com.sanxia.dao.AdminMenuDAO;
import com.sanxia.entity.AdminUserRole;
import com.sanxia.entity.User;
import com.sanxia.entity.AdminMenu;
import com.sanxia.entity.AdminRoleMenu;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
@Service
public class AdminMenuService {
    @Autowired
    AdminMenuDAO adminMenuDAO;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    public List<AdminMenu> getAllByParentId(int parentId) {return adminMenuDAO.findAllByParentId(parentId);}

    public List<AdminMenu> getMenusByCurrentUser() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findByUsername(username);
        List<AdminUserRole> userRoleList = adminUserRoleService.listAllByUid(user.getId());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole userRole : userRoleList) {
            List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(userRole.getRid());
            for (AdminRoleMenu rm : rms) {
                AdminMenu menu = adminMenuDAO.findById(rm.getMid());
                // 防止多角色状态下菜单重复
                if(!menus.contains(menu)) {
                    menus.add(menu);
                }
            }
        }
        handleMenus(menus);
        return menus;
    }

    public List<AdminMenu> getMenusByRoleId(int rid) {
        List<AdminMenu> menus = new ArrayList<>();
        List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(rid);
        for (AdminRoleMenu rm : rms) {
            menus.add(adminMenuDAO.findById(rm.getMid()));
        }
        handleMenus(menus);
        return menus;
    }

    public void handleMenus(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            List<AdminMenu> children = getAllByParentId(menu.getId());
            menu.setChildren(children);
        }

        menus.removeIf(menu -> menu.getParentId() != 0);
    }
}
