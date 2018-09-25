package com.demo.myapplication.viewfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.myapplication.R;

public class TextViewFragment extends Fragment {

    TextView textGradient;
    TextView textRainBow;
    TextView textBitmap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textview_content, container);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textGradient = view.findViewById(R.id.tv_gradient);
        textRainBow = view.findViewById(R.id.tv_rain_bow);
        textBitmap = view.findViewById(R.id.tv_bitmap);
        gradientTextView(textGradient);
        rainBowTextView(textRainBow);
        bitmapTextView(textBitmap);
        super.onViewCreated(view, savedInstanceState);
    }

    // 选择不同模式 主要指 平铺模式
    public void gradientTextView(TextView textView) {
        // 起点坐标和终点坐标，相对坐标？
        Shader shader = new LinearGradient(0, 0, 0, textView.getTextSize(), Color.RED, Color.BLUE,
                Shader.TileMode.CLAMP);
        // tileMode的类型和效果
        textView.getPaint().setShader(shader);
    }

    // 返回颜色资源
    private int[] getRainbowIdentify() {
        return getResources().getIntArray(R.array.rainbow);
    }

    // 彩虹色
    public void rainBowTextView(TextView textView) {
        int[] colors = getRainbowIdentify();
        Shader shader = new LinearGradient(0, 0, 0, textView.getTextSize(), colors, null, Shader.TileMode.MIRROR);
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        shader.setLocalMatrix(matrix);
        textView.getPaint().setShader(shader);
    }
    // 背景图片
    public void bitmapTextView(TextView textView) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.q11);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
    }

}
