package com.ymars.mvvm.poj.businesscom.bean;

import java.io.Serializable;

/**
 * @author Mars
 * @desc 标签
 * @exp： {"name":"问答","url":"/article_list/list/0?cid=440"}
 */
public class TagsBean implements Serializable {
    private String name;
    private String url;

    public TagsBean() {
    }

    public TagsBean(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TagsBean{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
