/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Kela.King
 */
public class ToastHelper {

    private Context _context;

    public ToastHelper(Context context) {
        _context = context;
    }

    public void show(String message) {
        Toast.makeText(_context, message, Toast.LENGTH_SHORT).show();
    }
}
