package com.main.hw.controllers;

import com.main.hw.services.HuffmanService;
import com.main.hw.services.altHuffmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/huffman")
public class HuffmanController {
    private final HuffmanService huffmanService;

    @Autowired
    public HuffmanController(HuffmanService huffmanService) {
        this.huffmanService = huffmanService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("huffmanCodes", null);
        return "huffman";
    }

    @PostMapping
    public String encode(@RequestParam String text, Model model) {
        Map<String, String> huffmanCodes = huffmanService.encode(text);
        model.addAttribute("huffmanCodes", huffmanCodes);
        model.addAttribute("text", text);
        return "huffman";
    }
}

