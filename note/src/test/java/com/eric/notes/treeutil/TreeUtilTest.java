package com.eric.notes.treeutil;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 2024/11/1 15:58
 */
@SpringBootTest
public class TreeUtilTest {

    @Test
    public void treeTest() {
        List<MenuVo> menuList = getMenuVos();
        // 合成树
        List<MenuVo> tree = TreeUtil.makeTree(menuList, x -> x.getPId() == -1L, (x, y) -> x.getId().equals(y.getPId()),
                MenuVo::setSubMenus);
        System.out.println(JSON.toJSONString(tree));

        //如查我们想按rank正序：
        List<MenuVo> zSortTree = TreeUtil.sort(tree, Comparator.comparing(MenuVo::getRank), MenuVo::getSubMenus);

        //如查我们想按rank倒序序：
        List<MenuVo> sSortTree = TreeUtil.sort(tree, (x, y) -> y.getRank().compareTo(x.getRank()), MenuVo::getSubMenus);

    }

    private static List<MenuVo> getMenuVos() {
        MenuVo menu0 = new MenuVo(0L, -1L);
        MenuVo menu1 = new MenuVo(1L, 0L);
        MenuVo menu2 = new MenuVo(2L, 0L);
        MenuVo menu3 = new MenuVo(3L, 1L);
        MenuVo menu4 = new MenuVo(4L, 1L);
        MenuVo menu5 = new MenuVo(5L, 2L);
        MenuVo menu6 = new MenuVo(6L, 2L);
        MenuVo menu7 = new MenuVo(7L, 3L);
        MenuVo menu8 = new MenuVo(8L, 3L);
        MenuVo menu9 = new MenuVo(9L, 4L);
        // 基本数据
        return Arrays.asList(menu0, menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9);
    }
}
