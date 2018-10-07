package com.company.project.core;


public class PageResult<T> {
    private T result;
    private int pageNum = 1;
    private int pageSize = 10;
    private long total = 0;
    private boolean hasNext = true;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isHasNext() {
        if (getCurrentPage() == getTotalPages()) {
            return false;
        }
        return true;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public long getTotalPages() {
        return (total + pageSize - 1) / pageSize;
    }

    public long getCurrentPage() {
        if (pageNum < 0) {
            return 1;
        } else if (pageNum > getTotal()) {
            return getTotalPages();
        } else {
            return pageNum;
        }
    }
}
