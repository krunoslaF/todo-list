package com.krunoslav.service;

import com.krunoslav.model.TodoData;
import com.krunoslav.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    private final TodoData todoData;

    // == constructors ==
    @Autowired
    public TodoItemServiceImpl(TodoData todoData) {
        this.todoData = todoData;
    }

    public void addItem(TodoItem toAdd) {
        todoData.addItem(toAdd);
    }

    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    public TodoItem getItem(int id) {
        return todoData.getItem(id);
    }

    public void updateItem(TodoItem toUpdate) {
        todoData.updateItem(toUpdate);
    }

    public TodoData getData() {
        return todoData;
    }
}
