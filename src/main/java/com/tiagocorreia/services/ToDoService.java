package com.tiagocorreia.services;

import com.tiagocorreia.Entities.ToDo;
import com.tiagocorreia.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

  @Autowired
  ToDoRepository toDoRepository;

/*
  private final List<ToDo> todos = new ArrayList<>(Arrays.asList(
      new ToDo(1,"task_1","summary_1","desc_1"),
      new ToDo(2,"task_2","summary_2","desc_2"),
      new ToDo(3,"task_3","summary_3","desc_3")
  ));
*/

  public List<ToDo> getAllTodos(){

    List<ToDo> todos = new ArrayList<>();
    toDoRepository.findAll().forEach(todos::add);
    return todos;

    //return todos;
  }


  public Optional<ToDo> getTodo(Integer id) {
   /* for (ToDo td : todos) {
      if (td.getId().equals(id)) {
        return td;
      }
    }
    return todos.get(0);*/
    return toDoRepository.findById(id);
  }

  public void createToDo(ToDo td) {
    toDoRepository.save(td);
    //todos.add(td);
  }

  public void updateTodo(ToDo todo, Integer id) {
/*    for(ToDo td: todos){
     if(td.getId().equals(id)){
       todos.set(id-1,todo);
     }
    }*/

    toDoRepository.save(todo);
  }

  public void deleteTodo(Integer id) {
/*    for(ToDo td : todos){
      if(td.getId().equals(id)){
        todos.remove(id -1);
      }
    }*/

    toDoRepository.deleteById(id);
  }
}
