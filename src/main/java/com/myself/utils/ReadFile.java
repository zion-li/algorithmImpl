package com.myself.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取一个文件
 *
 * @author Created by zion
 * @Date 2019/1/1.
 */
public class ReadFile {

    public static List<String> readLine(InputStream fileInputStream) {
        List<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(
            new InputStreamReader(fileInputStream));
        String str;
        try {
            while ((str = br.readLine()) != null) {
                if (str.length() == 0) {
                    continue;
                }
                result.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
