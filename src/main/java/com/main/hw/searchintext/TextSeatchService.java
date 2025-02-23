package com.main.hw.searchintext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TextSeatchService
{
    @Autowired
    private ResourceLoader resourceLoader;

    public int wordCount(String word) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + "static/text.txt");

        InputStream inputStream = resource.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        reader.close();

        return StringUtils.countMatches(stringBuilder.toString(), word);
    }

}
