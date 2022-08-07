package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarAppearanceDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarAppearanceMapperImpl implements CarAppearanceMapper {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CarAppearanceDTO> carAppearanceList() {

        return sqlSession.selectList("listAppearance");
    }
}
