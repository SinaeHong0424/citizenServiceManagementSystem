package com.government.serviceportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.government.serviceportal.entity.RequestHistory;

@Repository
public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long>{
    //get audit trail for a specific request, ordered by most recent change
    List<RequestHistory> findByServiceRequestIdOrderByChangedAtDesc(Long requestId);
}