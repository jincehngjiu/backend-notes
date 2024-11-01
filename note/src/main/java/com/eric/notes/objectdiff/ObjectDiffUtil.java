package com.eric.notes.objectdiff;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.lang.reflect.Field;

/**
 * @author Eric Jin
 */
public class ObjectDiffUtil {

    /**
     * 比较两个对象的属性值，并返回一个包含差异的 Map。
     *
     * @param oldObject 原始对象
     * @param newObject 新对象
     * @return 包含差异属性及其旧值和新值的 Map
     */
    public static Map<String, Map<String, Object>> compareObjects(Object oldObject, Object newObject) throws IllegalAccessException {
        if (!oldObject.getClass().equals(newObject.getClass())) {
            throw new IllegalArgumentException("Objects must be of the same type.");
        }

        Map<String, Map<String, Object>> differences = new HashMap<>();
        Class<?> clazz = oldObject.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // 设置为可访问私有字段
            field.setAccessible(true);
            Object oldValue = field.get(oldObject);
            Object newValue = field.get(newObject);

            if (!Objects.equals(oldValue, newValue)) {
                Map<String, Object> diff = new HashMap<>();
                diff.put("oldValue", oldValue);
                diff.put("newValue", newValue);
                differences.put(field.getName(), diff);
            }
        }

        return differences;
    }
}