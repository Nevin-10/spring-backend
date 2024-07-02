package com.example.Blog.BlogDAO;

import com.example.Blog.entity.Blog;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class BlogDAOImpl implements BlogDAO {
    //Defining entityManger

    private EntityManager entityManager;

    //Inject into constructor

    public BlogDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createBlog(Blog blog) {

        entityManager.persist(blog);


    }

    @Override
    public Blog readBlog(int id) {
        Blog blog = entityManager.find(Blog.class, id);
        return blog;
    }

    @Override
    public List<Blog> readAllBlogs() {
        List<Blog> blogs = entityManager.createQuery("from blog", Blog.class).getResultList();
        return blogs;
    }

    @Override
    @Transactional
    public void updateBlog(Blog blog) {
        entityManager.merge(blog);

    }

    @Override
    @Transactional
    public void deleteBlog(int id) {
        Blog blog = entityManager.find(Blog.class, id);
        entityManager.remove(blog);

    }


}
