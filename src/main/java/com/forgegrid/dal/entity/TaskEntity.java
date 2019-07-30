package com.forgegrid.dal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String link;
    private String creator;
    private int price;

    public TaskEntity(String title, String description, String link, String creator, int price) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.creator = creator;
        this.price = price;
    }
}
