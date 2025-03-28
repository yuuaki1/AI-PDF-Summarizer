package com.ds.rep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ds.rep.Service.ChatService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class A_Controller {
    
    private final ChatService chatService;

    public A_Controller(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> handleChat(
        @RequestParam("message") String message,
        @RequestParam(value = "file", required = false) MultipartFile file
    ) {
        try {
            return ResponseEntity.ok(chatService.processChat(message, file));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error processing chat: " + e.getMessage());
        }
    }
}
