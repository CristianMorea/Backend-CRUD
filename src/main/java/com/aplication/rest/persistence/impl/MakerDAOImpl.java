package com.aplication.rest.persistence.impl;

import com.aplication.rest.Entities.Maker;
import com.aplication.rest.persistence.IMakerDAO;
import com.aplication.rest.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> finById(long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);

    }
    @Override
    public void deleteById(long id) {
        makerRepository.deleteById(id);

    }
}
