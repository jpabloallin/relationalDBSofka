package com.relationaldb.relationalDB.service;


import com.relationaldb.relationalDB.entity.Comment;
import com.relationaldb.relationalDB.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post);

    Post createComment(Comment comment);

    void deleteComment(Comment comment);

    void deletePost(Post post);

    List<Post> findAllPosts();
}
