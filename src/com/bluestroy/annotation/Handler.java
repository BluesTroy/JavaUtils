package com.bluestroy.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Troy on 2016/9/29.
 */

/**
 * 该小项目取自一个公司的持久层架构，用来代替Hibernate的解决方案，核心代码就是通过注解来实现的。
 */
public class Handler {

    private static String query(Object user){
        StringBuilder sb = new StringBuilder();
        //1.获取class
        Class c = user.getClass();
        //2.获取table名字
        boolean exits = c.isAnnotationPresent(Table.class);
        if (!exits) return null;
        Table t = (Table)c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        //3. 遍历所有的字段，看有没有值，有的话就加到条件里面
        Field[] fArray = c.getDeclaredFields();
        for (Field field: fArray) {
            //4.1拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) continue;
            String columnName = field.getAnnotation(Column.class).value();
            //4.2拿到字段值
            String fieldName = field.getName();
            String getMethdName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Object columnValue =null;
            try {
                Method getMethod = c.getMethod(getMethdName);
                columnValue = getMethod.invoke(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.3 拼装sql。 这里只处理了Integer和String类型。
            if (columnValue==null) continue;
            if (columnValue instanceof Integer){
                if ((Integer)columnValue==0) continue;
                sb.append(" and ").append(columnName).append("=").append(columnValue);
            }else if (columnValue instanceof String){
                if (((String)columnValue).contains(",")){
                    String[] values = ((String)columnValue).split(",");
                    sb.append(" and ").append(columnName).append(" in(");
                    for (String s: values){
                        sb.append("'").append(s).append("',");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                }else {
                    sb.append(" and ").append(columnName).append("='").append(columnValue).append("'");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        User u1 = new User();
        u1.setId(10);   //查询id为10的用户

        User u2 = new User();
        u2.setUserName("Troy"); //查询用户名为Troy的用户

        User u3 = new User();   //查询邮箱为其中任何一个的用户
        u3.setEmail("zhu@sina.com,yong@163.com,zhen@qq.com");
        u3.setAge(18);
        u3.setId(123);

        System.out.println(query(u1));
        System.out.println(query(u2));
        System.out.println(query(u3));

        Department d1 = new Department();
        d1.setName("技术部");
        d1.setAmount(60);
        System.out.println(query(d1));


    }

}
