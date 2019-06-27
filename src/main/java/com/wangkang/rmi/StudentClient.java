package com.wangkang.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;


/**
 * @Description: 单独启动它会报错
 * @Author: wangkang
 * @Date: Created in 23:05 2019/6/26
 * @Modified By:
 */
public class StudentClient {
    public static void main(String[] args) throws Exception{
            //两种方式都可以获得远程对象
            StudentService stu = (StudentService) Naming.lookup("stu");
            Context namingContext = new InitialContext();
            StudentService stu0 = (StudentService) namingContext.lookup("rmi:stu");
            System.out.println(stu0.getStudentList().toString());
            System.out.println(stu.getStudentList().toString());

        StudentService stu01 = (StudentService) namingContext.lookup("rmi:stu0");
        System.out.println(stu01.getStudentList().toString());

    }
}
