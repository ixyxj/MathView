package com.ixyxj.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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

    // mathjax config
    private CharSequence mConfigType;
    private CharSequence mConfig;

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
            setText(array.getString(R.styleable.MathWebView_text), array.getInteger(R.styleable.MathWebView_config_type, 0));
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
     * @param key
     */
    private void setText(CharSequence text, int key) {
        if (TextUtils.isEmpty(text)) return;
        this.mText = text;
        mConfig = MathJaxConfig.getConf(key);
        mConfigType = MathJaxConfig.getType(key);
        if (!TextUtils.isEmpty(mConfig) && !TextUtils.isEmpty(mConfigType)) loadDataFromChunk();
    }

    /**
     * API  set text
     *
     * @param text
     */
    public void setText(@NonNull CharSequence text) {
        mText = text;
        checkConfig();
        loadDataFromChunk();
    }

    /**
     * api set text
     *
     * @param text
     * @param type
     * @param config
     */
    public void setText(@NonNull CharSequence text, String type, String config) {
        mText = text;
        mConfigType = type;
        mConfig = config;
        checkConfig();
        loadDataFromChunk();
    }

    private void checkConfig() {
        if (TextUtils.isEmpty(mConfigType)) mConfigType = MathJaxConfig.getType(0);
        if (TextUtils.isEmpty(mConfig)) mConfig = MathJaxConfig.getConf(0);
    }

    /**
     * load template
     */
    private void loadDataFromChunk() {
        Chunk chunk = getChunk();
        chunk.set("formula", mText);
        chunk.set("config", mConfig);
        chunk.set("config_type", mConfigType);
        this.loadDataWithBaseURL(null, chunk.toString(), "text/html", "utf-8", "about:blank");
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
