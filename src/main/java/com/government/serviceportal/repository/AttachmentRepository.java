package com.government.serviceportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.government.serviceportal.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long>{
    //get all attachments for a specific request
    List<Attachment> findByServiceRequestId(Long serviceRequestId);
}