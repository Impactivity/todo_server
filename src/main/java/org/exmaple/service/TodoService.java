package org.exmaple.service;

import lombok.AllArgsConstructor;
import org.exmaple.model.TodoEntity;
import org.exmaple.model.TodoRequest;
import org.exmaple.repository.TodoRepsitory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepsitory todoRepsitory;
    public TodoEntity add(TodoRequest request){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

        return this.todoRepsitory.save(todoEntity);
    }
    public TodoEntity searchById(Long id){
        return this.todoRepsitory.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public List<TodoEntity> searchAll(){
        return this.todoRepsitory.findAll();

    }
    public TodoEntity updateById(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null){
            todoEntity.setTitle(request.getTitle());
        }

        if (request.getOrder() != null){
            todoEntity.setOrder(request.getOrder());
        }

        if (request.getCompleted() != null){
            todoEntity.setCompleted(request.getCompleted());
        }
        return  this.todoRepsitory.save(todoEntity);
    }

    public void deleteById(Long id){

    }
    public void deleteAll(Long id){
    }
}
