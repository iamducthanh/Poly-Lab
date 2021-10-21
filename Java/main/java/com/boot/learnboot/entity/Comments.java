package com.boot.learnboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId","movieId"})})
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "userId")
    User user;

    @ManyToOne @JoinColumn(name = "movieId")
    Movies movies;

    @Column(name = "content")
    private String content;
    @Column(name = "dateComment")
    private Date dateComment;

}
