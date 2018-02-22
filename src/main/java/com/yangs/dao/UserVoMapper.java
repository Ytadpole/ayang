package com.yangs.dao;

import com.yangs.modal.vo.UserVo;
import com.yangs.modal.vo.UserVoExample;
import java.util.List;

public interface UserVoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserVo record);

    int insertSelective(UserVo record);

    List<UserVo> selectByExample(UserVoExample example);

    UserVo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserVo record);

    int updateByPrimaryKey(UserVo record);
}