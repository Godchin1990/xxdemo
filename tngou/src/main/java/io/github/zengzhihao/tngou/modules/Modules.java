/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.modules;

import io.github.zengzhihao.tngou.Application;

/**
 * @author Kela.King
 */
public class Modules {

    private Modules() {

    }

    public static Object[] list(Application application) {
        return new Object[]{new AppModule(application)};
    }
}
