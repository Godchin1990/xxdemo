/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.core.library;

/**
 * @author Kela.King
 */
public interface Injector {

    <T> T inject(T t);
}
