package com.lilongjian.dao;

import com.lilongjian.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {
    /**
     *
     * @param map String email,String password
     * @return
     */
    User login(Map<String,String> map);

}
