package com.app.gestionProjectBackend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
