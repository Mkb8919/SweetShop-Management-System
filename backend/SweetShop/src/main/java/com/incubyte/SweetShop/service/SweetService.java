package com.incubyte.SweetShop.service;


import com.incubyte.SweetShop.entity.Sweet;
import com.incubyte.SweetShop.repository.SweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SweetService {

    @Autowired
    private SweetRepository sweetRepository;

    public Sweet addSweet(Sweet sweet) {
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    public Optional<Sweet> getSweetById(Long id) {
        return sweetRepository.findById(id);
    }

    public Sweet updateSweet(Long id, Sweet sweetDetails) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found with id " + id));
        sweet.setName(sweetDetails.getName());
        sweet.setCategory(sweetDetails.getCategory());
        sweet.setPrice(sweetDetails.getPrice());
        sweet.setQuantity(sweetDetails.getQuantity());
        return sweetRepository.save(sweet);
    }

    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }

    public Sweet purchaseSweet(Long id, int quantity) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found with id " + id));
        if(sweet.getQuantity() < quantity){
            throw new RuntimeException("Not enough quantity available");
        }
        sweet.setQuantity(sweet.getQuantity() - quantity);
        return sweetRepository.save(sweet);
    }

    public Sweet restockSweet(Long id, int quantity) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found with id " + id));
        sweet.setQuantity(sweet.getQuantity() + quantity);
        return sweetRepository.save(sweet);
    }



}
