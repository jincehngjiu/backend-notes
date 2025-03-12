package com.eric.notes.easyexcelutil.listener;

import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 差异管理规则配置
 * </p>
 *
 * @author Eric Jin
 * @since 2025/3/12 14:48
 */
@Value
@Builder
public class ScRuleConfig {

    /**
     * 过滤条件
     */
    String filter;

    /**
     * 规则名称
     */
    String ruleName;

    /**
     * 规则编码
     */
    String ruleCode;

    /**
     * 字段
     */
    List<FieldMapping> fields;

    /**
     * 拓展字段
     */
    List<FieldMapping> extFields;

    /**
     * 默认值
     */
    public static final ScRuleConfig DEFAULT_VALUE = ScRuleConfig.builder().build();


    @Value
    @Builder
    public static class FieldMapping {

        /**
         * 规则key
         */
        String name;

        /**
         * 规则value
         */
        String code;

        public static List<FieldMapping> DEFAULT_EXT_FIELDS = Arrays.asList(FieldMapping.builder().name("bizOrderNo").code("order.bizOrderNo").build(),
                FieldMapping.builder().name("subBizOrderNo").code("order.subBizOrderNo").build(),
                FieldMapping.builder().name("orderType").code("order.orderType").build(),
                FieldMapping.builder().name("sku").code("order.sku").build(),
                FieldMapping.builder().name("skc").code("order.skc").build(),
                FieldMapping.builder().name("storageCode").code("order.warehouseCode").build()
        );

    }
}
