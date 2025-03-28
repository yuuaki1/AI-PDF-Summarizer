package com.ds.rep.Service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ds.rep.entity.Chat;
import com.ds.rep.repo.ChatRepo;

@Service
public class ChatService {
    
    private final ChatClient chatClient;
    private final ChatRepo chatRepo;

    public ChatService(ChatClient.Builder chatClientBuilder, ChatRepo chatRepo) {
        this.chatClient = chatClientBuilder.build();
        this.chatRepo = chatRepo;
    }

    public String processChat(String message, MultipartFile file) throws IOException {
        String fileContent = "";
        byte[] fileData = null;
        String fileName = null;
        String fileType = null;

        if (file != null && !file.isEmpty()) {
            fileData = file.getBytes();
            fileName = file.getOriginalFilename();
            fileType = file.getContentType();
            fileContent = extractTextFromPDF(file);
        }

        String aiResponse = chatClient
                .prompt(message + " " + fileContent)
                .call()
                .content();

        Chat chat = new Chat(null, message, aiResponse, fileData, fileName, fileType);
        chatRepo.save(chat);

        return aiResponse;
    }

    private String extractTextFromPDF(MultipartFile file) throws IOException {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            return new PDFTextStripper().getText(document);
        }
    }
}
