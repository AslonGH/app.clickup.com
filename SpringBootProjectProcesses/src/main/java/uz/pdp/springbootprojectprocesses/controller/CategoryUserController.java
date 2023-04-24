package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Category;
import uz.pdp.springbootprojectprocesses.entity.les10_1.CategoryUser;
import uz.pdp.springbootprojectprocesses.payload.CategoryDto;
import uz.pdp.springbootprojectprocesses.payload.CategoryUserDto;
import uz.pdp.springbootprojectprocesses.payload.Result;
import uz.pdp.springbootprojectprocesses.serviceImp.CategoryService;
import uz.pdp.springbootprojectprocesses.serviceInterface.CategoryUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/categoryUser")
public class CategoryUserController {


    @Autowired
    CategoryUserService categoryUserService;

    @PostMapping
    public Result addCategoryUser(@RequestBody CategoryUserDto categoryUserDto){
        Result result = categoryUserService.addCategoryUser(categoryUserDto);
        return result;
    }

    @PutMapping("/editCategoryUser/{id}")
    public  Result editCategoryUser(@RequestBody CategoryUserDto categoryUserDto, @PathVariable UUID id){
        Result result = categoryUserService.editCategoryUserById(categoryUserDto,id);
        return result;
    }


    @DeleteMapping("/deleteCategoryUser/{id}")
    public  Result deleteCategoryUser(@PathVariable UUID id){
        Result result = categoryUserService.deleteCategoryUser(id);
        return result;
    }

}
