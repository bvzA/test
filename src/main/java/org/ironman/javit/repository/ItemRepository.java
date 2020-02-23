package org.ironman.javit.repository;

import org.ironman.javit.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * itemrepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}