package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import com.bomtech.rentalcarproject.dto.CarProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Mapper
public interface CarProductMapper {
    List<CarProductDTO> listProduct();
    int insertProduct(CarProductDTO dto);
    int updateReservation(CarProductDTO dto);
}
