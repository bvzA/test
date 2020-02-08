package org.ironman.javit.model;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * IndexRequest
 */
public class IndexRequest {

    private String str;
    private Integer age;

    

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

	@PostMapping(path = "/k")
	public String index(final String s) {
	    return s;
	}
    
}

