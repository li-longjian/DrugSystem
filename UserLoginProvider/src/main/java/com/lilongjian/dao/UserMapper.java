package com.lilongjian.dao;

import com.lilongjian.domain.LoginParam;
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
     *
     * @return
     */
    User login(Map<String,Object> map);

}
