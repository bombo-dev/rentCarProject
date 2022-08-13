package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CarCategoryMapper {
    int insertCategory(CarCategoryDTO dto);
    List<CarCategoryDTO> listCategory();
    List<CarCategoryDTO> findCategory(String search, String searchString);
    int deleteCategory(int cate_code);
    String getCarCode(int num);
}
