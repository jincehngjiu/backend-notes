package com.eric.notes.easyexcelutil.listener;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Eric Jin
 * @since 2025/3/12 14:15
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DefaultFilterListener<T,S> implements BaseFilterListener<T,S>{

    private final List<T> dataList = new ArrayList<>();

    @Override
    public List<T> getDataList() {
        return dataList;
    }

    @Override
    public List<S> getResultList() {
        return Collections.emptyList();
    }

    @Override
    public boolean filter(T value) {
        return true;
    }

    public static <T,S> DefaultFilterListener<T,S> of() {
        return new DefaultFilterListener<>();
    }
}
