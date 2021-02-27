package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.PostsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredTypes()
public class PostsDTO extends BaseDTO {

    private Long postsId;
    private Long managerId;
    private String title;
    private String content;
    private String author;
    private Date writeDate;
    private Date updateTime;
    private String picture;
    private String status;

    private String statusStr;

    public PostsDTO(Long postsId,
                    Long managerId,
                    String title,
                    String content,
                    String author,
                    Date writeDate,
                    Date updateTime,
                    String picture,
                    String status) {
        this.postsId = postsId;
        this.managerId = managerId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.writeDate = writeDate;
        this.updateTime = updateTime;
        this.picture = picture;
        this.status = status;
    }

    public PostsEntity toEntity() {
        return new PostsEntity(
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
