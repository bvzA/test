package org.ironman.javit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ironman.javit.entity.Item;
import org.ironman.javit.model.ItemListResponse;
import org.ironman.javit.model.ItemRequest;
import org.ironman.javit.model.ItemResponse;
import org.ironman.javit.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * itemservice
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public ItemResponse newItem(ItemRequest request) {
        Item item = new Item();
        item.setTitle(request.getTitle());
        item.setQty(request.getQty());
        item.setChecked(false);
        item.setDelete(false);
        item.setArchived(false);
        item.setCreateDate(new Date());
        item.setBuyDate(null);

        repository.insertItem(item);
        ItemResponse itemRes = new ItemResponse();
        itemRes.setTitle(item.getTitle());
        itemRes.setQty(item.getQty());
        itemRes.setId(item.getId());
        itemRes.setChecked(item.getChecked());
        itemRes.setBuyDate(item.getBuyDate());
        itemRes.setArchived(item.getArchived());
        itemRes.setAddedDate(item.getCreateDate());
        return itemRes;
    }

    public ItemListResponse listAll() {
        List<Item> list = repository.selectAll();
        ItemListResponse liseres = new ItemListResponse();
        liseres.setItems(new ArrayList<>());
        int counttotal = 0;
        int countAchived = 0;
        int countShopping = 0;
        for (Item item : list) {
            if(item.getDelete()){
                continue;
            }
            counttotal++;
            if(item.getArchived()){
                countAchived++;
            }
            else{
                countShopping++;
            }
            ItemResponse itemRes = new ItemResponse();
            itemRes.setTitle(item.getTitle());
            itemRes.setQty(item.getQty());
            itemRes.setId(item.getId());
            itemRes.setChecked(item.getChecked());
            itemRes.setBuyDate(item.getBuyDate());
            itemRes.setArchived(item.getArchived());
            itemRes.setAddedDate(item.getCreateDate());

            liseres.getItems().add(itemRes);

        }
        liseres.setTotal(counttotal);
        liseres.setTotalAchived(countAchived);
        liseres.setTotalShopping(countShopping);
        
        return liseres;
        
    }
}