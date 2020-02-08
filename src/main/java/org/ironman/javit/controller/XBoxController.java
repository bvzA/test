package org.ironman.javit.controller;

import org.ironman.javit.model.IndexReques7;
import org.ironman.javit.model.IndexRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Xboxcontroller
 */
@RestController
@RequestMapping(value = "/api/x")
public class XBoxController {

    @PostMapping("/{name}")
    public String index(@PathVariable("name") final String name, @RequestParam("t") final String s,
            @RequestBody final IndexRequest body) {
        return name + s;
    }

    @PostMapping(path = "/d")
    public IndexRequest index(@RequestBody final IndexRequest body) {
        return body;
    }

    @PostMapping(path = "/k")
    public String index(@RequestParam("t") final String s, @RequestBody final IndexRequest body) {
        return s;
    }

    @PostMapping(path = "/u")
    public IndexReques7 index(@RequestBody final IndexReques7 body) {
        return  body ;
    }
}