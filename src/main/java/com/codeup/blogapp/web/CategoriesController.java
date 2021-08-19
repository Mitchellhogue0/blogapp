package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/api/categories", headers = "application/json")
public class CategoriesController {

    @GetMapping
    private List<Category> getCategory() {
        return null;
    }


}
