package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(PostDto postDto){
        return ResponseEntity.ok(postService.createPost(postDto));
    }
}
