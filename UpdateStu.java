package server;
import java.util.Iterator;
import java.util.TreeSet;
//创建类实现Comparable接口
public class UpdateStu implements Comparable<Object>{
    //声明姓名变量
    String name;
    //声明学生ID
    long id;

    //无参构造方法
    UpdateStu(){

    }

    //构造方法
    public UpdateStu(String name,long id){
        this.id = id;
        this.name=name;
    }
    //参照代码说明
    public int compareTo(Object o){
        UpdateStu upstu = (UpdateStu)o;
        int result=id>upstu.id?1:(id==upstu.id?0:-1);
        return result;
    }
    //获得名字的方法
    public String getName(){
        return name;
    }
    //设置名字的方法
    public void setName(String name ){
        this.name = name;
    }
    //获得学生ID的方法
    public long getId(){
        return id;
    }
    //设置学生ID的方法
    public void setId(long id){
        this.id=id;
    }
    //主方法
    public static void main(String[]args){
        UpdateStu stuOne = new UpdateStu("张曼玉",01011);
        UpdateStu stuTwo = new UpdateStu("关之琳",01021);
        UpdateStu stuThree = new UpdateStu("梅艳芳",01051);
        UpdateStu stuFour = new UpdateStu("邓丽君",01012);

        //创建一个集合树对象
        TreeSet<UpdateStu> tree = new TreeSet<>();
        //向集合中添加对象
        tree.add(stuOne);
        tree.add(stuTwo);
        tree.add(stuThree);
        tree.add(stuFour);
        //Set集合中的所有对象的迭代器
        Iterator<UpdateStu> it = tree.iterator();
        System.out.println("Set集合中的所有元素：");

        //遍历集合
        while(it.hasNext()){
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getId()+""+stu.getName());
        }
        //截取排在stuTwo对象之前的对象
        it = tree.headSet(stuTwo).iterator();
        System.out.println("截取前面部分的集合：");

        //遍历集合
        while(it.hasNext()){
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getId()+""+stu.getName());
        }
        //截取stuTwo与stuThree之间的对象
        it = tree.subSet(stuTwo,stuThree).iterator();
        System.out.println("截取中间部分的集合");
        //遍历集合
        while(it.hasNext()){
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getId()+""+stu.getName());
        }
    }
}
