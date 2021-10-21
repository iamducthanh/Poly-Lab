package com.boot.learnboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoryitemmovie", uniqueConstraints = {@UniqueConstraint(columnNames = {"categoryId","movieId"})})
public class CategoryItemMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "categoryId")
    CategoryItem categoryItem;

    @ManyToOne @JoinColumn(name = "movieId")
    Movies movies;


}
