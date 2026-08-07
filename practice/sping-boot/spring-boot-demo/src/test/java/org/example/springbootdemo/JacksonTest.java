package org.example.springbootdemo;

import tools.jackson.databind.ObjectMapper;

public class JacksonTest {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.setId(11);
        person.setAge(22);
        person.setName("咕咕嘎嘎");
        person.setAddress("127.0.0.1");

        //对象转换为JSON字符串
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

        //JSON字符串转换为对象
        String json1 = "{\"id\":11,\"name\":\"咕咕嘎嘎\",\"age\":22,\"address\":\"127.0.0.1\"}";
        Person person1 = objectMapper.readValue(json1, Person.class);
        System.out.println(person1);
    }

}
