package com.yangs.utils;

import com.yangs.config.DefaultConfig;
import com.yangs.modal.vo.ContentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * page tools 前端相关
 * 和前端交互 方法名 就用短横线方式
 * Created by Ytadpole on 2018/2/14.
 */
@Component
public final class Commons {
    /**
     * 每片文章显示的icon
     */
    private static final String[] ICONS = {"bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code", "bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock"};

    /**
     * 默认文章分类 如果某篇文章没有categorty，就默认all
     */
    private static final String DEFUALT_CATEGORY = "all";

    /**
     * 默认标签
     */
    private static final String DEFUALT_TAG = "all";
    /**
     * 分类用的分隔符
     */
    private static final String CATEGORY_SEPAROTOR = ",";

    /**
     * 默认日期格式
     */
    private static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    /**
     * sit option
     * @param keyword
     * @return
     */
    public static String site_option(String keyword){
       return site_option(keyword, null);
    }

    /**
     * sit options
     * @param keyword
     * @param defaultVal
     * @return
     */
    public static String site_option(String keyword, String defaultVal){
        if(StringUtils.isEmpty(keyword)){
            return "";
        }

        if(StringUtils.isEmpty(DefaultConfig.defaultConfig.get(keyword))){
            if(StringUtils.isEmpty(defaultVal)){
                return "";
            }else{
                return defaultVal;
            }
        }else {
            return DefaultConfig.defaultConfig.get(keyword);
        }
    }

    /**
     * 网站url
     * @return
     */
    public static String site_url(){
        return site_url("");
    }

    /**
     * 网站url
     * @param url
     * @return
     */
    public static String site_url(String url){
        return site_option("site_url") + url;
    }

    /**
     * 文章链接地址
     * @return
     */
    public static String permalink(ContentVo contentVo){
//        return permalink(contentVo.getSlug(), contentVo.getCid());
        return site_url("/article/" + contentVo.getCid());
    }

    /**
     * 优先使用slug，如果slug没有就使用cid
     * @param slug
     * @param cid
     * @return
     */
//    public static String permalink(String slug, Integer cid) {
//        return site_url("/article/" + (StringUtils.isNotBlank(slug) ? slug: cid));
//    }

    public static String show_thumb(ContentVo contentVo){
        int cid = contentVo.getCid();
        int tmp = cid % 20;
        int picNum = tmp == 0 ? 1 : tmp;
        return "/user/img/rand/" + picNum + ".jpg";
    }

    /**
     * 每篇文章展示的 icon
     * @param id
     * @return
     */
    public static String show_icon(int id){
        return ICONS[id % ICONS.length];
    }

    /**
     * 文章所关联分类 展示
     * 分类用,隔开
     * @param categories
     * @return
     */
    public static String show_categories(String categories){
        if(StringUtils.isBlank(categories)){
            categories = DEFUALT_CATEGORY;
        }
        String[] categoryArray = categories.split(CATEGORY_SEPAROTOR);
        StringBuilder sb = new StringBuilder();
        for(String category : categoryArray){
            sb.append("<a href='/#'>" + category +"</a>");
        }
        return sb.toString();
    }

    /**
     * 文章的 标签展示
     * @param tags
     * @return
     */
    public static String show_tags(String tags){
        if(StringUtils.isBlank(tags)){
            tags = DEFUALT_TAG;
        }
        String[] tagArray = tags.split(CATEGORY_SEPAROTOR);
        StringBuilder sb = new StringBuilder();
        for(String tag : tagArray){
            sb.append("<a href='/#'>" + tag +"</a>");
        }
        return sb.toString();
    }

    /**
     * 时间搓展示 可以读的时间
     * @param unixTime
     * @return
     */
    public static String fmtdate(Integer unixTime){
        return fmtdate(unixTime, DEFAULT_TIME_FORMAT);
    }

    /**
     * 时间搓展示 可以读的时间
     * @param unixTime
     * @param format
     * @return
     */
    public static String fmtdate(Integer unixTime, String format){
        if (null != unixTime && StringUtils.isNotBlank(format)) {
            return DateKit.formatDateByUnixTime(unixTime, format);
        }
        return "";
    }


    /**
     * 显示文字的内容到web界面
     * @param content 文字类容 目前是md格式
     * @return
     */
    public static String article(String content){
        return MDUtile.md2Html(content);
    }

    //footer

    //社交账号
    public static Map<String, String> social(){
        Map<String, String> map = new HashMap<>();
        map.put("weibo", "https://weibo.com/5128368541/profile?rightmod=1&wvr=6&mod=personinfo");
        map.put("zhihu", "https://www.zhihu.com/people/yang-song-10-87/activities");
        map.put("github", "https://github.com/Ytadpole");
        map.put("twitter", "https://github.com/Ytadpole");
        return map;
    }

    public static String site_title(){
        return site_option("site_title");
    }
}
