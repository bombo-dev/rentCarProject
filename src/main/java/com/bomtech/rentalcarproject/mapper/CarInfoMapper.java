package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CarInfoMapper {

    List<CarInfoDTO> listCarInfo();
}
