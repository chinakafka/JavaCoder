package server;
import java.util.*;
public class Gather {
    public static void main(String[]args){
        //创建集合对象，数组列表
        List<String> list = new ArrayList<>();
        //向数组列表中添加三个字符串元素
        list.add("a");
        list.add("b");
        list.add("c");
        //获得0-2之间的随机数
        int i =(int)(Math.random()*list.size());
        //输出列表中随机获得的元素
        System.out.println("随机获取数组中的元素："+list.get(i));
        //将指定索引位置的元素从集合中移除
        list.remove(2);
        System.out.println("将索引是‘2’的元素从数组移除后，数组中的元素是：");
        //循环遍历集合
        for(int j=0;j<list.size();j++){
            System.out.println(list.get(j));
        }
    }
}
