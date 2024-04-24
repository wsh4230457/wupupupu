package com.home.wupupupu.service;

import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.Category;

import java.util.List;

public interface CategoryService {

    void addNewArticleCategory(Category category);

    List<Category> findArticleCategoryByUserId();

    Category findArticleCategoryById(Integer id);

    void updateCategory(Category category);

    void deleteCategory(Integer id);
}
