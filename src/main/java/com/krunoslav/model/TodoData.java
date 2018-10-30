package com.krunoslav.model;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Component
public class TodoData {

    // == fields ==
    public static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<TodoItem>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");

    // == constructors ==
    public TodoData() {

        // add some dummy data using addItem method so it sets the id field
        addItem(new TodoItem("odlazak","krenuti doma", LocalDate.now()));
        addItem(new TodoItem("dućan","kupiti namirnice za suprugu", LocalDate.now().minusDays(1)));
        addItem(new TodoItem("refactoring","odraditi do kraja kod za probe", LocalDate.now().plusDays(3)));
        addItem(new TodoItem("otići na tenis","Šalata",LocalDate.now().minusDays(2)));
    }

    // == public methods ==
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem itemToAdd){
        itemToAdd.setId(idValue);
        idValue++;
        items.add(itemToAdd);
    }

    public void removeItem(int id){
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while(itemListIterator.hasNext()){
            TodoItem item = itemListIterator.next();
            if (item.getId() == id){
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for (TodoItem item : items){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();
            if (item.equals(toUpdate)){
                itemIterator.set(toUpdate);
                break;
            }
        }
    }


}
