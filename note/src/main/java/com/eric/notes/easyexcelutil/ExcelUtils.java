package com.eric.notes.easyexcelutil;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.eric.notes.builder.Example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Jin
 */
public class ExcelUtils {

    public static <T> List<T> readExcel(InputStream inputStream, Class<T> clazz) {
        List<T> dataList = new ArrayList<>();

        EasyExcel.read(inputStream, clazz, new AnalysisEventListener<T>() {
            @Override
            public void invoke(T data, AnalysisContext context) {
                dataList.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 所有数据解析完成后做的事情
            }
        }).sheet().doRead();

        return dataList;
    }

    public static void main(String[] args) {
        Example build = Example.Builder.getInstance().build();
    }
}