package com.yifei.dao;

import com.yifei.bean.Measurement;
import com.yifei.bean.MeasurementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasurementMapper {
    long countByExample(MeasurementExample example);

    int deleteByExample(MeasurementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Measurement record);

    int insertSelective(Measurement record);

    List<Measurement> selectByExample(MeasurementExample example);

    Measurement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Measurement record, @Param("example") MeasurementExample example);

    int updateByExample(@Param("record") Measurement record, @Param("example") MeasurementExample example);

    int updateByPrimaryKeySelective(Measurement record);

    int updateByPrimaryKey(Measurement record);
    
    Measurement selectByNodeIDForNewest(@Param("node")Integer nodeid);
}