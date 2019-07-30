package com.forgegrid.presentation.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public abstract class EntityBaseForm {
    private Long id;
    @NotBlank(message = "Product title is required!")
    @Size(min = 3, max = 24, message = "Product title must be between 3 and 24 characters long!")
    private String title;
    @NotBlank(message = "Product description is required!")
    @Size(min = 8, max = 128, message = "Product description must be between 8 and 128 characters long!")
    private String description;
}
