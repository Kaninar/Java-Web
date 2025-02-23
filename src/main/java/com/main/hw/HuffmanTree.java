package com.main.hw;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanTree
{
    private HuffmanNode root;
    private HashMap<Character, String> dictionary;

    public HuffmanTree(String input)
    {
        createTree(input);
    }

    private void createTree(String input)
    {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> priorityQueue =
                new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        for (char c : frequencyMap.keySet()) {
            priorityQueue.add(new HuffmanNode(c, frequencyMap.get(c)));
        }

        while (priorityQueue.size() > 1)
        {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);

            newNode.left = left;
            newNode.right = right;

            left.code += '0';
            right.code += '1';

            priorityQueue.add(newNode);
        }

        HuffmanNode root = priorityQueue.poll();

        dictionary = new HashMap<>();

        makeMap(root);
    }

    void makeMap(HuffmanNode root)
    {
        if (root.left == null && root.right == null) {

            dictionary.put(root.data, root.code);
        }

        if (root.left != null) {
            makeMap(root.left);
        }

        if (root.right != null) {
            makeMap(root.right);
        }
    }

    public String Encode(String text)
    {
        StringBuilder encoded = new StringBuilder();

        text.chars().forEach((c -> encoded.append(dictionary.get(c))));

        return encoded.toString();
    }
}

class HuffmanNode
{
    char data;
    int frequency;
    HuffmanNode left, right;
    String code;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.code = "";
        left = right = null;
    }
}
