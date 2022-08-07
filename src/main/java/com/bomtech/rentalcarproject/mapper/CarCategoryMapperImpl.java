package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class CarCategoryMapperImpl implements CarCategoryMapper{

    @Autowired
    private SqlSession sqlSession;

    public int insertCategory(CarCategoryDTO dto) {
        return sqlSession.insert("insertCategory", dto);
    }

    public List<CarCategoryDTO> listCategory(){
        return sqlSession.selectList("listCategory");
    }

    public List<CarCategoryDTO> findCategory(String search, String searchString){
        Map<String, String> map = new Hashtable<>();

        map.put("search", search);
        map.put("searchString", searchString);

        return sqlSession.selectOne("findCategory", map);
    }

    public int deleteCategory(int cate_code){
        return sqlSession.delete("deleteCategory", cate_code);
    }
}
