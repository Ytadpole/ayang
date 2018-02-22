package com.yangs.dao;

import com.yangs.modal.vo.LogVo;
import com.yangs.modal.vo.LogVoExample;
import java.util.List;

public interface LogVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogVo record);

    int insertSelective(LogVo record);

    List<LogVo> selectByExample(LogVoExample example);

    LogVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogVo record);

    int updateByPrimaryKey(LogVo record);
}