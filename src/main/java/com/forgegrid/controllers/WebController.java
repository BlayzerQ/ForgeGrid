package com.forgegrid.controllers;

import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.bussines.service.NewsService;
import com.forgegrid.bussines.service.ProductService;
import com.forgegrid.bussines.service.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {

    private final NewsService newsService;
    private final ProductService productService;
    private final TaskService taskService;

    public WebController(NewsService newsService, ProductService productService, TaskService taskService) {
        this.newsService = newsService;
        this.productService = productService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "RESTful API is working.");
        return "index";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", newsService.getAll());
        return "news";
    }

    @GetMapping("/tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "tasks";
    }

    @GetMapping("/tasks/task/{id}")
    public String taskItem(@PathVariable final long id, Model model) {
        model.addAttribute("task", taskService.getByID(id));
        return "task";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("products", productService.getAll());
        return "catalog";
    }

    @GetMapping("/catalog/item/{id}")
    public String catalogItem(@PathVariable final long id, Model model) {
        model.addAttribute("product", productService.getByID(id));
        return "product";
    }

    @GetMapping("/payment/{id}")
    public String payment(@PathVariable final long id, Model model) {
        return "product";
    }

}
