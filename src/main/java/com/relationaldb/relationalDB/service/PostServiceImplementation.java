package com.relationaldb.relationalDB.service;


import com.relationaldb.relationalDB.entity.Comment;
import com.relationaldb.relationalDB.entity.Post;
import com.relationaldb.relationalDB.repository.CommentRepository;
import com.relationaldb.relationalDB.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post createComment(Comment comment) {
        Post post = postRepository.findById(comment.getFkPostId()).get();
        post.addComment(comment);
        commentRepository.save(comment);
        return postRepository.save(post);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.deleteById(comment.getId());
    }

    @Override
    public void deletePost(Post post) {
        Post postToBeDeleted = postRepository.findById(post.getId()).get();
        if(postToBeDeleted.getComments().size() >= 0) {
            postToBeDeleted.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
        }
        postRepository.deleteById(post.getId());
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
