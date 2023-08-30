package com.baiyuechu.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * 对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）
 *
 * reduce的作用是把stream中的元素给组合起来，我们可以传入一个初始值，它会按照我们的计算方式依次拿流中的元素和初始化值进行计算，计算结果再和后面的元素计算。
 * 其中identity就是我们可以通过方法参数传入的初始值，accumulator的apply具体进行什么计算也是我们通过方法参数来确定的。
 *
 *
 * 惰性求值（如果没有终结操作，没有中间操作是不会得到执行的）
 * 流是一次性的（一旦一个流对象经过一个终结操作后。这个流就不能再被使用）
 * 不会影响原数据（我们在流中可以多数据做很多处理。但是正常情况下是不会影响原来集合中的元素的。这往往也是我们期望的）
 */
public class Task018_reduce {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        //        使用reduce求所有作者年龄的和
        Integer sum = authors
                .stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(sum);

        //        使用reduce求所有作者中年龄的最大值
        Integer max = authors
                .stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(max);
        //        使用reduce求所有作者中年龄的最小值
        Integer min = authors
                .stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return element < result ? element : result;
                    }
                });
        System.out.println(min);
        //        使用reduce求所有作者中年龄的最小值
        Optional<Integer> minOptional = authors
                .stream()
                .map(author -> author.getAge())
                .reduce((result, element) -> element < result ? element : result);
        System.out.println(minOptional.get());
    }
}
