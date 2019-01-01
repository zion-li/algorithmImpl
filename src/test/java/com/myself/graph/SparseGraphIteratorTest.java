package com.myself.graph;

import com.myself.utils.ReadFile;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Created by zion
 * @Date 2019/1/1.
 */
public class SparseGraphIteratorTest {
    @Test
    public void begin() throws Exception {
    }

    @Test
    public void next() throws Exception {

    }

    @Test
    public void end() throws Exception {

    }

    public static void main(String[] args) {
        File file = new File("D:\\Demo\\MOOC\\algorithmImpl\\src\\main\\resource\\testG1.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> fileContent = ReadFile.readLine(inputStream);
        String[] strings = fileContent.get(0).split(" ");
        SparseGrahp sparseGrahp = new SparseGrahp(Integer.parseInt(strings[0]), false);
        for (int i = 1; i < fileContent.size(); i++) {
            String[] v = fileContent.get(i).split(" ");
            sparseGrahp.addEdge(Integer.parseInt(v[0]), Integer.parseInt(v[1]));
        }
        System.out.println();
    }

}