package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInfoMapperImpl implements CarInfoMapper{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CarInfoDTO> listCarInfo() {
        return null;
    }
}
