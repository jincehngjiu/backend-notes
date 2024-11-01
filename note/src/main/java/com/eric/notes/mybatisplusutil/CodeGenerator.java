package com.eric.notes.mybatisplusutil;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    private static final String projectPath = "/Users/develop/codes/inventory-supply-center/inventory-supply-business/inventory-supply-app";
    private static final String outPutDir = projectPath + "/src/main/java";

    private static final String URL = "jdbc:mysql://10.122.4.28:3307/business_inventory_center_dev?useUnicode=true&characterEncoding=UTF-8&useSSL=false&zeroDateTimeBehavior=convertToNull&autoReconnect=true&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "lt_inventory_supply_dev_rw";
    private static final String PASSWORD = "cqkerhjfqo9u13r";
    private static final String[] boolFiled = ("is_del").split(",");

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("Eric Jin") // 设置作者// 开启 swagger 模式
                            .outputDir(outPutDir); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.demo.inventory.supply") // 设置父包名
                                .moduleName("mapper") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, outPutDir)) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("bic_order_operation_log,bic_wms_init_inventory") // 设置需要生成的表名
                                .addTablePrefix("bic_") // 设置过滤表前缀
                                .entityBuilder().naming(NamingStrategy.underline_to_camel) // 表名下划线转驼峰
                                .enableLombok() // 开启 Lombok
                                .mapperBuilder().enableBaseResultMap() 
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}