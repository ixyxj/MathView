# MathView
:boom: Android Math Expression



### Support

- KateX
- MathJax



### Usage

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

