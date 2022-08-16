package com.hubin.mapper;

import com.hubin.pojo.Blog;
import com.hubin.utils.IDUtil;
import com.hubin.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest  {
    @Test
    public void testAddBlog() {
        SqlSession session= MybatisUtils.getSession();
        BlogMapper mapper=session.getMapper(BlogMapper.class);

        Blog blog=new Blog(IDUtil.getId(),"Mybatis如此简单","胡斌",new Date(),9999);
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("python如此简单");
        mapper.addBlog(blog);

        session.commit();
        session.close();
    }
    @Test
    public void testqueryBlogIf(){
       SqlSession session= MybatisUtils.getSession();
       BlogMapper mapper=session.getMapper(BlogMapper.class);
       HashMap<String,String> map=new HashMap<String,String>();
       map.put("title","Mybatis如此简单");
       map.put("author","胡斌");
       List<Blog> blogs= mapper.queryBlogIf(map);
       System.out.println(blogs);
       session.close();
   }
   @Test
   public void testupdateBlog(){
        SqlSession session=MybatisUtils.getSession();
        BlogMapper mapper=session.getMapper(BlogMapper.class);
        Map<String,String> map=new HashMap<String,String> ();
        map.put("title","动态");
        map.put("author","胡斌");
        map.put("id","ff48f8fd4f5840cd813c2bf2d90c200e");
        mapper.updateBlog(map);
        session.commit();
        session.close();
    }
    @Test public void queryBlogChoose(){
        SqlSession session=MybatisUtils.getSession();
        BlogMapper mapper=session.getMapper(BlogMapper.class);
        Map<String,String> map=new HashMap<String,String> ();
        map.put("title","动态");
        map.put("author","胡斌");
        map.put("views","9999");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        System.out.println(blogs);
        session.commit();
        session.close();
    }
    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        List<Blog> blog2s = mapper.queryBlogForeach(map);
        System.out.println(blogs);

        session.close();
    }
}