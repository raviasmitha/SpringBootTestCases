package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MuzixService {

    public Muzix saveMusix(Muzix musix);

    public List<Muzix> getMusix();

    public Muzix getById(int id) ;

    public void deleteById(int id);

    public boolean updateById(Muzix musix, int id);

}
