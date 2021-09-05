package com.udacity.persistence.entities0.repository;

import com.udacity.persistence.entities0.model.Delivery;

public interface Deliverable {
    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);
}
