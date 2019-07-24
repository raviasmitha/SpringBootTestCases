package com.stackroute.SpringBootTask.repository;

import com.stackroute.SpringBootTask.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
@Repository
public interface MuzixRepository extends CrudRepository <Muzix, Integer> {

    @Query(
            value = "SELECT * FROM MUZIX ",
            nativeQuery = true)
    Collection<Muzix> findAllActiveUsers();

    @Query(value = "SELECT * FROM MUZIX  where name = ?1",
            nativeQuery = true )
    List<Muzix> findTitleByName(String name);
}
