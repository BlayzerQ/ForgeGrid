package com.forgegrid.dal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Type type;
    private String title;
    private String description;
    private String productVersion;
    private String mcVersion;
    private String changelog;
    private String developer;
    private int price;

    public ProductEntity(Type type, String title, String description, String productVersion, String mcVersion, String developer, int price) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.productVersion = productVersion;
        this.mcVersion = mcVersion;
        this.developer = developer;
        this.price = price;
    }

    public enum Type {
        WEB,
        MOD,
        PLUGIN
    }
}
