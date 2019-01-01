package com.myself.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author Created by zion
 * @Date 2019/1/1.
 */
public class ReadFileTest {
    @Test
    public void readLine() throws Exception {
        File file = new File("D:\\Demo\\MOOC\\algorithmImpl\\src\\main\\resource\\testG1.txt");
        InputStream inputStream = new FileInputStream(file);
        List<String> fileContent = ReadFile.readLine(inputStream);
        for (int i = 0; i < fileContent.size(); i++) {
            System.out.println(fileContent.get(i));
        }
        System.out.println(fileContent.size());
    }

}