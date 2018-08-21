package com.nxd.ftt.entity;

/**
 * Created by Administrator on 2017/5/24.
 */
public class ProgressBean {
    private long bytesRead;
    private long contentLength;
    private int items;

    public ProgressBean(long bytesRead, long contentLength, int items) {
        this.bytesRead = bytesRead;
        this.contentLength = contentLength;
        this.items = items;
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
