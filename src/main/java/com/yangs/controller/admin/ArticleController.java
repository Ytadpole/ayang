package com.yangs.controller.admin;

import com.github.pagehelper.PageInfo;
import com.yangs.controller.BaseController;
import com.yangs.modal.vo.ContentVo;
import com.yangs.modal.vo.ContentVoExample;
import com.yangs.service.IContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ytadpole on 2018/2/25.
 */
@Controller
@RequestMapping(value = "admin/article")
public class ArticleController extends BaseController{
    @Resource
    private IContentService contentService;

    /**
     * 文章列表
     * @param httpServletRequest
     * @return
     */
    @GetMapping(value = "")
    public String articles(HttpServletRequest httpServletRequest,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "10") int limit){
        ContentVoExample contentVoExample = new ContentVoExample();
        PageInfo<ContentVo> contents = contentService.getContents(contentVoExample, page, limit);
        httpServletRequest.setAttribute("articles", contents);
        return this.adminRenderer("article_list");
    }

    @GetMapping(value = "/publish")
    public String publish(HttpServletRequest httpServletRequest){
        return this.adminRenderer("article_edit");
    }
}
