package org.ironman.javit.service;

import java.util.Date;

import org.ironman.javit.entity.Item;
import org.ironman.javit.model.ItemRequest;
import org.ironman.javit.model.ItemResponse;
import org.ironman.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * itemservice
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public ItemResponse newItem(ItemRequest request){
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
        return null;
    }
}