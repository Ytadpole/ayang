package com.yangs.dao;

import com.yangs.modal.vo.RelationshipVoExample;
import com.yangs.modal.vo.RelationshipVoKey;
import java.util.List;

public interface RelationshipVoMapper {
    int deleteByPrimaryKey(RelationshipVoKey key);

    int insert(RelationshipVoKey record);

    int insertSelective(RelationshipVoKey record);

    List<RelationshipVoKey> selectByExample(RelationshipVoExample example);
}