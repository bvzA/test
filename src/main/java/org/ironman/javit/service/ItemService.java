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
        item.setDeleted(false);
        item.setArchived(false);
        item.setCreateDate(new Date());
        item.setBuyDate(null);

        item = repository.save(item);
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
        List<Item> list = repository.findAll();
        ItemListResponse liseres = new ItemListResponse();
        liseres.setItems(new ArrayList<>());
        int counttotal = 0;
        int countAchived = 0;
        int countShopping = 0;
        for (Item item : list) {
            if(item.getDeleted()){
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

    public ItemResponse getItem(Integer id) {
        var opItem = repository.findById(id);
        if(opItem.isPresent()) {
            var item = opItem.get();
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

        return null;
    }

    public ItemResponse editItem(Integer id, ItemRequest request) {
        Item item = repository.getOne(id);

        if(item == null) {
            return null;
        }

        if(item.getChecked()) {
            return null;
        }

        //ItemResponse itemRes = new ItemResponse();
        item.setTitle(request.getTitle());
        item.setQty(request.getQty());
        item.setCreateDate(new Date());

        item = repository.save(item);
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

    public ItemResponse removeItem(Integer id) {
        Item item = repository.getOne(id);
        if(item == null) {
            return null;
        }

        repository.deleteById(id);
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
    public ItemResponse checkedItem(Integer id){
        Item item = repository.getOne(id); 
        if(item.getChecked() == true)
        {
            item.setBuyDate(null);
            item.setChecked(false);
        }
        else
        {
            item.setBuyDate(new Date());
            item.setChecked(true);
        }
        
       
        item = repository.save(item);
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
}