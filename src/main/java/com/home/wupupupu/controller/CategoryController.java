package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Category;
import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("addCategory")
    public Result addNewCategory(@RequestBody @Validated(Category.add.class) Category category){

        categoryService.addNewArticleCategory(category);
        return Result.success("成功添加文章分类");
    }
    @GetMapping("findCategory")
    public Result<List<Category>> findListCategory(){
        return Result.success(categoryService.findArticleCategoryByUserId());
    }
    @GetMapping( "detail")
    public Result<Category> categoryDetail(Integer id){
        return Result.success(categoryService.findArticleCategoryById(id));
    }
    @PutMapping("updateCategory")
    public Result updateCategory(@RequestBody@Validated(Category.update.class) Category category){
        categoryService.updateCategory(category);
        return Result.success();
    }
    @DeleteMapping("deleteCategory")
    public Result deleteCategory(Integer id){
        categoryService.deleteCategory(id);
        return Result.success();
    }
}
