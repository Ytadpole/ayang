package com.yangs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangs.dao.ContentVoMapper;
import com.yangs.modal.vo.ContentVo;
import com.yangs.modal.vo.ContentVoExample;
import com.yangs.service.IContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/22.
 */
@Service
public class ContentService implements IContentService{
    private static Logger log = LoggerFactory.getLogger(ContentService.class);

    @Resource
    private ContentVoMapper contentVoMapper;

    @Override
    public PageInfo<ContentVo> getContents(Integer offset, Integer limit) {
        ContentVoExample example = new ContentVoExample();
        example.setOrderByClause("created desc");
        PageHelper.offsetPage(offset, limit);

        List<ContentVo> list = contentVoMapper.selectByExampleWithBLOBs(example);
        return new PageInfo<>(list);
    }

    @Override
    public ContentVo getContentByCid(String cid) {
        if(null != cid) {
            if(StringUtils.isNumeric(cid)){
                //cid方式
                ContentVo contentVo = contentVoMapper.selectByPrimaryKey(Integer.valueOf(cid));
                //被查看后 浏览量加一
                contentVo.setHits(contentVo.getHits() + 1);
                contentVoMapper.updateByPrimaryKey(contentVo);
                return contentVo;
            }
        }
        return null;
    }

}
