package com.eric.notes.easyexcelutil.listener;

import com.alibaba.excel.read.listener.ReadListener;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Eric Jin
 * @since 2025/3/12 13:51
 */
public interface BaseFilterListener<T,S> extends ReadListener<T> {

    List<T> getDataList();

    List<S> getResultList();

    boolean filter(T value);

    @Override
    default void invoke(T data, com.alibaba.excel.context.AnalysisContext context) {
        if (filter(data)){
            getDataList().add(data);
        }
    }

    @Override
    default void doAfterAllAnalysed(com.alibaba.excel.context.AnalysisContext context) {
        System.out.println("数据解析完成，总条数：" + getDataList().size());
    }

}



