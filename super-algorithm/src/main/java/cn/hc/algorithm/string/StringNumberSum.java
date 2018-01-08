package cn.hc.algorithm.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hc on 2017/7/21.
 */
public class StringNumberSum {
    private static final String r="skdajflksadjflk> abc0@sina.com<djfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajfl> abc1@sina.com<ksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajfl> abc2@sina.com<sadjflkdjfsa;lkdfjks> abc3@sina.com<a;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkv> ab4c@sina.com<dfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajf> abc5@sina.com<ksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjf> abc6@sina.com<lkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkd> abc7@sina.com<fjksa;ljfs;alfj> abc8@sina.com<sa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflks> abc11@sina.com<adjflkdjfsa;> abc9@sina.com<lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflkdjfsa;lkdfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjf> abc12@sina.com<lkdjfsa;lk> abc55@sina.com<dfjksa;ljfs;alfjsa;lkjfsa;lkfjska;ljfsafsd\n" +
            "skdajflksadjflk> abc123@sina.com<djfsa;lkdfjksa;ljfs;alfjsa;lkjfs> abc1234@sina.com<a;lkfjska;ljfsafsd\n" +
            "sdfsakfjask;lfjsak;lfj qqq@sina.com aslk;fjsafsafsafs";
    public static void main(String[] args) {
        //stringSum();
        //Pattern p = Pattern.compile("");
        stringSum2();
    }

    public static void stringSum(){
        String str="qwer1ty23uas8rwer66re";
        String[] strings = str.split("[a-zA-Z]+");
        int sum=0;
        for (String string : strings) {
            if(!"".equals(string)){
                System.out.println(string);
                sum=sum+Integer.parseInt(string);
            }
        }
        System.out.println("sum = "+sum);
    }
    public static void stringSum2(){
        String str=r;
        Pattern pattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
        String reg="[\\w]+@[\\w]+\\.[com|net|cn]";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
