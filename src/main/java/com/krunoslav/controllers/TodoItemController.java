package com.krunoslav.controllers;

import com.krunoslav.model.TodoData;
import com.krunoslav.model.TodoItem;
import com.krunoslav.service.TodoItemService;
import com.krunoslav.service.TodoItemServiceImpl;
import com.krunoslav.util.AttributeNames;
import com.krunoslav.util.Mappings;
import com.krunoslav.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
@Slf4j
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attribute section ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }


    @RequestMapping(value = Mappings.ITEMS, method = RequestMethod.GET)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){
        if (id == -1){
            log.info("Adding new item...");
            TodoItem todoItem = new TodoItem("", "" , LocalDate.now().plusYears(2));
            model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
            return ViewNames.ADD_ITEM;
        } else {
            log.info("Editing existing item with id {}.", id);
            TodoItem todoItem = todoItemService.getItem(id);
            model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
            return ViewNames.ADD_ITEM;
        }

    }
    @PostMapping(Mappings.ADD_ITEM)
    public String processAddItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form: {}", todoItem);
        int pomId = todoItem.getId();

        if (todoItemService.getItem(pomId) != null){
            todoItemService.updateItem(todoItem);
            log.info("Editing existing item with ID {}", pomId);
            return "redirect:/" + Mappings.ITEMS;
        }

        todoItemService.addItem(todoItem);
        log.info("Adding brand new item with ID {}", pomId);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.REMOVE_ITEM)
    public String removeEditItem(@RequestParam int id){
        log.info("Deleting item with id: {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        log.info("Retrieving todoItem with ID = {}", id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }


}
