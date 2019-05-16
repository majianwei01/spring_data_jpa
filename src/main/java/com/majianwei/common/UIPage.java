package com.majianwei.common;

import org.springframework.data.domain.Page;

import java.util.List;

public class UIPage {
    private List rows;
    private Long total;

    public UIPage(Page page) {
        this.rows = page.getContent();
        this.total = page.getTotalElements();
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
