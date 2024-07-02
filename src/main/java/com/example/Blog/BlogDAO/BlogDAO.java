package com.example.Blog.BlogDAO;

import com.example.Blog.entity.Blog;
import java.util.List;

public interface BlogDAO {

    void createBlog(Blog blog); //Since we are passing the blog object for creation.
    Blog readBlog(int id); //Returning blog object
    List<Blog> readAllBlogs();

    void updateBlog(Blog blog);
    void deleteBlog(int id);//Delete always with ID
}
