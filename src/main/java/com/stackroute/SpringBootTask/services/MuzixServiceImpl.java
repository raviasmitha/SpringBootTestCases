package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {

    MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository = muzixRepository;
    }

    @Override
    public Muzix saveMusix(Muzix muzix) {
        Muzix savedMuzix = muzixRepository.save(muzix);
        return savedMuzix;
    }

    @Override
    public List<Muzix> getMusix() {

        return (List<Muzix>) muzixRepository.findAll();
    }

    @Override
    public Muzix getById(int id) {
        Optional<Muzix> user_id = muzixRepository.findById(id);

        return user_id.get();
    }

    @Override
    public void deleteById(int id) {
        muzixRepository.deleteById(id);

    }

    @Override
    public boolean updateById(Muzix musix, int id) {

        Optional<Muzix> userOptional = muzixRepository.findById(id);

        if (!userOptional.isPresent())
            return false;


        musix.setId(id);

        muzixRepository.save(musix);
        return true;

    }


}
