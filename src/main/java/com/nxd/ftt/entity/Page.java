package com.nxd.ftt.entity;


import com.nxd.ftt.util.Const;

public class Page {

    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private boolean count;
    private Boolean reasonable;
    private Boolean pageSizeZero;
    private String countColumn;
    private String orderBy;
    private boolean orderByOnly;

    public Page() {
        this.pageSize = Const.PAGE_SIZE;
        this.pageNum = 1;
    }
    public Page(int pageNum,int pageSize) {
        this.pageSize = Const.PAGE_SIZE;
        this.pageNum = 1;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public long getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public boolean isCount() {
        return count;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public String getCountColumn() {
        return countColumn;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public boolean isOrderByOnly() {
        return orderByOnly;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public void setCountColumn(String countColumn) {
        this.countColumn = countColumn;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setOrderByOnly(boolean orderByOnly) {
        this.orderByOnly = orderByOnly;
    }
}

