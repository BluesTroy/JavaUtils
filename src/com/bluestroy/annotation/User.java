package com.bluestroy.annotation;

/**
 * Created by Troy on 2016/9/29.
 */

/**
 * 使用注解来实现数据库的映射，替换hibernate，并打印出sql语句
 */
@Table("user")
public class User {

    @Column("id")
    private int  id;

    @Column("user_name")
    private String userName;

    @Column("age")
    private int age;

    @Column("nick_name")
    private String nickName;

    @Column("email")
    private String email;

    @Column("city")
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
