package com.stackroute.SpringBootTask.repository;

import com.stackroute.SpringBootTask.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {
}
