package com.prathanbomb.androidutilcode.core.toast;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.framework.util.ToastUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2017/08/31
 *     desc  :
 * </pre>
 */
public class MyToast {

    public static void showMyToast(@NonNull final String message){
        View toastView = ToastUtils.showCustomLongSafe(R.layout.toast_custom);
        TextView tvMessage = (TextView) toastView.findViewById(R.id.tv_toast_message);
        tvMessage.setText(message);
    }

}
