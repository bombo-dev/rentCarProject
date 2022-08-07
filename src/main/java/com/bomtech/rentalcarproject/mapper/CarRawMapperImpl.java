package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import com.bomtech.rentalcarproject.dto.CarRawDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRawMapperImpl implements CarRawMapper{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<CarRawDTO> listRaw() {
        List<CarRawDTO> list = sqlSession.selectList("listRaw");
        return sqlSession.selectList("listRaw");
    }
}
