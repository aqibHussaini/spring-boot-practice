package com.myproject.Entitiy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Post {
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String tittle;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "category")
   @JsonManagedReference
   private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Post() {
    }

    public Post(Long id, String tittle, Category category) {
        this.id = id;
        this.tittle = tittle;
        this.category = category;
    }
}
