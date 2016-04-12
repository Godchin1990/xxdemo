/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.modules;

import dagger.Module;
import io.github.zengzhihao.tngou.ui.HomeActivity;
import io.github.zengzhihao.tngou.ui.base.AbstractActivity;
import io.github.zengzhihao.tngou.ui.top.TopActivity;

/**
 * @author Kela.King
 */
@Module(injects = {AbstractActivity.class, HomeActivity.class, TopActivity.class}, complete =
        false, library = true)
public class UiModule {

}
