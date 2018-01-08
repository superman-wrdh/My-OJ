package cn.hc.algorithm.reg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getHtml {
    public static void main(String[] args) {
        String strings = readFile("E:\\IDEA16Project\\super-code\\super-algorithm\\src\\main\\resources\\index.html");
        getImgSrc(strings);
        List<String> imgs = getImgs(strings);
        for (String img : imgs) {
            System.out.println("---------------------------");
            System.out.println(img);
        }
    }
    public static String readFile(String fileName){
        List<String> r = new ArrayList<>();
        FileReader fr=null;
        BufferedReader bfr = null;
        StringBuffer sb=new StringBuffer();
        try {
             fr= new FileReader(fileName);
             bfr = new BufferedReader(fr);
             String line=null;
             while ((line=bfr.readLine()) != null){
                 sb=sb.append(line);
             }
        }catch (Exception e){
             e.printStackTrace();
        }finally {
            if(fr != null){
                try {
                    fr.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(bfr != null){
               try {
                   bfr.close();
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
            return sb.toString();
        }
    }

    /**
     * 获取全部img标签
     */
    public static List<String> getImgs(String input){
        //String  oldPattrn="<img.*>|IMG";    "<(img|IMG).*>"
        List<String> r  = new ArrayList<>();
        Pattern p = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)"); // <(img|IMG)(.*?)(/>|></img>|>)
        Matcher matcher = p.matcher(input);
        while (matcher.find()){
            String re=matcher.group();
            r.add(re);
        }
        return r;
    }

    public String getSrc(String input){
        //获取src
        System.out.println("---------get Src----------------");
        Pattern pSrc= Pattern.compile("(<)(img|IMG)(.*)(src=\\\")(.*)(\\\")>");
        Matcher msrc = pSrc.matcher(input);
        while (msrc.find()){
            //System.out.println("group count"+msrc.groupCount());
            String src = msrc.group(5);
            System.out.println(src);
            return src;
        }
        System.out.println("----------get Src---------------");
        //获取src
        return null;
    }

    /**
     * 从一串文本中获取img标签的src属性值
     * @param input
     */
    public static void getImgSrc(String input){
        Pattern p = Pattern.compile("<(img|IMG)(.*?)(src=\\\")(.*?)(\\\")(.*?)(/>|></img>|>)");
        Matcher matcher = p.matcher(input);
        System.out.println("------------------------");
        while (matcher.find()){
            //System.out.println("group0 "+matcher.group());
            System.out.println("group4 "+matcher.group(4));
            //System.out.println("5-"+matcher.group(5));
        }
        System.out.println("------------------------");
    }

    /**
     * 获取img标签中的属性值
     * @param input
     * @return
     */
    public static String getSrcAttr(String input){
        Pattern p = Pattern.compile("(src|SRC)=(\\\"|\\')(.*?)(\\\"|\\')");
        //                                1        2      3      4
        Matcher matcher = p.matcher(input);
        while (matcher.find()){
            return matcher.group(3);
        }
        return null;
    }
}
