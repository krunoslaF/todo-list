package com.krunoslav.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id"})
public class TodoItem {

    // == private fields ==

    private int id;
    private String title;
    private String detail;
    private LocalDate deadline;

    // == contructors ==
    public TodoItem(String title, String detail, LocalDate deadline) {
        this.title = title;
        this.detail = detail;
        this.deadline = deadline;
    }

    public TodoItem(int id, String title, String detail, LocalDate deadline) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.deadline = deadline;
    }

    public TodoItem() {
    }
}
