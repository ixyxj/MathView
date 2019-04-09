package com.ixyxj.widget;

import android.util.SparseArray;

/**
 * For more information, you can visit https://github.com/ixyxj,
 * or contact me by xyxjun@gmail.com
 *
 * @author silen on 2019/4/9 22:47
 * Copyright (c) 2019 in FORETREE
 * MathJax config list
 */
public class MathJaxConfig {
    private static SparseArray<String> confArray = new SparseArray<>();
    private static SparseArray<String> typeArray = new SparseArray<>();

    static {
        typeArray.put(0, "TeX-AMS_HTML-full");
        confArray.put(0, "MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}});");
        typeArray.put(1, "MML_HTMLorMML-full");
        confArray.put(1, "");
        typeArray.put(2, "AM_HTMLorMML-full");
        confArray.put(2, "");
        typeArray.put(3, "TXT");
        confArray.put(3, "MathJax.Hub.Config({\n" +
                "    extensions: [\"tex2jax.js\"],\n" +
                "    jax: [\"input/TeX\",\"output/HTML-CSS\"],\n" +
                "    tex2jax: {inlineMath: [[\"$\",\"$\"],[\"\\\\(\",\"\\\\)\"]]}\n" +
                "  });");
    }

    /**
     * 自定义添加
     *
     * @param key
     * @param type
     * @param config
     */
    public static void put(int key, String type, String config) {
        if (typeArray == null) typeArray = new SparseArray<>();
        typeArray.put(key, type);
        if (confArray == null) confArray = new SparseArray<>();
        confArray.put(key, config);
    }

    /**
     * 获取配置
     *
     * @param key
     * @return
     */
    public static String getConf(int key) {
        return confArray.get(key);
    }

    public static String getType(int key) {
        return typeArray.get(key);
    }
}
