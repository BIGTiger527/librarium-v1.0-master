package com.sanxia.controller;


import com.sanxia.dao.OrderedDAO;
import com.sanxia.dao.ReturnedDAO;
import com.sanxia.entity.Ordered;
import com.sanxia.entity.Returned;
import com.sanxia.result.Result;
import com.sanxia.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author Hyper
 */
@RestController
public class RecordController {

    @Autowired
    OrderedDAO orderedDAO;

    @Autowired
    ReturnedDAO returnedDAO;


    @GetMapping("/api/getAllBorrowed")
    public Result getAllBorrowed(){
        return ResultFactory.buildSuccessResult(orderedDAO.list());
    }

    @GetMapping("/api/getAllReturned")
    public Result getAllReturned(){
        return ResultFactory.buildSuccessResult(returnedDAO.list());
    }


    @DeleteMapping("api/bookReturn1/{id}")
    public Result returnByAdmin(@PathVariable("id") Integer id){
        Ordered ordered = orderedDAO.getOne(id);
        Returned returned = new Returned();
        returned.setUid(ordered.getUid());
        returned.setBid(ordered.getBid());
        LocalDateTime returnedTime = LocalDateTime.now();
         int year = returnedTime.getYear();
         int month = returnedTime.getMonthValue();
         int day = returnedTime.getDayOfMonth();
         int hour = returnedTime.getHour();
         int minute = returnedTime.getMinute();
         int seconds = returnedTime.getSecond();
         String returnedTimeString = year +"年"+month+"月"+day+"  "+hour+":"+minute+":"+seconds;
        returned.setTime(returnedTimeString);
        returnedDAO.save(returned);
        orderedDAO.deleteById(ordered.getId());
        return ResultFactory.buildSuccessResult(id);
    }

    @DeleteMapping("/api/deleteReturned/{id}")
    public Result deleteReturned(@PathVariable("id") Integer id){
        returnedDAO.deleteById(id);
        return ResultFactory.buildSuccessResult(id);
    }

    @PostMapping("/api/multipleDelete")
    public Result multipleDelete(@RequestBody int[] arr){
        for (int i = 0; i < arr.length; i++) {
            returnedDAO.deleteById(arr[i]);
        }
        return ResultFactory.buildSuccessResult(arr);
    }
}
