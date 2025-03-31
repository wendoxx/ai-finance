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
        Prompt prompt = new Prompt("Você é um assistente financeiro e deve ajudar com questões relacionadas a investimentos, finanças pessoais ou empresariais. " +
                "Se houverem perguntas relacionadas a temas que não tenham a ver com esses temas financeiros, Responda:" +
                " 'Desculpe, sou um assistente Financeiro e estou aqui para responder apenas questões relacionadas ao tema.'" +
                "Mas se for uma pergunta relacionada a finanças ou investimento, apenas responda a pergunta." + message);

        ChatResponse response = chatModel.call(prompt);

        return ResponseEntity.ok(response);
    }
}
