package com.myproject.Controllers;

import com.myproject.Entitiy.Category;
import com.myproject.Entitiy.Post;
import com.myproject.repositories.categoryRepository;
import com.myproject.repositories.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class testController {
    @Autowired
    postRepository postRepository;
    @Autowired
    categoryRepository categoryRepository;
    @GetMapping("/save-post")
    public Post savePost()
    {
        Post post=new Post();
        Long id=1l;
        post.setTittle("mypost");
        post.setCategory(this.categoryRepository.findById(id).get());
        Post post1=this.postRepository.save(post);
        System.out.println(post1.toString()+post.toString());
        return post1;
    }
    @GetMapping("/save-category")
    public Category saveCategory()
    {
        Category category=new Category();
        category.setName("category");
        return this.categoryRepository.save(category);
    }
    @GetMapping("/get-post")
    public List<Post> getPost()
    {
        Long c_id=1l;
        List<Post> posts=this.postRepository.findByCategory(this.categoryRepository.findById(c_id).get());
        posts.stream().forEach(p->System.out.println(p.toString()+p.getCategory().toString()));
        return posts;
    }
    @GetMapping("/get-a-post")
    public Post Post()
    {
        Post post=this.postRepository.findById(2l).get();
       System.out.println(post.getCategory());
        System.out.println(post.toString());
        return post;
    }
    @GetMapping("/get-category")
    public List<Category> getCategory()
    {
        return this.categoryRepository.findAll();
    }
}
