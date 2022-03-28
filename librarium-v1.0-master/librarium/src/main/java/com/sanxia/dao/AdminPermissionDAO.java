package com.sanxia.dao;

import com.sanxia.entity.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
