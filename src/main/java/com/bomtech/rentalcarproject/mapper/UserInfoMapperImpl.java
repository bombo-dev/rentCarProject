package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.UserInfoDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMapperImpl implements UserInfoMapper{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int insertUser(UserInfoDTO dto) {
        return sqlSession.insert("userInfoInsert", dto);
    }
}
