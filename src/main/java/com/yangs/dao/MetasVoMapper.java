package com.yangs.dao;

import com.yangs.modal.vo.MetasVo;
import com.yangs.modal.vo.MetasVoExample;
import java.util.List;

public interface MetasVoMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(MetasVo record);

    int insertSelective(MetasVo record);

    List<MetasVo> selectByExample(MetasVoExample example);

    MetasVo selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(MetasVo record);

    int updateByPrimaryKey(MetasVo record);
}