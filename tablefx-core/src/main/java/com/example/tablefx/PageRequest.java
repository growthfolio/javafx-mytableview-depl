package com.example.tablefx;

/**
 * Request for a page of data.
 */
public class PageRequest {
    private final int pageNumber;
    private final int pageSize;

    public PageRequest(int pageNumber, int pageSize) {
        if (pageNumber < 0 || pageSize < 1) {
            throw new IllegalArgumentException("Invalid page request");
        }
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
}
