package com.prathanbomb.androidutilcode.core.image;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.ImageUtils;
import com.prathanbomb.framework.util.SizeUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/09/26
 *     desc  : Image工具类Demo
 * </pre>
 */
public class ImageActivity extends BaseBackActivity {

    private ImageView ivSrc;
    private ImageView ivView2Bitmap;

    public static void start(Context context) {
        Intent starter = new Intent(context, ImageActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_image;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_image));

        ivSrc = (ImageView) findViewById(R.id.iv_src);
        ivView2Bitmap = (ImageView) findViewById(R.id.iv_view2Bitmap);
        ImageView ivRound = (ImageView) findViewById(R.id.iv_round);
        ImageView ivRoundCorner = (ImageView) findViewById(R.id.iv_round_corner);
        ImageView ivFastBlur = (ImageView) findViewById(R.id.iv_fast_blur);
        ImageView ivRenderScriptBlur = (ImageView) findViewById(R.id.iv_render_script_blur);
        ImageView ivStackBlur = (ImageView) findViewById(R.id.iv_stack_blur);
        ImageView ivAddFrame = (ImageView) findViewById(R.id.iv_add_frame);
        ImageView ivAddReflection = (ImageView) findViewById(R.id.iv_add_reflection);
        ImageView ivAddTextWatermark = (ImageView) findViewById(R.id.iv_add_text_watermark);
        ImageView ivAddImageWatermark = (ImageView) findViewById(R.id.iv_add_image_watermark);
        ImageView ivGray = (ImageView) findViewById(R.id.iv_gray);

        Bitmap src = ImageUtils.Companion.getBitmap(R.drawable.img_lena);
        Bitmap watermark = ImageUtils.Companion.getBitmap(R.mipmap.ic_launcher);

        SizeUtils.forceGetViewSize(ivSrc, new SizeUtils.onGetSizeListener() {
            @Override
            public void onGetSize(View view) {
                ivView2Bitmap.setImageBitmap(ImageUtils.Companion.view2Bitmap(ivSrc));
            }
        });
        ivRound.setImageBitmap(ImageUtils.Companion.toRound(src));
        ivRoundCorner.setImageBitmap(ImageUtils.Companion.toRoundCorner(src, 60));
        ivFastBlur.setImageBitmap(ImageUtils.Companion.fastBlur(src, 0.1f, 5));
        ivRenderScriptBlur.setImageBitmap(ImageUtils.Companion.renderScriptBlur(src, 10));
        src = ImageUtils.Companion.getBitmap(R.drawable.img_lena);
        ivStackBlur.setImageBitmap(ImageUtils.Companion.stackBlur(src, 10, false));
        ivAddFrame.setImageBitmap(ImageUtils.Companion.addFrame(src, 16, Color.GREEN));
        ivAddReflection.setImageBitmap(ImageUtils.Companion.addReflection(src, 80));
        ivAddTextWatermark.setImageBitmap(ImageUtils.Companion.addTextWatermark(src, "prathanbomb", 40, 0x8800ff00, 0, 0));
        ivAddImageWatermark.setImageBitmap(ImageUtils.Companion.addImageWatermark(src, watermark, 0, 0, 0x88));
        ivGray.setImageBitmap(ImageUtils.Companion.toGray(src));
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}