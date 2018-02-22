package com.yangs.dao;

import com.yangs.modal.vo.CommentVo;
import com.yangs.modal.vo.CommentVoExample;
import java.util.List;

public interface CommentVoMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(CommentVo record);

    int insertSelective(CommentVo record);

    List<CommentVo> selectByExampleWithBLOBs(CommentVoExample example);

    List<CommentVo> selectByExample(CommentVoExample example);

    CommentVo selectByPrimaryKey(Integer coid);

    int updateByPrimaryKeySelective(CommentVo record);

    int updateByPrimaryKeyWithBLOBs(CommentVo record);

    int updateByPrimaryKey(CommentVo record);
}