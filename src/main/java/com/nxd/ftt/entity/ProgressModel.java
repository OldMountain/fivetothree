package com.nxd.ftt.entity;

/**
 * ProgressModel
 *
 * @author luhangqi
 * @date 2017/10/31
 */
public class ProgressModel {
    private long bytesRead;

    private long contentLength;

    private long items;

    public ProgressModel(long bytesRead, long contentLength, long items) {
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

    public long getItems() {
        return items;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public void setItems(long items) {
        this.items = items;
    }
}
