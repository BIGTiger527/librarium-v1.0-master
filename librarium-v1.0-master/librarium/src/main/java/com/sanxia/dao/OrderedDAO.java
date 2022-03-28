package com.sanxia.dao;


/**
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/11/8
 */
import com.sanxia.entity.Ordered;
import com.sanxia.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface OrderedDAO extends JpaRepository<Ordered, Integer> {

    @Query(value = "select * from ordered where uid = :uid", nativeQuery = true)
    List<Ordered> findByUid(@Param("uid") Integer uid);

    Ordered findByUidAndBid(Integer uid, Integer bid);

    @Query(value="SELECT new com.sanxia.entity.OrderDetail(o.id, u.name, b.title, o.time) FROM Ordered o INNER JOIN User u ON o.uid = u.id INNER JOIN Book" +
            " b ON o.bid = b.id")
    List<OrderDetail> list();


}
