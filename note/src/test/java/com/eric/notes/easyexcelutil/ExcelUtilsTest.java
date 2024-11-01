package com.eric.notes.easyexcelutil;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 2024/11/1 14:11
 */
@SpringBootTest
public class ExcelUtilsTest {

    @Test
    public void readExcelTest() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("/Users/10191245/Downloads/【库存中心】常用数据字典(19).xlsx");
        List<ExcelItem> people = ExcelUtils.readExcel(inputStream, ExcelItem.class);
        System.out.println(StringUtils.join(people,",\n"));
    }
}
