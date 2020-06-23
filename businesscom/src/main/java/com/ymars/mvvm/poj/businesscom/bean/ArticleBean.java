package com.ymars.mvvm.poj.businesscom.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Mars
 * @desc 文章实体
 * @exp: {
 * "apkLink":"",
 * "audit":1,
 * "author":"",
 * "chapterId":67,
 * "chapterName":"网络基础",
 * "collect":false,
 * "courseId":13,
 * "desc":"",
 * "envelopePic":"",
 * "fresh":false,
 * "id":9704,
 * "link":"https://juejin.im/post/5d9d539ee51d45780f0604fa",
 * "niceDate":"2天前",
 * "niceShareDate":"2天前",
 * "origin":"",
 * "prefix":"",
 * "projectLink":"",
 * "publishTime":1571154375000,
 * "selfVisible":0,
 * "shareDate":1571153486000,
 * "shareUser":"鸿洋",
 * "superChapterId":98,
 * "superChapterName":"网络访问",
 * "tags":[
 * ],
 * "title":"看完这篇还不清楚缓存，求你打我（有彩蛋）",
 * "type":0,
 * "userId":2,
 * "visible":1,
 * "zan":0
 * }
 */
public class ArticleBean implements Serializable {

    private String apkLink;
    private boolean isTop = false;
    private int audit;
    private String author;
    private long chapterId;
    private String chapterName;
    private boolean collect;
    private long courseId;
    private String desc;
    private String envelopePic;
    private boolean fresh;
    private long id;
    private String link;
    private String niceDate;
    private String niceShareDate;
    private String origin;
    private String prefix;
    private String projectLink;
    private long publishTime;
    private int selfVisible;
    private long shareDate;
    private String shareUser;
    private long superChapterId;
    private String superChapterName;
    private ArrayList<TagsBean> tags;
    private String title;
    private int type;
    private long userId;
    private int zan;
    private int visible;

    public ArticleBean() {
    }

    public ArticleBean(String apkLink, boolean isTop, int audit, String author, long chapterId, String chapterName, boolean collect, long courseId, String desc, String envelopePic, boolean fresh, long id, String link, String niceDate, String niceShareDate, String origin, String prefix, String projectLink, long publishTime, int selfVisible, long shareDate, String shareUser, long superChapterId, String superChapterName, ArrayList<TagsBean> tags, String title, int type, long userId, int zan, int visible) {
        this.apkLink = apkLink;
        this.isTop = isTop;
        this.audit = audit;
        this.author = author;
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.collect = collect;
        this.courseId = courseId;
        this.desc = desc;
        this.envelopePic = envelopePic;
        this.fresh = fresh;
        this.id = id;
        this.link = link;
        this.niceDate = niceDate;
        this.niceShareDate = niceShareDate;
        this.origin = origin;
        this.prefix = prefix;
        this.projectLink = projectLink;
        this.publishTime = publishTime;
        this.selfVisible = selfVisible;
        this.shareDate = shareDate;
        this.shareUser = shareUser;
        this.superChapterId = superChapterId;
        this.superChapterName = superChapterName;
        this.tags = tags;
        this.title = title;
        this.type = type;
        this.userId = userId;
        this.zan = zan;
        this.visible = visible;
    }

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getChapterId() {
        return chapterId;
    }

    public void setChapterId(long chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getNiceShareDate() {
        return niceShareDate;
    }

    public void setNiceShareDate(String niceShareDate) {
        this.niceShareDate = niceShareDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public int getSelfVisible() {
        return selfVisible;
    }

    public void setSelfVisible(int selfVisible) {
        this.selfVisible = selfVisible;
    }

    public long getShareDate() {
        return shareDate;
    }

    public void setShareDate(long shareDate) {
        this.shareDate = shareDate;
    }

    public String getShareUser() {
        return shareUser;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public long getSuperChapterId() {
        return superChapterId;
    }

    public void setSuperChapterId(long superChapterId) {
        this.superChapterId = superChapterId;
    }

    public String getSuperChapterName() {
        return superChapterName;
    }

    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }

    public ArrayList<TagsBean> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagsBean> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "apkLink='" + apkLink + '\'' +
                ", isTop=" + isTop +
                ", audit=" + audit +
                ", author='" + author + '\'' +
                ", chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                ", collect=" + collect +
                ", courseId=" + courseId +
                ", desc='" + desc + '\'' +
                ", envelopePic='" + envelopePic + '\'' +
                ", fresh=" + fresh +
                ", id=" + id +
                ", link='" + link + '\'' +
                ", niceDate='" + niceDate + '\'' +
                ", niceShareDate='" + niceShareDate + '\'' +
                ", origin='" + origin + '\'' +
                ", prefix='" + prefix + '\'' +
                ", projectLink='" + projectLink + '\'' +
                ", publishTime=" + publishTime +
                ", selfVisible=" + selfVisible +
                ", shareDate=" + shareDate +
                ", shareUser='" + shareUser + '\'' +
                ", superChapterId=" + superChapterId +
                ", superChapterName='" + superChapterName + '\'' +
                ", tags=" + tags +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", userId=" + userId +
                ", zan=" + zan +
                ", visible=" + visible +
                '}';
    }
}
