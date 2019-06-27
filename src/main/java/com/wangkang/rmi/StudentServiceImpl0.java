package com.wangkang.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Description: 如果一个远程类已经继承了其他类，无法再继承UnicastRemoteObject类，那么可以在构造方法中调用UnicastRemoteObject类的静态exportObject()方法
 * @Author: wangkang
 * @Date: Created in 15:22 2019/6/27
 * @Modified By:
 */
public class StudentServiceImpl0  implements StudentService{

    @Override
    public Student getStudentList() {
        return new Student(0,"yq");
    }

    public StudentServiceImpl0() throws RemoteException{
        //如果一个远程类已经继承了其他类，无法再继承UnicastRemoteObject类，那么可以在构造方法中调用UnicastRemoteObject类的静态exportObject()方法
        UnicastRemoteObject.exportObject(this,0);
    }
}
