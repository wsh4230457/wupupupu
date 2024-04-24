package com.home.wupupupu.mapper;

import com.home.wupupupu.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article(title,content,cover_img,state,category_belongs,create_user,create_time,update_time)" +
            "values (#{title},#{content},#{coverImg},#{state},#{categoryBelongs},#{createUser},#{createTime},#{updateTime})")
    void addArticle(Article article);
}
