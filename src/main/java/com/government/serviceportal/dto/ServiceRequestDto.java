package com.government.serviceportal.dto;

import java.time.LocalDateTime;

import com.government.serviceportal.entity.ServiceRequest;

public class ServiceRequestDto {

    public static class CreateRequest {
        private String title;
        private String description;
        private ServiceRequest.RequestCategory category;
        private ServiceRequest.RequestPriority priority;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public ServiceRequest.RequestCategory getCategory() { return category; }
        public void setCategory(ServiceRequest.RequestCategory category) { this.category = category; }

        public ServiceRequest.RequestPriority getPriority() { return priority; }
        public void setPriority(ServiceRequest.RequestPriority priority) { this.priority = priority; }
    }

    public static class Response {
        private Long id;
        private String title;
        private String description;
        private String status;
        private String category;
        private String priority;
        private String applicantName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public String getPriority() { return priority; }
        public void setPriority(String priority) { this.priority = priority; }

        public String getApplicantName() { return applicantName; }
        public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

        public LocalDateTime getUpdatedAt() { return updatedAt; }
        public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    }

    public static class StatusUpdate {
        private ServiceRequest.RequestStatus status;
        private String comment;

        public ServiceRequest.RequestStatus getStatus() { return status; }
        public void setStatus(ServiceRequest.RequestStatus status) { this.status = status; }

        public String getComment() { return comment; }
        public void setComment(String comment) { this.comment = comment; }
    }
}