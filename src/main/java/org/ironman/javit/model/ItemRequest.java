package org.ironman.javit.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ItemRequest
 */
public class ItemRequest {

    @NotBlank
    private String title;

    @NotNull
    @Min(1)
    private Integer qty;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    
}