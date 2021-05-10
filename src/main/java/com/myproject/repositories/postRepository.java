package com.myproject.repositories;

import com.myproject.Entitiy.Category;
import com.myproject.Entitiy.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface postRepository extends JpaRepository<Post,Long> {
    List<Post> findByCategory(Category category);
}
