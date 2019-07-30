package com.forgegrid.presentation.dto;

import com.forgegrid.dal.entity.ProductEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductForm extends EntityBaseForm {
    @NotBlank(message = "Product version is required!")
    @Size(min = 1, max = 8, message = "Product version must be between 1 and 8 characters long!")
    private String productVersion;
    @NotBlank(message = "Product version is required!")
    @Size(min = 4, max = 8, message = "Minecraft version must be between 4 and 8 characters long!")
    private String mcVersion;
    @NotNull(message = "Product type is required!")
    private ProductEntity.Type type;
    @Range(min = 0, max = 99999)
    @NotNull(message = "Product price is required!")
    private int price;
    private String developer;
}
