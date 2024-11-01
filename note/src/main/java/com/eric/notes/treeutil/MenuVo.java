package com.eric.notes.treeutil;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10191245
 */
@Data
public class MenuVo {

    private Long id;
    private Long pId;
    private String name;
    private Integer rank=0;
    private List<MenuVo> subMenus=new ArrayList<>();

    public MenuVo(Long id, Long pId) {
        this.id = id;
        this.pId = pId;
    }
}