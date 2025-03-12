package com.eric.notes.easyexcelutil.listener;

import com.alibaba.excel.context.AnalysisContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 *
 * </p>
 *
 * @author Eric Jin
 * @since 2025/3/12 14:15
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class DiffRuleConfigFilterListener<T extends Function<T,S>,S> implements BaseFilterListener<T,S>{

    private final List<T> dataList = new ArrayList<>();

    private final List<S> restList = new ArrayList<>();

    @Override
    public List<T> getDataList() {
        return dataList;
    }

    @Override
    public List<S> getResultList() {
        return restList;
    }

    @Override
    public boolean filter(T value) {
        return true;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (CollectionUtils.isEmpty(dataList)) {
            log.info("数据为空，跳过规则解析");
            return;
        }
        dataList.forEach(item -> {
            S result = item.apply(item);
            restList.add(result);
        });

        log.info("数据处理完成, 从 dataList 转换到 restList, 总条数：{}", restList.size());

        BaseFilterListener.super.doAfterAllAnalysed(context);
    }

    public static <T extends Function<T,S>,S> DiffRuleConfigFilterListener<T,S> of() {
        return new DiffRuleConfigFilterListener<>();
    }
}
