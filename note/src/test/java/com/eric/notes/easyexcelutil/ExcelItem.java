package com.eric.notes.easyexcelutil;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelItem {

    @ExcelProperty(index = 1)
    private String functionCode;

    @ExcelProperty(index = 3)
    private String businessBigCategory;

    @ExcelProperty(index = 4)
    private String businessSubCategory;

    @ExcelProperty(index = 7)
    private String beforeStatus;

    @ExcelProperty(index = 8)
    private String afterStatus;

    @ExcelProperty(index = 11)
    private String isQc;

    @ExcelProperty(index = 12)
    private String decreasePhysicalWhInvType;

    @ExcelProperty(index = 13)
    private String increasePhysicalWhInvType;

    @ExcelProperty(index = 16)
    private String bizOrderNo;

    @ExcelProperty(index = 15)
    private String bizOrderType;

    @ExcelProperty(index = 18)
    private String taskNo;

    @ExcelProperty(index = 17)
    private String taskType;


}
