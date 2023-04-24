package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Category;
import uz.pdp.springbootprojectprocesses.payload.CategoryDto;
import uz.pdp.springbootprojectprocesses.payload.Result;
import uz.pdp.springbootprojectprocesses.serviceImp.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }

    @GetMapping
    public  List<Category> getCategory(){
       List<Category> categoryList = categoryService.getCategory();
       return categoryList;
    }


    @GetMapping("/{id}")
    public  Category getCategory(@PathVariable UUID id){
        Category categoryById = categoryService.getCategoryById(id);
        return categoryById;
    }


    @PutMapping("/editCategory/{id}")
    public  Result editCategory(@RequestBody CategoryDto categoryDto, @PathVariable UUID id){
        Result result = categoryService.editCategoryById(categoryDto,id);
        return result;
    }


    @DeleteMapping("/deleteCategory/{id}")
    public  Result deleteCategory(@PathVariable UUID id){
        Result result = categoryService.deleteCategory(id);
        return result;
    }


}
