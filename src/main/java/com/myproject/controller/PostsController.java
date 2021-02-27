package com.myproject.controller;

import com.myproject.business.PostsBusiness;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PostsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/mapi/postsController")
public class PostsController {
    @Autowired
    PostsBusiness postsBusiness;

    @PostMapping(value = "/getDatatablePosts")
    public ResponseEntity<Datatable> getDatatablePosts(@RequestBody PostsDTO postsDTO) {
        Datatable datatable = postsBusiness.getDatatablePosts(postsDTO);
        return new ResponseEntity<>(datatable, HttpStatus.OK);
    }

    @GetMapping(value = "/getDetail")
    public ResponseEntity<PostsDTO> findPostsById(@RequestParam Long postsId) {
        PostsDTO postsDTO = postsBusiness.findPostsById(postsId);
        return new ResponseEntity<>(postsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<ResultInsideDTO> insertPosts(@RequestBody PostsDTO postsDTO) {
        ResultInsideDTO resultInsideDTO = postsBusiness.insertPosts(postsDTO);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/updatePostsInfo")
    public ResponseEntity<ResultInsideDTO> updatePostsInfo(@RequestBody PostsDTO postsDTO) {
        ResultInsideDTO resultInsideDTO = postsBusiness.updatePostsInfo(postsDTO);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<ResultInsideDTO> deletePostsById(@RequestParam Long postsId) {
        ResultInsideDTO resultInsideDTO = postsBusiness.deletePostsById(postsId);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }
}
