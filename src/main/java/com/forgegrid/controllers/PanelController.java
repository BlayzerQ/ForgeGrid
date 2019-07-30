package com.forgegrid.controllers;

import com.forgegrid.bussines.service.NewsService;
import com.forgegrid.bussines.service.ProductService;
import com.forgegrid.bussines.service.TaskService;
import com.forgegrid.dal.entity.ProductEntity;
import com.forgegrid.dal.entity.TaskEntity;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.ProductForm;
import com.forgegrid.presentation.dto.TaskForm;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
public class PanelController {

    private final ProductService productService;
    private final TaskService taskService;

    public PanelController(ProductService productService, TaskService taskService) {
        this.productService = productService;
        this.taskService = taskService;
    }

    @GetMapping("/panel")
    public String products(Model model, @AuthenticationPrincipal UserEntity user) {
        model.addAttribute("mode", "products");
        model.addAttribute("data", new ProductForm());
        model.addAttribute("alldata", productService.getProductsByDeveloper(user));
        return "panel";
    }

    @GetMapping("/panel/tasks")
    public String tasks(Model model, @AuthenticationPrincipal UserEntity user) {
        model.addAttribute("mode", "tasks");
        model.addAttribute("data", new TaskForm());
        model.addAttribute("alldata", taskService.getTasksByCreator(user));
        return "panel";
    }

    @PostMapping("/panel/addproduct")
    public String addProduct(Model model, @Valid @ModelAttribute("data") ProductForm productForm, Errors errors, Principal principal) {
        if (errors.hasErrors()) {
            model.addAttribute("mode", "products");
            return "panel";
        }
        productForm.setDeveloper(principal.getName());
        productService.addItem(productForm);
        return "redirect:/panel";
    }

    @PostMapping("/panel/addtask")
    public String addProduct(Model model, @Valid @ModelAttribute("data") TaskForm taskForm, Errors errors, Principal principal) {
        if (errors.hasErrors()) {
            model.addAttribute("mode", "tasks");
            return "panel";
        }
        taskForm.setCreator(principal.getName());
        taskService.addTask(taskForm);
        return "redirect:/panel/tasks";
    }

    @PostMapping("/panel/editproduct")
    public String editProduct(Model model, @Valid @ModelAttribute("data") ProductForm productForm, Errors errors, @AuthenticationPrincipal UserEntity user) {
        if (errors.hasErrors()) {
            model.addAttribute("mode", "products");
            model.addAttribute("alldata", productService.getProductsByDeveloper(user));
            return "panel";
        }
        productService.getByID(productForm.getId()).ifPresent(product -> {
            if (product.getDeveloper().equals(user.getLogin())) {
                product.setType(productForm.getType());
                product.setTitle(productForm.getTitle());
                product.setDescription(productForm.getDescription());
                product.setProductVersion(productForm.getProductVersion());
                product.setMcVersion(productForm.getMcVersion());
                product.setPrice(productForm.getPrice());

                productService.editItem(product);
            }
        });
        return "redirect:/panel";
    }

    @PostMapping("/panel/edittask")
    public String editTask(Model model, @Valid @ModelAttribute("data") TaskForm taskForm, Errors errors, @AuthenticationPrincipal UserEntity user) {
        if (errors.hasErrors()) {
            model.addAttribute("mode", "tasks");
            model.addAttribute("alldata", taskService.getTasksByCreator(user));
            return "panel";
        }
        taskService.getByID(taskForm.getId()).ifPresent(task -> {
            if (task.getCreator().equals(user.getLogin())) {
                task.setTitle(taskForm.getTitle());
                task.setDescription(taskForm.getDescription());
                task.setLink(taskForm.getLink());
                task.setPrice(taskForm.getPrice());

                taskService.editTask(task);
            }
        });
        return "redirect:/panel/tasks";
    }

    @PostMapping("/panel/deleteproduct/{id}")
    public String deleteProduct(@PathVariable final long id, Principal principal) {
        productService.getByID(id).ifPresent(product -> {
            if (product.getDeveloper().equals(principal.getName())) {
                productService.deleteItem(id);
            }
        });
        return "redirect:/panel";
    }

    @PostMapping("/panel/deletetask/{id}")
    public String deleteTask(@PathVariable final long id, Principal principal) {
        taskService.getByID(id).ifPresent(task -> {
            if (task.getCreator().equals(principal.getName())) {
                taskService.deleteTask(id);
            }
        });
        return "redirect:/panel/tasks";
    }
}
