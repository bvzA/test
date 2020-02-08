package org.ironman.javit.model;

import java.util.List;

/**
 * ItemReadResponse
 */
public class ItemListResponse {

    private Integer total;
    private Integer totalAchived;
    private Integer totalShopping;
    private List<ItemResponse> items;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalAchived() {
        return totalAchived;
    }

    public void setTotalAchived(Integer totalAchived) {
        this.totalAchived = totalAchived;
    }

    public Integer getTotalShopping() {
        return totalShopping;
    }

    public void setTotalShopping(Integer totalShopping) {
        this.totalShopping = totalShopping;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }



}