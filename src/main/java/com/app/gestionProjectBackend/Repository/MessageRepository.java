package com.app.gestionProjectBackend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
