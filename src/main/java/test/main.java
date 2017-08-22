package test;


import java.sql.*;

public class main {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/nteaag";
    public static final String USER = "root";
    public static final String PASSWORD = "123.";

    public static void main(String[] args) {
        //声明Connection对象
        Connection con = null;
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(DRIVER);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from user WHERE id='nteaag01'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("用户ID" + "\t" + "姓名");
            System.out.println("-----------------");

            String id = null;
            String name = null;
            while (rs.next()) {
                //获取name这列数据
                name = rs.getString("name");
                //获取id这列数据
                id = rs.getString("id");

                //输出结果
                System.out.println(id + "\t" + name);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }
    }

}