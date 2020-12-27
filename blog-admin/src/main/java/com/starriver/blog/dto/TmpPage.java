package com.starriver.blog.dto;

import com.github.pagehelper.PageInfo;
import com.sun.corba.se.impl.oa.toa.TOA;

import java.util.List;

/**
 * @Name: TmpPage
 * @Description: TmpPage
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public class TmpPage<T> {
    private int current;
    private List<T> records;
    private int size;
    private long total;

    public TmpPage(PageInfo<T> pageInfo){
        current = pageInfo.getPageNum();
        size = pageInfo.getPageSize();
        total = pageInfo.getTotal();
        records = pageInfo.getList();
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
