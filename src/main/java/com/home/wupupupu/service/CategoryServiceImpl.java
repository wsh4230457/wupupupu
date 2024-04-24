package com.home.wupupupu.service;

import com.home.wupupupu.mapper.CategoryMapper;
import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.Category;
import com.home.wupupupu.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void addNewArticleCategory(Category category) {
        Map<String,Object>map = ThreadLocalUtil.get();
        category.setId((int) map.get("id"));
        categoryMapper.addNewCategory(category);
    }

    @Override
    public List<Category> findArticleCategoryByUserId() {
        Map<String,Object>map = ThreadLocalUtil.get();
        int userId=(int) map.get("id");
        return categoryMapper.findArticleCategoryByUserId(userId);
    }

    @Override
    public Category findArticleCategoryById(Integer id) {

        return categoryMapper.findArticleCategoryById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }


}
