package com.app.gestionProjectBackend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
