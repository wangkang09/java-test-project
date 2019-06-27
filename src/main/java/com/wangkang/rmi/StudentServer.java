package com.wangkang.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 23:02 2019/6/26
 * @Modified By:
 */
public class StudentServer {
    public static void main(String[] args) throws Exception{
        //创建一个远程对象，实质上隐含了是生成stub和skeleton,并返回stub代理引用
        StudentService stu = new StudentServiceImpl();
        StudentService stu0 = new StudentServiceImpl0();
        //在本地主机上创建和导出注册表实例，并在指定的端口上接受请求
        //Java默认端口是1099，缺少注册表创建，则无法绑定对象到远程注册表上
        LocateRegistry.createRegistry(1099);

        //把远程对象注册到RMI注册服务器上----------

        //JDK 1.3及以下
        //Naming.rebind("stu",stu);//绑定的URL标准格式为：rmi://host:port/name(其中rmi://host:port都可以省略）

        //JDK 1.3 以上
        Context namingContext = new InitialContext();//初始化命名上下文
        //把远程对象注册到RMI注册服务器上，注意：rmi 协议名不能省略，host:port可以省略
        namingContext.rebind("rmi:stu",stu);
        namingContext.rebind("rmi:stu0",stu0);
        System.out.println("服务器已启动！");

    }
}
