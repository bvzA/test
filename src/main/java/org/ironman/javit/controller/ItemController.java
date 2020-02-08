package org.ironman.javit.controller;

import org.ironman.javit.model.ItemListResponse;
import org.ironman.javit.model.ItemRequest;
import org.ironman.javit.model.ItemResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemController
 */
@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping("")
    public ItemResponse addItem (@RequestBody ItemRequest body) {
        logger.info("addItem");
        return null;
        
    }
    @GetMapping("")
    public ItemListResponse listItem (){
        logger.info("listItem");
        return null;

    }

}