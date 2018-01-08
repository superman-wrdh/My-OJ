package cn.hc.algorithm.reflect;

import java.lang.reflect.Field;

public class ReflectStudy3 {
    public static void main(String[] args) throws Exception {

        getFieldDemo();

    }

    /*
     * 获取字节码文件中的字段。
     */
    public static void getFieldDemo() throws Exception {

        Class clazz = Class.forName("cn.hc.algorithm.bean.Person");

        Field field = null;//clazz.getField("age");//只能获取公有的，

        field = clazz.getDeclaredField("age");//只获取本类，但包含私有。

        //对私有字段的访问取消权限检查。暴力访问。
        field.setAccessible(true);

        Object obj = clazz.newInstance();

        field.set(obj, 89);


        Object o = field.get(obj);

        System.out.println(o);

//		cn.hc.algorithm.bean.Person p = new cn.hc.algorithm.bean.Person();
//		p.age = 30;

    }
}
