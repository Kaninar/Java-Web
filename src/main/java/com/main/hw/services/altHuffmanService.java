package com.main.hw.services;

import com.main.hw.HuffmanTree;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class altHuffmanService
{
    @GetMapping
    public Map<String, String> encode(String text)
    {
        HuffmanTree tree = new HuffmanTree(text);
        List<String> encoded = new ArrayList<>();
        List<String> words =  List.of(text.split("\\s"));
        words.forEach(t -> encoded.add(tree.Encode(t)));
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < encoded.size(); i++)
        {
            map.put(encoded.get(i), encoded.get(i));
        }
        return map;
    }
}
