package com.tiagocorreia.repositories;

import com.tiagocorreia.Entities.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> {
}
