package com.baiyuechu.methodReference;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;
import java.util.stream.Stream;

/**
 * 引用类的实例方法
 * 类名::方法名
 *  如果我们在重写方法的时候，方法体中只有一行代码，并且这行代码是调用了第一个参数的成员方法，并且我们把要重写的抽象方法中剩余的所有的参数都按照顺序传入了这个成员方法中，这个时候我们就可以引用类的实例方法。
 */
public class MethodReference_03 {
    interface UseString{
        String use(String str,int start,int length);
    }

    public static String subAuthorName(String str, UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str,start,length);
    }
    public static void main(String[] args) {

        subAuthorName("白月初", new UseString() {
            @Override
            public String use(String str, int start, int length) {
                return str.substring(start,length);
            }
        });
        subAuthorName("白月初", String::substring);

    }
}
