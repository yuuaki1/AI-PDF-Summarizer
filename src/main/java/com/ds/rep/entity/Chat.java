package com.ds.rep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "chat")
public class Chat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_message", columnDefinition = "TEXT")
    private String userMessage;

    @Column(name = "ai_response", columnDefinition = "TEXT")
    private String aiResponse;

    // @ManyToOne(targetEntity = User.class)
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_type")
    private String fileType;

    public Chat(String userMessage, String aiResponse, String fileName, String fileType, byte[] fileData) {
        this.userMessage = userMessage;
        this.aiResponse = aiResponse;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }
}
