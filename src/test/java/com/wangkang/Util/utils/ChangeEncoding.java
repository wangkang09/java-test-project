package com.wangkang.Util.utils;

import java.io.*;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:33 2019/6/29
 * @Modified By:
 */
public class ChangeEncoding {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\wangk\\Desktop\\Java视频课程\\Java 高级开发工程师视频\\课件\\第一章—多线程并发编程";
        String toEncoding = "utf-8";
        getAllJavaDoc(path,toEncoding);
    }

    private static void getAllJavaDoc(String path, String toEncoding) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();

        for (File file1 : files) {
            if(file1.isDirectory()) {
                getAllJavaDoc(path + "\\" + file1.getName(), toEncoding);
            } else {
                if(file1.getName().endsWith(".java")) {
                    changeTo(file1,toEncoding);
                }
            }
        }
    }

    private static void changeTo(File file1, String toEncoding) throws IOException {

        String fromEncoding = new FileCharsetDetector().guessFileEncoding(file1);
        if(toEncoding.equalsIgnoreCase(fromEncoding)) return;

        BufferedReader bdf = new BufferedReader(new InputStreamReader(new FileInputStream(file1),fromEncoding));

        String str=null;
        StringBuilder context = new StringBuilder();
        while((str=bdf.readLine())!=null){
            context.append(str).append("\n");
        }

        BufferedWriter bdw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1),toEncoding));
        bdw.write(context.toString());
        System.out.println("将" + file1.getPath() + "文件格式从 " + fromEncoding + " 转换为 " + toEncoding);
        bdw.close();
        bdf.close();
    }
}
