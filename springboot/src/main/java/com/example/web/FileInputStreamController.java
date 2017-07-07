package com.example.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by aiyabeetle on 2017/6/19.
 */
public class FileInputStreamController {

    public static void main(String[] args) throws IOException {
        //ReadFile();
        //readFiles();
        readFilesAllBytes();
    }

    public static void ReadFile() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("F:\\jquery 跨域.txt");
            byte[] b = new byte[1024];
            int len = 0;
            fos = new FileOutputStream("F:\\out.txt");
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  static void readFiles() throws IOException{
        Path workRelative = Paths.get("D:\\out.txt");
        Path fileName = workRelative.getFileName();
        FileSystem fileSystem = workRelative.getFileSystem();
        Path rootPath = workRelative.getRoot();
        boolean absolute = workRelative.isAbsolute();
        System.out.println("fileName:"+fileName);
        System.out.println("fileSystem:"+fileSystem);
        System.out.println("rootPath:"+rootPath);
        System.out.println("absolute:"+absolute);
    }

    public static void readFilesAllBytes() throws IOException {
        Path path = Paths.get("F:\\input.txt");
        Path newpath = Paths.get("F:\\output.txt");
        Path copypath = Paths.get("F:\\copy.txt");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes, Charset.forName("GBK"));
        Files.write(newpath,content.getBytes("GBK"));//写入文件
        //Files.copy(path,copypath);//复制文件
        Files.deleteIfExists(copypath);//如果存在，删除文件

    }
}
