package com.my.springbootintegratemybatis.common;

import java.util.List;

public class PageResult<T> {
    public long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> items;

}
