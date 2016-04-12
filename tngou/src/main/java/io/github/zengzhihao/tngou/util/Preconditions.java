/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.util;

/**
 * @author Kela.King
 */
public class Preconditions {

    public static <T> T checkNotNull(T t) {
        if (t == null)
            throw new NullPointerException();
        return t;
    }

    public static <T> T checkNotNull(T t, Object value) {
        if (t == null)
            throw new NullPointerException(String.valueOf(value));
        return t;
    }
}
