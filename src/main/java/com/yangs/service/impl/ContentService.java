package com.yangs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangs.dao.ContentVoMapper;
import com.yangs.modal.vo.ContentVo;
import com.yangs.modal.vo.ContentVoExample;
import com.yangs.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/22.
 */
@Service
public class ContentService implements IContentService{
    @Resource
    private ContentVoMapper contentVoDao;

    @Override
    public PageInfo<ContentVo> getContents(Integer offset, Integer limit) {
        ContentVoExample example = new ContentVoExample();
        example.setOrderByClause("created desc");
        PageHelper.offsetPage(offset, limit);

        List<ContentVo> list = contentVoDao.selectByExampleWithBLOBs(example);
        return new PageInfo<>(list);
    }
}
