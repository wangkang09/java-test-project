package com.wangkang.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:56 2019/6/26
 * @Modified By:
 */
public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    @Override
    public Student getStudentList() {
        return new Student(1,"wk");
    }
    // 该构造期必须存在，因为集继承了UnicastRemoteObject类，其构造器要抛出RemoteException
    public StudentServiceImpl() throws RemoteException {
        super();
    }
}
