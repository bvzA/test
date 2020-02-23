package org.ironman.javit.controller;

import javax.validation.Valid;

import org.ironman.javit.model.ItemListResponse;
import org.ironman.javit.model.ItemRequest;
import org.ironman.javit.model.ItemResponse;
import org.ironman.javit.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemController
 */
@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService ;
    
    @PostMapping("")
    public ItemResponse addItem (@Valid @RequestBody ItemRequest body) {
        logger.info("addItem");

        return itemService.newItem(body);
        
    }
    @GetMapping("")
    public ItemListResponse listItem (){
        logger.info("listItem");
        return itemService.listAll();

    }

    @GetMapping("/{id}")
    public ItemResponse getItem (@PathVariable("id") Integer id){
        logger.info("GetItem");
        return itemService.getItem(id);
    }

    @PostMapping("/{id}")
    public ItemResponse editItem (@PathVariable("id") Integer id, @RequestBody ItemRequest body){
        logger.info("EditItem");
        return itemService.editItem(id, body);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ItemResponse removeItem (@PathVariable("id") Integer id){
        logger.info("RemoveItem");
        return itemService.removeItem(id);
    }

}