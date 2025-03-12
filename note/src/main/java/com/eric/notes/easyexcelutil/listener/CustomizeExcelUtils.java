package com.eric.notes.easyexcelutil.listener;

import com.alibaba.excel.EasyExcel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author 10191245
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomizeExcelUtils {

    public static <T,S> List<S> readExcel(InputStream inputStream, Class<T> clazz, BaseFilterListener<T,S> baseFilterListener) {
        EasyExcel.read(inputStream, clazz, baseFilterListener).sheet().doRead();
        return baseFilterListener.getResultList();
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("/Users/10191245/Downloads/差异映射.xlsx"));
        List<ScRuleConfig> scExcelRuleConfigList = CustomizeExcelUtils.readExcel(inputStream, ScExcelRuleConfig.class, DiffRuleConfigFilterListener.of());
        System.out.println(scExcelRuleConfigList);
    }
}



