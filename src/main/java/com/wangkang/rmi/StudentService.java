package com.wangkang.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:47 2019/6/26
 * @Modified By:
 */
//Remote 接口是一个标志接口，标志这个接口中所包含的方法从非本地虚拟机上调用
public interface StudentService extends Remote {
    //由于方法会通过网络调用，所以必须抛出 远程异常来说明该方法有风险
    Student getStudentList() throws RemoteException;

}
