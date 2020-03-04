package com.evil.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

import java.util.Arrays;
import java.util.List;

/**
 * @author qinhulin on 2020-03-04
 */
public class ObjectMapperSimple {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // POJO to JSON
        MyValue myValue=new MyValue();
        SubValue subValue1=new SubValue();
        subValue1.setValues(Arrays.asList("a","b"));
        SubValue subValue2=new SubValue();
        subValue2.setValues(Arrays.asList("1","2"));
        myValue.setName("Evan");
        myValue.setAge(32);
        myValue.setSubValue(Arrays.asList(subValue1,subValue2));

        System.out.println(mapper.writeValueAsString(myValue));

        //JSON to POJO
        MyValue value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);
        System.out.println("JSON to POJO: " + value);

        //Generic collections
        List values = mapper.readValue("[{\"name\":\"Bob\", \"age\":13},{\"name\":\"John\",\"age\":14}]",  new TypeReference<List<MyValue>>() { });
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
        System.out.println("POJO to JSONArray: " + mapper.writeValueAsString(values));



    }
}

class SubValue{
    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}

class MyValue {
    private String name;
    private int age;
    private List<SubValue> subValue;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<SubValue> getSubValue() {
        return subValue;
    }

    public void setSubValue(List<SubValue> subValue) {
        this.subValue = subValue;
    }
}

