package server;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class HelloApplet extends Applet implements Runnable {
    //字体大小
    private int fontSize = 8;
    //动态改变字体大小的线程，形成动画效果
    private Thread changer;
    //控制线程启动与关闭的标志
    private boolean stopFlag = true;
    //新建一个按钮对象
    private Button contrlButton = new Button("开始动态显示！");

    public void init(){
        contrlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stopFlag){
                    start();
                }else{
                    stop();
                }
            }
        });

        setBackground(Color.WHITE);
        add(contrlButton);
        setSize(100,100);
    }

    public void start(){
        changer = new Thread(this);
        stopFlag=false;
        fontSize=8;
        contrlButton.setLabel("停止动态显示！");
        changer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("newFont",Font.BOLD,fontSize));
        g.drawString("Hello",30,80);
    }

    public void stop(){
        stopFlag=true;
        contrlButton.setLabel("开始动态显示");
    }

    public void run(){
        while(!stopFlag){
            repaint();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(fontSize++>40){
                fontSize=8;
            }
        }
    }

}
