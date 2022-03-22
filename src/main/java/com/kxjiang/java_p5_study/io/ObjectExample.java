package com.kxjiang.java_p5_study.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.*;

/**
 * @author kxjiang
 * @date 2022-03-21 21:56
 */
public class ObjectExample {
    public static void main(String[] args) {
        // 序列化
        User user = new User("kxjiang1",18);
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("E:/user"))){
            outputStream.writeObject(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 反序列化
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("E:/user"))){
            User readUser = (User) inputStream.readObject();
            System.out.println(readUser.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @author kxjiang
     * @date 2022-03-21 22:00
     */
    @Data
    @AllArgsConstructor
    static
    class User implements Serializable {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}


