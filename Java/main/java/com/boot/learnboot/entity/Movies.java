package com.boot.learnboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "banner")
    private String banner;

    @Column(name = "views")
    private int views;

    @Column(name = "descreption")
    private String descreption;

    @Column(name = "duration")
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Column(name = "active")
    private int active;

    @Column(name = "dateAired")
    private Date dateAired;

    @Column(name = "quality")
    private String quality;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "actor")
    private String actor;

    @OneToMany(mappedBy = "movies")
    List<CategoryItemMovie> listCategoryItemMovies;

    @OneToMany(mappedBy = "movies")
    List<MovieDetail> listMovieDetails;

    @OneToMany(mappedBy = "movies")
    List<Slider> listSlider;

    @OneToMany(mappedBy = "movies")
    List<Likes> listLikes;

    @OneToMany(mappedBy = "movies")
    List<Comments> listComments;

}
