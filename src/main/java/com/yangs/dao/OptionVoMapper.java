package com.yangs.dao;

import com.yangs.modal.vo.OptionVo;
import com.yangs.modal.vo.OptionVoExample;
import java.util.List;

public interface OptionVoMapper {
    int deleteByPrimaryKey(String name);

    int insert(OptionVo record);

    int insertSelective(OptionVo record);

    List<OptionVo> selectByExample(OptionVoExample example);

    OptionVo selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(OptionVo record);

    int updateByPrimaryKey(OptionVo record);
}