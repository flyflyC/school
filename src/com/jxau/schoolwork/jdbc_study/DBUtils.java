package com.jxau.schoolwork.jdbc_study;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Queue;


import org.apache.log4j.Logger;

public class DBUtils {
    Queue<Integer> queue;
    private static Logger logger = Logger.getLogger(String.valueOf(DBUtils.class));
    private static String className = "";
    private String url = "";
    private String password = "";
    private String user = "";
    private Connection connection;// 连接数据库
    private Statement statement;// 发送非预编译的sql语句
    private PreparedStatement preparedStatement; // 预编译sql语句
    private ResultSet resultSet;// 获得结果集
    private static Properties properties;

    /**
     * 加载配置文件
     */
    public static Properties getProperties(String pathName) throws IOException {
        properties = new Properties();
        logger.debug("properties" + properties);
        InputStream in = DBUtils.class.getClassLoader().getResourceAsStream(pathName);
        logger.debug("in" + in);
        try {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("propertise:" + properties);
        return properties;
    }

    /**
     *2.获得驱动类并加载驱动
     */
    static {
        String pathname = "jdbc.properties";
        try {
            properties = getProperties(pathname);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.1获得驱动的类
        className = properties.getProperty("driverClassName");
        logger.debug("className:" + className);
        try {
            // 2.2 加载驱动
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库
     */
    private Connection getConnection() throws SQLException {
        this.url = properties.getProperty("url");
        this.user = properties.getProperty("username");
        this.password = properties.getProperty("password");
        this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        logger.debug("connection:" + connection);
        return connection;
    }

    /**
     * 执行 DDL语句
     *
     * @param sql
     * @return
     */
    public boolean getStatement(String sql) {
        boolean flag = false;
        try {
            this.connection = this.getConnection();
            this.statement = this.connection.createStatement();
            logger.debug("statement:" + statement);
            flag = this.statement.execute(sql);
            logger.debug("flag:" + flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * 自动生成表格
     * @param args
     */

    /**
     * 4.通过对象类自动生成表
     *
     * @param
     */
    public void creatTable(Class obj) {
        String sql = "";
//		Class obj = CategoryForm.class;
        // 4.1 获得表名字
        String tablename = obj.getSimpleName();
        tablename = tablename.toLowerCase().substring(0, tablename.length() - 4);
        logger.debug("tablename" + tablename);
        sql += "CREATE TABLE tab_" + tablename + "(";
        // 4.2 获得列名和类型
        Method methods[] = obj.getMethods();
        // 通过set方法给属性赋值 所以获得所有的set方法
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];// 获得每一个 方法
            String cloumnName = method.getName();
            if (cloumnName.startsWith("set")) {
                logger.debug("cloumnName:" + cloumnName);
                // 4.3获得参数的类型
                Parameter parameter = method.getParameters()[0];
                Class type = parameter.getType();
                String typeName = type.getName();
                logger.debug("属性typeName:" + typeName);
                typeName = zhuanhuan(typeName);
                logger.debug("列的类型typeName:" + typeName);
                // 4.4 获得名字
                cloumnName = cloumnName.toLowerCase().substring(3, cloumnName.length());
                logger.debug("列的类型cloumnName:" + cloumnName);
                // 4.5 拼接sql语句
                sql += cloumnName + "  " + typeName;
//				char index=tablename.charAt(0);
                if (cloumnName.equals("cid")) {
                    sql += " primary key auto_increment,";
                } else {
                    sql += ",";
                }
            }
        }
        sql = sql.trim().substring(0, sql.length() - 1);
        sql += " ); ";
        getStatement(sql);
    }

    private String zhuanhuan(String typeName) {
        if (typeName == null) {
            return null;
        }
        switch (typeName) {
            case "int":

                return "int(3)";
            case "java.lang.String":

                return "varchar(255)";

            default:
                return null;
        }

    }

    public static void main(String[] args) throws SQLException {
        String sql = "create table t13(id int primary key)";
        DBUtils dbUtils = new DBUtils();
        System.out.println(dbUtils.getConnection());
        new DBUtils().getStatement(sql);

    }

}
