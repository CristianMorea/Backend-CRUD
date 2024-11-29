package com.aplication.rest.Service.impl;

import com.aplication.rest.Entities.Maker;
import com.aplication.rest.Service.IMakerService;
import com.aplication.rest.persistence.IMakerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class MakerService implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public Optional<Maker> finById(long id) {
        return makerDAO.finById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void deleteById(long id) {
        makerDAO.deleteById(id);
    }
}
