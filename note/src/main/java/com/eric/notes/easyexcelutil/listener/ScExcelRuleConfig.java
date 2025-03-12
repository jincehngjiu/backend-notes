package com.eric.notes.easyexcelutil.listener;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 * 差异管理规则配置类
 * </p>
 *
 * @author Eric Jin
 * @since 2025/2/19 20:22
 */
@Data
@Slf4j
public class ScExcelRuleConfig implements Function<ScExcelRuleConfig,ScRuleConfig> {

    @ExcelProperty(index = 0,value = "request_method")
    private String requestMethod;

    @ExcelProperty(index = 3,value = "error_msg")
    private String errorMsg;

    @ExcelProperty(index = 4,value = "rule_code")
    private String ruleCode;

    @ExcelProperty(index = 13,value = "diff_check_point")
    private String diffCheckPoint;

    @ExcelProperty(index = 14,value = "diff_rule")
    private String diffRule;

    @ExcelProperty(index = 15,value = "diff_rule_desc")
    private String diffRuleDesc;

    @ExcelProperty(index = 10,value = "diff_type")
    private String diffType;

    @ExcelProperty(index = 11,value = "diff_sub_type")
    private String diffSubType;

    @ExcelProperty(index = 16,value = "diff_form")
    private String diffForm;

    @ExcelProperty(index = 17,value = "diff_source")
    private String diffSource;

    @ExcelProperty(index = 18,value = "diff_desc")
    private String diffDesc;

    @ExcelProperty(index = 19,value = "diff_object")
    private String diffObject;

    @Override
    public ScRuleConfig apply(ScExcelRuleConfig source) {
        if (source == null) {
            log.info("source is null");
            return ScRuleConfig.DEFAULT_VALUE;
        }

        ScRuleConfig.ScRuleConfigBuilder builder = ScRuleConfig.builder();
        builder.filter(RuleConfigConstant.RULE_CONFIG_FILTER_NAME.replace("${error_msg}",source.getErrorMsg()));
        builder.ruleName(source.getErrorMsg());
        builder.ruleCode(source.getRuleCode());
        builder.extFields(ScRuleConfig.FieldMapping.DEFAULT_EXT_FIELDS);
        List<ScRuleConfig.FieldMapping> fields = Arrays.asList(
                ScRuleConfig.FieldMapping.builder().name("request_serial").code("request_serial").build(),
                ScRuleConfig.FieldMapping.builder().name("request_method").code("request_method").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_check_point").code("'" + source.getDiffCheckPoint() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_rule").code("'" + source.getDiffRule() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_rule_desc").code("'" + source.getDiffRuleDesc() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_type").code("'" + source.getDiffType() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_sub_type").code("'" + source.getDiffSubType() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_form").code("'" + source.getDiffForm() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_source").code("'" + source.getDiffSource() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_check_time").code("LocalDateTime.now()").build(),
                ScRuleConfig.FieldMapping.builder().name("expect_qty").code("request_number").build(),
                ScRuleConfig.FieldMapping.builder().name("actual_qty").code("''").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_desc").code("'" + source.getDiffDesc() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_object").code("'" + source.getDiffObject() + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("storage_type").code("''").build(),
                ScRuleConfig.FieldMapping.builder().name("site").code("'" + RuleConfigConstant.SITE + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("info_context").code("original_req").build(),
                ScRuleConfig.FieldMapping.builder().name("diff_state").code("'" + RuleConfigConstant.DIFF_STATE + "'").build(),
                ScRuleConfig.FieldMapping.builder().name("biz_strategy").code("'" + RuleConfigConstant.BIZ_STRATEGY + "'").build()
        );
        builder.fields(fields);
        return builder.build();
    }
}
