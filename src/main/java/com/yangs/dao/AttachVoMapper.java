package com.yangs.dao;

import com.yangs.modal.vo.AttachVo;
import com.yangs.modal.vo.AttachVoExample;
import java.util.List;

public interface AttachVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AttachVo record);

    int insertSelective(AttachVo record);

    List<AttachVo> selectByExample(AttachVoExample example);

    AttachVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttachVo record);

    int updateByPrimaryKey(AttachVo record);
}