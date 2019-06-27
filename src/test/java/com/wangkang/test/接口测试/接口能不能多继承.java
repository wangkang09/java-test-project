package com.wangkang.test.接口测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:41 2019/6/13
 * @Modified By:
 */
public class 接口能不能多继承 {

}

interface a {}
interface b {}
interface c extends a,b {} //接口可以多继承

class aa {}
class bb {}
//class cc extends aa,bb {}