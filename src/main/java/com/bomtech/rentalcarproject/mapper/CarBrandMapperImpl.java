package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandMapperImpl implements CarBrandMapper {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CarBrandDTO> listBrand() {
        List<CarBrandDTO> list = sqlSession.selectList("listBrand");
        System.out.println("Mapper : " + list);
        return sqlSession.selectList("listBrand");
    }
}
