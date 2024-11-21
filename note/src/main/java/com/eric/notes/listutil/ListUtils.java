package com.eric.notes.listutil;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 10191245
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListUtils {

    public static <T> List<T> safeSetToList(Set<T> set) {
        return set != null ? new ArrayList<>(set) : new ArrayList<>();
    }
}