package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import com.bomtech.rentalcarproject.dto.CarProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarProductMapperImpl implements CarProductMapper {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CarProductDTO> listProduct() {
        return sqlSession.selectList("listProduct");
    }

    @Override
    public int insertProduct(CarProductDTO dto) {
        CarCategoryMapper carCategoryMapper = new CarCategoryMapperImpl();
        List<CarCategoryDTO> categoryDTO = carCategoryMapper.findCategory("car_name", dto.getCar_name());

        dto.setCar_num(categoryDTO.get(0).getNum());
        return 0;
    }

    @Override
    public int updateReservation(CarProductDTO dto) {
        return 0;
    }
}

