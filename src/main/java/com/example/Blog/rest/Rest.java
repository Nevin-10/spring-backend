package com.example.Blog.rest;


import com.example.Blog.BlogDAO.BlogDAO;
import com.example.Blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "https://nevin-10.github.io")
@RequestMapping("/blog")
public class Rest {



    //Constructor injection
    private BlogDAO blogDAO;

    @Autowired //using AutoWired not beans
    public Rest(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    @GetMapping("/get")
    public String get() {
        return "Hello World";
    }

    @PostMapping("/create")
    //ResponseEntity is an object of http, return response to postman as an entity(object)
    public ResponseEntity<String> create(@RequestBody Blog blog) {//Getting Blog object from body

        blogDAO.createBlog(blog);
        return ResponseEntity.ok("Success");



    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Blog> get(@PathVariable int id) { //getting ID from path
        Blog blog=blogDAO.readBlog(id);
        if(blog!=null) {
            return ResponseEntity.ok(blog);

        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Blog>> getAll(){
        //List<Blog> List of the class
        List<Blog> blogs=blogDAO.readAllBlogs();
        return ResponseEntity.ok(blogs);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Blog newblog) { //getting ID from path and the body as Blog object
        Blog blog=blogDAO.readBlog(id);
        if(blog!=null) {
            blog.setEntry(newblog.getEntry());
            blogDAO.updateBlog(blog);
            return ResponseEntity.ok("Success");
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        blogDAO.deleteBlog(id);
        return ResponseEntity.ok("Success");
    }

}
