package com.myproject.Entitiy;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
    public Product() {
    }
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(length = 20)
private Long id;
@Column(name = "name",length = 255)
@NotBlank(message = "name is required")
@Size(min =6 ,max =16 ,message = "name must be between 6 and 16")
private String name;
@Column(name = "picture",length = 255)
private String picture;
@Column(name = "price")
private Double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
