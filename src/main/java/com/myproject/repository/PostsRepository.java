package com.myproject.repository;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PostsDTO;

public interface PostsRepository {

    PostsDTO findPostsById(Long postsId);

    ResultInsideDTO insertPosts(PostsDTO postsDTO);

    ResultInsideDTO updatePostsInfo(PostsDTO postsDTO);

    ResultInsideDTO deletePostsById(Long postsId);

    Datatable getDatatablePosts(PostsDTO postsDTO);
}
