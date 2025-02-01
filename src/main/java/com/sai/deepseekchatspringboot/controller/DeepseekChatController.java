package com.sai.deepseekchatspringboot.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeepseekChatController {
    private final ChatClient chatClient;

    public DeepseekChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> getResponse(@RequestParam String prompt) {
        String response = chatClient.prompt(prompt).call().content();
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
}
