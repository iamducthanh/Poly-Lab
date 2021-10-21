package com.boot.learnboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoryitem", uniqueConstraints = {@UniqueConstraint(columnNames = {"categoryId"})
})
public class CategoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "categoryId")
    Category category;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "categoryItem")
    List<CategoryItemMovie> listCategoryItemMovies;


}
