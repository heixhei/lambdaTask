package com.baiyuechu.extend;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;

/**
 * 基本数据类型优化
 * 我们之前用到的很多Stream的方法由于都使用了泛型。所以涉及到的参数和返回值都是引用数据类型。
 * 即使我们操作的是整数小数，但是实际用的都是他们的包装类。JDK5中引入的自动装箱和自动拆箱让我们在使用对应的包装类时就好像使用基本数据类型一样方便。但是你一定要知道装箱和拆箱肯定是要消耗时间的。虽然这个时间消耗很下。但是在大量的数据不断的重复装箱拆箱的时候，你就不能无视这个时间损耗了。
 * 所以为了让我们能够对这部分的时间消耗进行优化。Stream还提供了很多专门针对基本数据类型的方法。
 * 例如：mapToInt,mapToLong,mapToDouble,flatMapToInt,flatMapToDouble等。
 */
public class Extend_01 {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        //这一过程包括非常多的Integer转换为int和int转换为Integer
        authors
                .stream()
                .map(author -> author.getAge())
                .map(age ->age+10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);
        //mapToInt
        authors.stream()
                .mapToInt(author->author.getAge())
                .map(age->age+10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);
    }
}
