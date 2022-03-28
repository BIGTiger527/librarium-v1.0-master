package com.sanxia.service;

import com.sanxia.dao.BookDAO;
import com.sanxia.dao.ReturnedDAO;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 归还 service.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
public class
ReturnedService {

    @Autowired
    ReturnedDAO returnedDAO;

    @Autowired
    BookDAO bookDAO;

}
