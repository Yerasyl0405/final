package com.softproject.SoftProject;

import jakarta.persistence.*;

@Entity
@Table(name = "produc")
public class Product {
    @Id
    @Column(name = "product_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")

    private String name;
    @Column(name ="price")
    private String price;
    @Column(name = "des")
    private String description;
    @Column(name = "imageName")
    private String imageFileName;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
