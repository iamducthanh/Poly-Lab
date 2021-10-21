package com.boot.learnboot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    List<CategoryItem> listCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CategoryItem> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<CategoryItem> listCategory) {
        this.listCategory = listCategory;
    }

}
