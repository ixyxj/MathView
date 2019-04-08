package com.ixyxj.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import com.x5.template.providers.AndroidTemplates;

/**
 * For more information, you can visit https://github.com/ixyxj,
 * or contact me by xyxjun@gmail.com
 *
 * @author silen on 2019/4/8 23:31
 * Copyright (c) 2019 in FORETREE
 */
@SuppressLint("SetJavaScriptEnabled")
public class MathWebView extends WebView {
    private int mEngine;
    private CharSequence mText;

    public MathWebView(Context context) {
        this(context, null);
    }

    public MathWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MathWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUp(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MathWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUp(context, attrs, defStyleAttr);
    }

    /**
     * init widget
     */
    private void setUp(Context context, AttributeSet attrs, int defStyleAttr) {
        initWebSettings();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MathWebView, defStyleAttr, 0);
        try {
            setBackgroundColor(array.getColor(R.styleable.MathWebView_background, Color.TRANSPARENT));
            setEngine(array.getInteger(R.styleable.MathWebView_engine, Engine.KATEX));
            setText(array.getString(R.styleable.MathWebView_text));
        } finally {
            array.recycle();
        }
    }

    /**
     * get themes module
     *
     * @return
     */
    private Chunk getChunk() {
        String template = Template.KATEX;
        switch (mEngine) {
            case Engine.KATEX:
                break;
            case Engine.MATHJAX:
                template = Template.MATHJAX;
                break;
        }
        return new Theme(new AndroidTemplates(getContext())).makeChunk(template);
    }

    /**
     * set math text
     *
     * @param text math expression
     */
    public void setText(CharSequence text) {
        this.mText = text;
        Chunk chunk = getChunk();
        String TAG_FORMULA = "formula";
        String TAG_CONFIG = "config";
        chunk.set(TAG_FORMULA, mText);
        String mathJaxConfig = getMathJaxConfig();
        if (mathJaxConfig != null && !mathJaxConfig.isEmpty())
            chunk.set(TAG_CONFIG, mathJaxConfig);
        this.loadDataWithBaseURL(null, chunk.toString(), "text/html", "utf-8", "about:blank");
    }

    /**
     * Tweak the configuration of MathJax.
     * The `config` string is a call statement for MathJax.Hub.Config().
     * For example, to enable auto line breaking, you can call:
     * config.("MathJax.Hub.Config({
     * CommonHTML: { linebreaks: { automatic: true } },
     * "HTML-CSS": { linebreaks: { automatic: true } },
     * SVG: { linebreaks: { automatic: true } }
     * });");
     * <p>
     * This method should be call BEFORE setText() and AFTER setEngine().
     * PLEASE PAY ATTENTION THAT THIS METHOD IS FOR MATHJAX ONLY.
     */
    protected String getMathJaxConfig() {
        return "MathJax.Hub.Config({\n" +
                "  config: [\"MMLorHTML.js\"],\n" +
                "  jax: [\"input/TeX\",\"input/MathML\",\"input/AsciiMath\",\"output/HTML-CSS\",\"output/NativeMML\", \"output/PreviewHTML\"],\n" +
                "  extensions: [\"tex2jax.js\",\"mml2jax.js\",\"asciimath2jax.js\",\"MathMenu.js\",\"MathZoom.js\", \"fast-preview.js\", \"AssistiveMML.js\", \"a11y/accessibility-menu.js\"],\n" +
                "  TeX: {\n" +
                "    extensions: [\"AMSmath.js\",\"AMSsymbols.js\",\"noErrors.js\",\"noUndefined.js\"]\n" +
                "  }\n" +
                "});";
    }

    /**
     * set math view engine
     *
     * @param engine 0:kateX 1:MathJax
     */
    private void setEngine(int engine) {
        this.mEngine = engine;
    }

    /**
     * init web settings
     */
    protected void initWebSettings() {
        WebSettings ws = getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setCacheMode(WebSettings.LOAD_NO_CACHE);
    }

    public CharSequence getText() {
        return mText;
    }

    /**
     * type of engine
     */
    public interface Engine {
        int KATEX = 0;
        int MATHJAX = 1;
    }

    /**
     * html template
     */
    public interface Template {
        String KATEX = "katex";
        String MATHJAX = "mathjax";
    }
}
