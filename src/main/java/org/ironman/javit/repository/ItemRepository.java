package org.ironman.javit.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.ironman.javit.entity.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * itemrepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}