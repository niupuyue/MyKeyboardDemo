package com.paulniu.mykeyboarddemo;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 18:20
 * Desc:
 * Version:
 */
public class EmojiModel {

    private String name;

    private int id;

    public EmojiModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
