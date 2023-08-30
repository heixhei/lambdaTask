package com.baiyuechu.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MapStream {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 19);
        map.put("黑子", 17);
        map.put("日向翔阳", 16);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);
        Stream<Map.Entry<String, Integer>> stream = entries.stream();
    }
}
