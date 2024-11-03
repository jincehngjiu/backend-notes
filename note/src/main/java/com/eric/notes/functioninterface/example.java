package com.eric.notes.functioninterface;

import com.alibaba.fastjson2.function.FieldConsumer;
import com.baomidou.mybatisplus.generator.function.ConverterFileName;
import com.google.common.collect.Maps;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * <p>
 * 示例
 * </p>
 *
 * @author Eric Jin
 * @since 11/2/24 PM2:29
 */
public class example {

    public example(){
        UnaryOperator<String> converterFileName = String::toLowerCase;
        BinaryOperator<BigInteger> bigIntegerBigIntegerBigIntegerEntryTransformer = BigInteger::add;
        Predicate<List> isEmpty = Collection::isEmpty;
        Function<Arrays,List<Arrays>> tFieldConsumer = Arrays::asList;

    }
}
