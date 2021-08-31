package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Categories.CategoriesRepository;
import com.codeup.blogapp.data.Categories.Category;
import com.codeup.blogapp.data.Posts.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/categories", headers = "accept=application/json")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping("{name}")
    private Category getPostsByCategory(@PathVariable String name) {
        return null;
    }

    @GetMapping
    private List<Category> getCategories() {
        return categoriesRepository.findAll();
    }

    @PostMapping
    private void createCategory(@RequestBody Category newCategory) {
        categoriesRepository.save(newCategory);
    }

    @PutMapping("{id}")
    private void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        categoriesRepository.save(category);
    }

    @DeleteMapping("{id}")
    private void deleteCategory(@PathVariable Long id) {
        categoriesRepository.deleteById(id);
    }

}
