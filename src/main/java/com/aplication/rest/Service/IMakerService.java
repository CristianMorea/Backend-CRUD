package com.aplication.rest.Service;

import com.aplication.rest.Entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {


    List<Maker> findAll();

    Optional< Maker> finById(long id);

    void save(Maker maker);

    void deleteById(long id);
}
