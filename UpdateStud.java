package server;
import java.util.*;
public class UpdateStud
{
    public static void main(String[]args)
    {    //创建Map实例
         Map<String,String>map = new HashMap<>();
         //向集合中添加对象
        map.put("01","张曼玉");
        map.put("02","关之琳");
        //构建Map集合中所有key对象的集合
        Set<String>set = map.keySet();
        //创建集合迭代器
        Iterator<String>it = set.iterator();
        System.out.println("key集合中的元素：");
        //遍历集合
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //构建Map集合中所有Values值的集合
        Collection<String>coll=map.values();
        it=coll.iterator();
        System.out.println("values集合中的元素：");
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
