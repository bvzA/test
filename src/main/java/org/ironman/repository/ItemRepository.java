package org.ironman.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.ironman.javit.entity.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * itemrepository
 */
@Component
public class ItemRepository {

    private HashMap<Integer,Item> items = new HashMap<>();

    private int countId = 0;
    
    public Item insertItem(Item i){
        
        countId++;
        i.setId(countId);
        Item target = new Item();
        BeanUtils.copyProperties(i, target);
        items.put(countId,target);

        return i;
    }

    public Item updateItem(Item t){
        if(t.getId() == null)
        {
            throw new IllegalArgumentException("Id must be not null");
        }

        Item h = items.get(t.getId());
        if(h.getId() == null)
        {
            throw new IllegalArgumentException("not found");
        }

        BeanUtils.copyProperties(t,h);
        return h;
    }

    public List<Item> selectAll(){
        List<Item> lst = new ArrayList<>();
        for(Entry<Integer, Item> entry: items.entrySet()) {
            Item target = new Item();
            BeanUtils.copyProperties(entry.getValue(), target);
            lst.add(target);
        }

        return lst;
    }
    public Item selectById(Integer id){
        Item f = items.get(id);
        if(f.getId() == null)
        {
            return null;
        }
        Item target = new Item();
        BeanUtils.copyProperties(f, target);
        return target;
    }



}