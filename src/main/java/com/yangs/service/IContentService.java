package com.yangs.service;

import com.github.pagehelper.PageInfo;
import com.yangs.modal.vo.ContentVo;
import com.yangs.modal.vo.ContentVoExample;

/**
 * Created by Ytadpole on 2018/2/22.
 */
public interface IContentService {
    PageInfo<ContentVo> getContents(ContentVoExample contentVoExample, Integer offset, Integer limit);

    ContentVo getContentByCid(String cid);
}
