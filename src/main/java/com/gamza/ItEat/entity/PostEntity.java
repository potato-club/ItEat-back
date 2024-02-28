package com.gamza.ItEat.entity;


import com.gamza.ItEat.enums.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "post_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(nullable = false)
    private int likesNum;

    @Column(columnDefinition = "integer default 0", nullable = false) // 기본 조회수는 0
    private int views; // 게시물 조회수를 어떤식으로 count 할지?

    @Column(nullable = false)
    private int commentsNum;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<FileEntity> images = new ArrayList<>();

    @ElementCollection(targetClass = Tag.class)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private List<Tag> tags = new ArrayList<>();

    public PostEntity updatePost(String title, String content) { // 추후 수정 내용 추가 일시적으로 제목 내용만 추가
        this.title = title;
        this.content = content;
        return this;
    }

    public int increaseViews() {
        return this.views += 1;
    }

}