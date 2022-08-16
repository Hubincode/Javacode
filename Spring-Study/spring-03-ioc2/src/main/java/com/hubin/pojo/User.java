package com.hubin.pojo;

/***
 * @author hubin 20210709
 */
public class User {
    private String name;

    public User() {
        System.out.println(User.class.toString()+": "+"无参构造");
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name:"+name);
    }
}
