package com.sanxia.service;

import com.sanxia.dao.BookDAO;
import com.sanxia.dao.OrderedDAO;
import com.sanxia.entity.Ordered;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
public class OrderedService {

    @Autowired
    private OrderedDAO orderDAO;

    @Autowired
    private BookDAO bookDAO;

    public List<Ordered> listOrdered(){
        List<Ordered> ordereds = orderDAO.findAll();
        return ordereds;
    }

}
