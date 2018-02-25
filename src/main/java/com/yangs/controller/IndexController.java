package com.yangs.controller;

import com.github.pagehelper.PageInfo;
import com.yangs.modal.vo.ContentVo;
import com.yangs.service.IContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 前端servlet
 * Created by Ytadpole on 2018/2/14.
 */
@Controller
public class IndexController extends BaseController{
    @Resource
    private IContentService contentService;

    @GetMapping(value = {"/", "index"})
    public String index(HttpServletRequest request){
        return this.index(request, 10);
    }


    public String index(HttpServletRequest request, int limit){
        PageInfo<ContentVo> articles =  contentService.getContents(null, 0, 10);
        request.setAttribute("articles", articles);
        return this.renderer("index");
    }

    @GetMapping(value = {"article/{cid}", "article/{cid}.html"})
    public String getArticle(HttpServletRequest request, @PathVariable String cid){
        ContentVo contentVo = contentService.getContentByCid(cid);
        request.setAttribute("article", contentVo);
        request.setAttribute("is_post", true);//展示目录列表
        return this.renderer("content");
    }

}
