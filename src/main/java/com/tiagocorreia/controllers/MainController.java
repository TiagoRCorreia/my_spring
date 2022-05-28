package com.tiagocorreia.controllers;

import com.tiagocorreia.Entities.ToDo;
import com.tiagocorreia.services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

  // sl4j é uma API que controla outros loggers
  // Os mais atuais e conhecidos são o Log4j2 e o LogBack
  // Neste caso está a ser usar a API SLF4J e com o logBack como
  // logger é o default do Spring Boot

  // Instanciação do logger
  Logger myLogger = LoggerFactory.getLogger(MainController.class);
  @Autowired
  private ToDoService toDoService;

  @RequestMapping("/todos")

  public List<ToDo> getAllTodos(){

    // Imprime uma mensage de debug
    myLogger.debug("Entrou aqui");

    // Retorno todos os todos
    return toDoService.getAllTodos();
  }

  @RequestMapping("/todo/{id}")
  public Optional<ToDo> getTodo(@PathVariable Integer id){
    return toDoService.getTodo(id);
  }

  @RequestMapping(method= RequestMethod.POST,value="/todos")
  public void createToDo(@RequestBody ToDo todo){
    toDoService.createToDo(todo);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/todos/{id}")
  public void updateToDo(@RequestBody ToDo todo, @PathVariable Integer id){
    toDoService.updateTodo(todo,id);
  }

  @RequestMapping(method=RequestMethod.DELETE,value="/todos/{id}")
  public void deleteToDo(@PathVariable Integer id){
    toDoService.deleteTodo(id);

  }

}
