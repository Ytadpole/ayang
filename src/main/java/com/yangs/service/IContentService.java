package com.yangs.service;

import com.github.pagehelper.PageInfo;
import com.yangs.modal.vo.ContentVo;

/**
 * Created by Ytadpole on 2018/2/22.
 */
public interface IContentService {
    PageInfo<ContentVo> getContents(Integer offset, Integer limit);
}
