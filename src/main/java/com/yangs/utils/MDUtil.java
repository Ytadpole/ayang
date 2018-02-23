package com.yangs.utils;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Created by Ytadpole on 2018/2/23.
 * md格式文件
 */
public class MDUtile {

    /**
     * md格式字符串 转 html格式字符串
     * @param mdString
     * @return
     */
    public static String md2Html(String mdString){
        Parser parser = Parser.builder().build();
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();

        Node document = parser.parse(mdString);
        //转html格式
        String htmlContent = htmlRenderer.render(document);
        return htmlContent;
    }
}
