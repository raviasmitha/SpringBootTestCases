package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;


import java.util.List;

public interface MuzixService {

    public Muzix saveMusix(Muzix musix) throws TrackAlreadyExistsException;

    public List<Muzix> getMusix();

    public Muzix getById(int id) throws TrackNotFoundException;

    public Muzix deleteById(int id) throws TrackNotFoundException;

    public boolean updateById(Muzix musix, int id);

    public List<Muzix> getBYName(String name);


}
