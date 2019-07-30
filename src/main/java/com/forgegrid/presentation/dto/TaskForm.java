package com.forgegrid.presentation.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class TaskForm extends EntityBaseForm {
    private String link;
    @Range(min = 0, max = 99999)
    @NotNull(message = "Product price is required!")
    private int price;
    private String creator;
}
