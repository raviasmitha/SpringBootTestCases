package com.stackroute.SpringBootTask.repository;

import com.stackroute.SpringBootTask.domain.Muzix;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
@Repository
public interface MuzixRepository extends CrudRepository <Muzix, Integer> {



    @Query(value = "{name:'?0'}")
    List<Muzix> findTitleByName(String name);
}
