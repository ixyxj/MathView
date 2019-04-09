# MathView
:boom: Android Math Expression



### Support

- KateX :https://github.com/KaTeX/KaTeX
- MathJax :https://github.com/mathjax/MathJax



### Usage

#### KateX

- xml

```xml
<com.ixyxj.widget.MathWebView
            android:id="@+id/mathview_one"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:text="When \\(a \\ne 0\\), there are two solutions to \\(ax^2 + bx + c = 0\\)
        and they are $$x = {-b \\pm \\sqrt{b^2-4ac} \\over 2a}.$$"
            app:engine="KateX"/>
```

- code

```kotlin
this.findViewById<MathWebView>(R.id.mathview_3).text = mathml
```
#### MathJax

Default first : TeX-AMS_HTML-full
eg: "When \$a \\ne 0$, there are two solutions to (ax^2 + bx + c = 0) and they are \$\$x = {-b \\pm \\sqrt{b^2-4ac} \\over 2a}.$$"

```java
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
```
 > more config type go to website: http://docs.mathjax.org/en/latest/start.html

### Show

![image](https://raw.githubusercontent.com/ixyxj/MathView/master/screen_shot.png)
