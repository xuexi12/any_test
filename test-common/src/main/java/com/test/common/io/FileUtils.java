package com.test.common.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public static String fileToString(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            StringBuilder str = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line);
            }
            return str.toString();
        } catch (Exception e) {
            throw new RuntimeException("解析文件失败", e);
        }
    }
}
