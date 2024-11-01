package com.eric.notes.treeutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 去除泛型方法
 * </p>
 *
 * @author Eric Jin
 * @since 2024/11/1 16:11
 */
public class ReduceGenericTreeUtil {

    public static List<MenuVo> makeTree(List<MenuVo> allDate, Long rootParentId) {
        List<MenuVo> roots = new ArrayList<>();
        // 1、获取所有根节点
        for (MenuVo menu : allDate) {
            if (Objects.equals(rootParentId, menu.getPId())) {
                roots.add(menu);
            }
        }
        // 2、所有根节点设置子节点
        for (MenuVo root : roots) {
            makeChildren(root, allDate);
        }
        return roots;
    }

    public static MenuVo makeChildren(MenuVo root, List<MenuVo> allDate) {
        // 遍历所有数据，获取当前节点的子节点
        for (MenuVo menu : allDate) {
            if (Objects.equals(root.getId(), menu.getPId())) {
                makeChildren(menu, allDate);
                // 将是当前节点的子节点添加到当前节点的subMenus中
                root.getSubMenus().add(menu);
            }
        }
        return root;
    }
}
