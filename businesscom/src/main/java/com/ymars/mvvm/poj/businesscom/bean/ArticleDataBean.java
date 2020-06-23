package com.ymars.mvvm.poj.businesscom.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Mars
 * <p>
 * exp: {"curPage":2,
 * "datas":[],
 * "offset":20,
 * "over":false,
 * "pageCount":367,
 * "size":20,
 * "total":7328
 * }
 */
public class ArticleDataBean implements Serializable {
    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private ArrayList<ArticleBean> datas;

    public ArticleDataBean() {
    }

    public ArticleDataBean(int curPage, int offset, boolean over, int pageCount, int size, int total, ArrayList<ArticleBean> datas) {
        this.curPage = curPage;
        this.offset = offset;
        this.over = over;
        this.pageCount = pageCount;
        this.size = size;
        this.total = total;
        this.datas = datas;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<ArticleBean> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<ArticleBean> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "ArticleDataBean{" +
                "curPage=" + curPage +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                ", datas=" + datas +
                '}';
    }
}
