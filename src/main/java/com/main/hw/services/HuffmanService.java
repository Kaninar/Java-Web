package com.main.hw.services;
import com.main.hw.HuffmanTree;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HuffmanService {

    public Map<String, String> encode(String text) {
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);
        PriorityQueue<HuffmanNode> priorityQueue = buildPriorityQueue(frequencyMap);
        HuffmanNode root = buildHuffmanTree(priorityQueue);
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildHuffmanCodes(root, "", huffmanCodes);

        List<String> words =  List.of(text.split("\\s"));
        List<String> encoded = new ArrayList<>();
        words.forEach(t -> encoded.add(encodeWord(t, huffmanCodes)));

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < encoded.size(); i++)
        {
            map.put(words.get(i), encoded.get(i));
        }
        return map;
    }
    public String encodeWord(String word, Map<Character, String> huffmanCodes)
    {
        StringBuilder encoded = new StringBuilder();
        for(Character c : word.toCharArray())
        {
            encoded.append(huffmanCodes.get(c));
        }
        return encoded.toString();
    }

    private Map<Character, Integer> buildFrequencyMap(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    private PriorityQueue<HuffmanNode> buildPriorityQueue(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return priorityQueue;
    }

    private HuffmanNode buildHuffmanTree(PriorityQueue<HuffmanNode> priorityQueue) {
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            priorityQueue.add(parent);
        }
        return priorityQueue.poll();
    }

    private void buildHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
        }
        buildHuffmanCodes(node.left, code + "0", huffmanCodes);
        buildHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    private static class HuffmanNode implements Comparable<HuffmanNode> {
        char character;
        int frequency;
        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanNode other) {
            return this.frequency - other.frequency;
        }
    }
}