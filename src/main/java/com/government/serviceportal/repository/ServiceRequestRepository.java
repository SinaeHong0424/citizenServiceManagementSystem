package com.government.serviceportal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.government.serviceportal.entity.ServiceRequest;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long>{
    //for citizens: view their own requests
    List<ServiceRequest> findByApplicantId(Long applicantId);
    //for staff: view requests by status
    Page<ServiceRequest> findByStatus(ServiceRequest.RequestStatus status, Pageable pageable);
    //for staff: view requests by category
    Page<ServiceRequest> findByCategory(ServiceRequest.RequestCategory category, Pageable pageable);
    //custom query: search by title containing keyword)
    @Query("SELECT r FROM ServiceRequest r WHERE LOWER(r.title) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<ServiceRequest> searchByTitle(@Param("keyword") String keyword);
}