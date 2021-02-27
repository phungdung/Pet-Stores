package com.myproject.data.entity;

import com.myproject.data.dto.PostsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "POSTS")
public class PostsEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbaiviet")
    private Long postsId;

    @Column(name = "idnguoiquantri")
    private Long managerId;

    @Column(name = "tieude")
    private String title;

    @Column(name = "noidung")
    private String content;

    @Column(name = "tacgia")
    private String author;

    @Column(name = "ngayviet")
    private Date writeDate;

    @Column(name = "ngaycapnhat")
    private Date updateTime;

    @Column(name = "hinhanh")
    private String picture;

    @Column(name = "trangthai")
    private String status;

    public PostsDTO toDto() {
        return new PostsDTO(
                postsId,
                managerId,
                title,
                content,
                author,
                writeDate,
                updateTime,
                picture,
                status
        );
    }
}
