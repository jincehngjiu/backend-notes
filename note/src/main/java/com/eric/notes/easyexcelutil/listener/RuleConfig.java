package com.eric.notes.easyexcelutil.listener;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>
 * 差异管理规则配置类
 * </p>
 *
 * @author Eric Jin
 * @since 2025/2/19 20:22
 */
@Data
public class RuleConfig {

    @ExcelProperty(index = 0,value = "request_method")
    private String requestMethod;

    @ExcelProperty(index = 3,value = "error_msg")
    private String errorMsg;

    @ExcelProperty(index = 12,value = "diff_check_point")
    private String diffCheckPoint;

    @ExcelProperty(index = 13,value = "diff_rule")
    private String diffRule;

    @ExcelProperty(index = 14,value = "diff_rule_desc")
    private String diffRuleDesc;

    @ExcelProperty(index = 9,value = "diff_type")
    private String diffType;

    @ExcelProperty(index = 10,value = "diff_sub_type")
    private String diffSubType;

    @ExcelProperty(index = 15,value = "diff_form")
    private String diffForm;

    @ExcelProperty(index = 16,value = "diff_source")
    private String diffSource;

    @ExcelProperty(index = 17,value = "diff_desc")
    private String diffDesc;

    @ExcelProperty(index = 18,value = "diff_object")
    private String diffObject;

}
