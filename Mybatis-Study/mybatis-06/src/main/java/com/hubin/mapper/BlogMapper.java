package com.hubin.mapper;

import com.hubin.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

//    @Insert("insert into mybatis.blog (id, title, author, create_time, views) values (#{id},#{title},#{author},#{create_time},#{views})")
    int addBlog(Blog blog);
    //需求：根据作者名字和博客名字来查询博客！如果作者名字为空，那么只根据博客名字查询，反之，则根据作者名来查询
    List<Blog> queryBlogIf(Map map);
    //更新
    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}
