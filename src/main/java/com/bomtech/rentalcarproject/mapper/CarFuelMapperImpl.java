package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarFuelDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarFuelMapperImpl implements CarFuelMapper {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CarFuelDTO> listFuel() {
        return sqlSession.selectList("listFuel");
    }
}
