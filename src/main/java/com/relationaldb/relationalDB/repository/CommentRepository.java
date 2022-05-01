package com.relationaldb.relationalDB.repository;

import com.sofkaU.relationalDB.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
}
