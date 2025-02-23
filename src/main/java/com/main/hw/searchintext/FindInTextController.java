package com.main.hw.searchintext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/textsearch")
public class FindInTextController
{
    private final TextSeatchService textSeatchService;

    @Autowired
    public FindInTextController(TextSeatchService textSeatchService)
    {
        this.textSeatchService = textSeatchService;
    }

    @GetMapping
    public String text()
    {
        return "textsearch";
    }

    @PostMapping
    public String find(@RequestParam("word") String word, Model model) throws IOException {
        int count = textSeatchService.wordCount(word);
        model.addAttribute("result", String.valueOf(count));
        model.addAttribute("word", word);
        return "textsearch";
    }
}
