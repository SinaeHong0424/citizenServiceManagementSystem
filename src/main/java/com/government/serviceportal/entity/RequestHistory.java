package com.government.serviceportal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "request_history")
public class RequestHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    private ServiceRequest serviceRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_user_id")
    private User changedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "previous_status")
    private ServiceRequest.RequestStatus previousStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "new_status", nullable = false)
    private ServiceRequest.RequestStatus newStatus;

    @Column(columnDefinition = "TEXT")
    private String comments;

    private LocalDateTime changedAt;

    public RequestHistory() {}

    public RequestHistory(Long id, ServiceRequest serviceRequest, User changedBy, ServiceRequest.RequestStatus previousStatus, ServiceRequest.RequestStatus newStatus, String comments, LocalDateTime changedAt) {
        this.id = id;
        this.serviceRequest = serviceRequest;
        this.changedBy = changedBy;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.comments = comments;
        this.changedAt = changedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ServiceRequest getServiceRequest() { return serviceRequest; }
    public void setServiceRequest(ServiceRequest serviceRequest) { this.serviceRequest = serviceRequest; }

    public User getChangedBy() { return changedBy; }
    public void setChangedBy(User changedBy) { this.changedBy = changedBy; }

    public ServiceRequest.RequestStatus getPreviousStatus() { return previousStatus; }
    public void setPreviousStatus(ServiceRequest.RequestStatus previousStatus) { this.previousStatus = previousStatus; }

    public ServiceRequest.RequestStatus getNewStatus() { return newStatus; }
    public void setNewStatus(ServiceRequest.RequestStatus newStatus) { this.newStatus = newStatus; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }

    @PrePersist
    protected void onCreate() {
        this.changedAt = LocalDateTime.now();
    }
}