package com.home.wupupupu.mapper;

import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CategoryMapper {

    @Insert("insert into category(category_name,category_alias,create_time,update_time,create_user) " +
            "values (#{categoryName},#{categoryAlias},now(),now(),#{id})")
    void addNewCategory(Category category);

    @Select("select category_name as categoryName,category_alias as categoryAlias,create_user as createUser,create_time as createTime,update_time as updateTime" +
            " from category where create_user=#{userid}")
    List<Category> findArticleCategoryByUserId(int userId);
    @Select("select id, category_name as categoryName,category_alias as categoryAlias,create_user as createUser,create_time as createTime,update_time as updateTime" +
            " from category where id=#{id}")
    Category findArticleCategoryById(Integer id);
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=now()" +
            "where id=#{id}")
    void updateCategory(Category category);
    @Delete("delete from category where id=#{id}")
    void deleteCategory(Integer id);
}
