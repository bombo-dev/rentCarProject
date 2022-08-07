package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CarBrandMapper {
    List<CarBrandDTO> listBrand();
}
