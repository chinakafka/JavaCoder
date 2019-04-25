package server;
import java.util.*;

public class Muster {
    public static void main(String[] args) {
        //实例化一个集合类对象
        Collection<String> list = new ArrayList<>();
        //向列表中添加字符串元素
        list.add("a");
        list.add("b");
        list.add("c");
        //创建一个迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()) { //判断是否还有下一个元素
            //获取集合中的下一个元素
            String str = (String) it.next();
            //输出集合中的元素
            System.out.println(str);
        }

    }
}
