package com.wcy.GUI.snake;

import com.wcy.GUI.snake.source.UserCharts;

import java.io.*;
import java.util.ArrayList;

public class UserDomo {
    ArrayList<User> users = new ArrayList<User>();//集合里面是用户对象
    User user = new User();
    static String path = Thread.currentThread().getContextClassLoader().getResource("usersmsg").getPath();
    static String chartsPath = Thread.currentThread().getContextClassLoader().getResource("ChartsMsg").getPath();
    //这是数据文件的路径，文件路径勿用中文
    //这个文件是放在out目录下面的
    boolean flag = false;//假定没有的时候

    //是否存在姓名
    public Boolean isExist(String name,ArrayList<User> users){
        Boolean flag = false;
        for(int i=0;i<users.size();i++){
            User u = users.get(i);
            if(u.getName().equals(name)){
                flag =!flag;
                break;
            }

        }
        return flag;
    }

    //写入文件//输入(注册调用)
    public void msg(ArrayList<User> users ) throws IOException {
        //创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        for (User user : users) {
            bw.write(user.getName()+","+user.getPsd());
            bw.newLine();
        }
        bw.close();
    }

    //文件是否有name
    public boolean hasNameSimilar(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<User> users = new ArrayList<User>();//集合里面是用户对象
        String line;
        while((line = br.readLine()) != null){//br.read.line读一行
            String[] strs = line.split(",");//分割
            User u = new User();
            u.setName(strs[0]);
            users.add(u);
        }
        //释放资源
        br.close();
        //判断文件中是否有账户
        for (User user : users) {
            if(user.getName().equals(name)){
                flag = true;//有账号可跳出
                break;
            }
        }
        return flag;
    }

    //读取文件//输出(登录调用)
    public boolean msgRead(String name,String psd) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine()) != null){//br.read.line读一行
            String[] strs = line.split(",");//分割
            User u = new User();
            u.setName(strs[0]);
            u.setPsd(strs[1]);
            users.add(u);
        }
        //释放资源
        br.close();
        //判断文件中是否有账户密码
        for (User user : users) {
            if(user.getName().equals(name)&&user.getPsd().equals(psd)){
                flag = true;//有账号可跳出
                break;
            }
        }
        return flag;
    }

    // 修改密码
public boolean resetDemo(String name,String psd) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    String line;
    while((line = br.readLine()) != null){//br.read.line读一行
        String[] strs = line.split(",");//分割
        User u = new User();
        u.setName(strs[0]);
        u.setPsd(psd);
        users.add(u);
    }
    //释放资源
    br.close();
    //文件的密码改为传过来的密码
    int index=-1;
    int indexDemo =0;
    for (User user : users) {
        index++;
        if(user.getName().equals(name)){
            indexDemo = index;
            user.setName(name);
            user.setPsd(psd);
            users.remove(indexDemo);
            BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
            bw.write(user.getName()+","+user.getPsd());
            bw.newLine();
            bw.close();
            flag = true;
            break;
        }
    }
    return flag;

}

    //排行榜写入
    public static void chartmsg(UserCharts charUser) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(chartsPath,true));
            bw.write(charUser.getName()+","+charUser.getScore());
            bw.newLine();
            bw.close();
    }

    public static ArrayList<UserCharts> chartsMsgRead() throws IOException {
        ArrayList<UserCharts> list = new ArrayList<UserCharts>();
        UserCharts uc = new UserCharts();
        BufferedReader br = new BufferedReader(new FileReader(chartsPath));
        String line;
        while((line = br.readLine()) != null){//br.read.line读一行
            String[] strs = line.split(",");//分割
            uc = new UserCharts();
            uc.setName(strs[0]);
            uc.setScore(Integer.parseInt(strs[1]));
            list.add(uc);
        }
//        for (UserCharts u : list) {
//            System.out.println(u.getName()+"----"+u.getScore());
//        }
        //释放资源
        br.close();
        return list ;

    }
    public static void main(String[] args) {

    }
}
