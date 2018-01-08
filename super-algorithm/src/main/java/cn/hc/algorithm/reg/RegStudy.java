package cn.hc.algorithm.reg;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * * 正则表达式对字符串的常见操作:
 * 1, 匹配。
 * 		其实使用的就是String类中的matches方法。
 *
 * 2，切割。
 * 		其实使用的就是String类中的split方法。
 *
 * 3，替换。
 * 		其实使用的就是String类中的replaceAll()方法。
 *
 * 4，获取。
  */
public class RegStudy {
    public static void main(String[] args) {
        regMach();
       //regSpit();
       //regReplace();
        //getAttr();
    }

    /**
     * 匹配手机号
     */
    public static void regMach(){
        String phone="12800000001";
        //第一位是1 第二位目前有 3 5 7 8 剩下9位没有限制
        String reg="1[3578]\\d{9}";
        boolean b = phone.matches(reg);
        System.out.println(b);
    }

    /**
     * 切割
     */
    public static void regSpit(){
        String str = "zhangsanttttxiaoqiangmmmmmmzhaoliu";

        String[] names = str.split("(.)\\1+");//str.split("\\.");

        for(String name : names){
            System.out.println(name);
        }
    }

    /**
     * 替换
     */
    public static void regReplace(){
        String str = "zhangsanttttxiaoqiangmmmmmmzhaoliu";

        str = str.replaceAll("(.)\\1+", "$1");

        System.out.println(str);

        String tel = "15800001111";//158****1111;

        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

        System.out.println(tel);

        String tmp="my name is {name},I am from {country} ";

        tmp = tmp.replaceAll("\\{\\w+\\}","%s");

        System.out.println(tmp);

    }

    /**
     * 获取
     */
    public static void regFind(){
        String str = "da jia hao,ming tian bu fang jia!";

        String regex = "\\b[a-z]{3}\\b";

        //1,将正则封装成对象。
        Pattern p = Pattern.compile(regex);
        //2, 通过正则对象获取匹配器对象。
        Matcher m = p.matcher(str);

        //使用Matcher对象的方法对字符串进行操作。
        //既然要获取三个字母组成的单词
        //查找。 find();
        System.out.println(str);
        while(m.find()){
            System.out.println(m.group());//获取匹配的子序列
            System.out.println(m.start()+":"+m.end());
        }
    }

    /**
     * 获取{}里面的值
     * 使用()之后从1开始分组 不使用()从0开始分组
     */
    public static void getAttr(){
        String  tmp="my name is {name},I am from {country}";
        Pattern p = Pattern.compile("\\{((\\w)+)\\}");
        Matcher matcher = p.matcher(tmp);
        System.out.println("-----------------------");
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
        System.out.println("-----------------------");

        Pattern p2 = Pattern.compile("(\\{)((\\w)+)(\\})");
        Matcher matcher2 = p2.matcher(tmp);
        while (matcher2.find()){
            System.out.println(matcher2.group(2));
        }
        System.out.println("-----------------------");

        Pattern p3 = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher3 = p3.matcher(tmp);
        while (matcher3.find()){
            System.out.println(matcher3.group(1));
        }
        System.out.println("-----------------------");

        Pattern p4 = Pattern.compile("(\\{)(.*?)(\\})");
        Matcher matcher4 = p4.matcher(tmp);
        while (matcher4.find()){
            System.out.println(matcher4.group(2));
        }
        System.out.println("-----------------------");
    }
}
