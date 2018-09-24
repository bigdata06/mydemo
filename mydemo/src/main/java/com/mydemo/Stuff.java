package com.mydemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stuff  {

    static Map<String, String> sampleMap= new HashMap<String,String>();


    public static void init() {
        sampleMap.put("one", "one");
        sampleMap.put("two", "two");
        sampleMap.put("three", "three");
        sampleMap.put("four", "four");
        sampleMap.put("five", "five");
        sampleMap.put("six", "six");
    }

    public void iterator(Map<String, String> map){
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey()+" :" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        init();
        for(Map.Entry<String,String> entry : sampleMap.entrySet()){
            System.out.println(entry.getKey()+ "->" +entry.getValue());

        }

        List<Map.Entry<String,String>> list =
        sampleMap.entrySet()
                .stream()
                .limit(2)
                .collect(Collectors.toList());


        System.out.println("seconde methode : "+list);

        System.out.println("trois methode : ");
        sampleMap.entrySet()
                .stream()
                .forEach(System.out::println);
    }

    static void lambdas(Map<String, String> map){
        map.forEach((key,value) ->System.out.println(key + ":"+ value));

    }

}
