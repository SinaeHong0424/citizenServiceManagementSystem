package com.government.serviceportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.government.serviceportal.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    //get all comments for a request, oldest first
    List<Comment> findBySericeRequestIdOrderByCreatedDateAsc(Long serviceRequestId);
}