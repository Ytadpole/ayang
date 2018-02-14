package com.yangs.modal.vo;

/**
 * Created by Ytadpole on 2018/2/14.
 */
public class ContentVo {
    private String cid;
    private String title;
    private String slug;
    private String created;
    private String modified;
    private String content;
    private String author_id;
    private String type;
    private String status;
    private String tags;
    private String categories;
    private String hits;
    private String comments_num;
    private String allow_comment;
    private String allow_ping;
    private String allow_feed;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getComments_num() {
        return comments_num;
    }

    public void setComments_num(String comments_num) {
        this.comments_num = comments_num;
    }

    public String getAllow_comment() {
        return allow_comment;
    }

    public void setAllow_comment(String allow_comment) {
        this.allow_comment = allow_comment;
    }

    public String getAllow_ping() {
        return allow_ping;
    }

    public void setAllow_ping(String allow_ping) {
        this.allow_ping = allow_ping;
    }

    public String getAllow_feed() {
        return allow_feed;
    }

    public void setAllow_feed(String allow_feed) {
        this.allow_feed = allow_feed;
    }

    @Override
    public String toString() {
        return "ContentVo{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", content='" + content + '\'' +
                ", author_id='" + author_id + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", tags='" + tags + '\'' +
                ", categories='" + categories + '\'' +
                ", hits='" + hits + '\'' +
                ", comments_num='" + comments_num + '\'' +
                ", allow_comment='" + allow_comment + '\'' +
                ", allow_ping='" + allow_ping + '\'' +
                ", allow_feed='" + allow_feed + '\'' +
                '}';
    }
}
