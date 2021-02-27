package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PostsDTO;
import com.myproject.repository.PostsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostsBusinessImpl implements PostsBusiness {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public PostsDTO findPostsById(Long postsId) {
        log.info("findPostsById", postsId);
        return postsRepository.findPostsById(postsId);
    }

    @Override
    public ResultInsideDTO insertPosts(PostsDTO postsDTO) {
        log.info("insertPosts", postsDTO);
        return postsRepository.insertPosts(postsDTO);
    }

    @Override
    public ResultInsideDTO updatePostsInfo(PostsDTO postsDTO) {
        log.info("updatePostsInfo", postsDTO);
        return postsRepository.updatePostsInfo(postsDTO);
    }

    @Override
    public ResultInsideDTO deletePostsById(Long postsId) {
        log.info("deletePostsById", postsId);
        return postsRepository.deletePostsById(postsId);
    }

    @Override
    public Datatable getDatatablePosts(PostsDTO postsDTO) {
        log.info("getDatatablePosts", postsDTO);
        return postsRepository.getDatatablePosts(postsDTO);
    }
}
