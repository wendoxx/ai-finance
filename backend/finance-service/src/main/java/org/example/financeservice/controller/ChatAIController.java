package org.example.financeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat-ai")
@AllArgsConstructor
public class ChatAIController {

    private final OllamaChatModel chatModel;

    @GetMapping("/ai")
    public ResponseEntity<ChatResponse> aiChat(@RequestParam(value = "message") String message) {
        Prompt prompt = new Prompt("\"Você é um assistente financeiro especializado em investimentos, finanças pessoais e empresariais. " +
                "Seu objetivo é fornecer respostas claras, precisas e úteis dentro desse contexto. " +
                "Se uma pergunta estiver relacionada a finanças ou investimentos, responda diretamente de forma objetiva e informativa. " +
                "Caso a pergunta não tenha relação com esses temas, responda educadamente: 'Desculpe, sou um assistente financeiro e posso responder apenas questões relacionadas a finanças e investimentos.'" + message);

        ChatResponse response = chatModel.call(prompt);

        return ResponseEntity.ok(response);
    }
}
