package com.animator.hao.simpleanimatordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
    }
    /**
     * ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f );
     * 第一个参数：所要作用的目标控件
     * 第二个参数：所要操作该控件的属性值
     * 第三个参数：所要操作的属性的开始值
     * 第四个参数：所要操作属性的结束值
     */
    public void onClick(View view) {
        switch (view.getId()) {//透明度动画
            case R.id.animation_alpha:

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f , 1f);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            case R.id.animation_scale://缩放动画
                /**动画组合**/
                PropertyValuesHolder objectAnimatorScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f,1f);
                PropertyValuesHolder objectAnimatorScaleY = PropertyValuesHolder.ofFloat("scaleY",  1f, 1f);
                /**同时播放两个动画**/
                ObjectAnimator.ofPropertyValuesHolder(textView, objectAnimatorScaleX, objectAnimatorScaleY).setDuration(1000).start();

                break;
            case R.id.animation_rotate://旋转动画
                ObjectAnimator objectAnimatorScale = ObjectAnimator.ofFloat(textView, "rotation", -3600f, 3600f);
                objectAnimatorScale.setDuration(4000);
                objectAnimatorScale.start();
                break;
            case R.id.animation_translate://位移动画
                ObjectAnimator objectAnimatorTranslate = ObjectAnimator.ofFloat(textView, "translationX", 0f, -500f,500f,0f);
                objectAnimatorTranslate.setDuration(4000);
                objectAnimatorTranslate.start();
                break;
            case R.id.animation_group1:
                /**动画组合**/
                AnimatorSet animatorSetGroup1 = new AnimatorSet();
                ObjectAnimator objectAnimatoralpha = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f , 1f);
                ObjectAnimator objectAnimatorScaleY1 = ObjectAnimator.ofFloat(textView, "scaleY", 0f, 1f);
                ObjectAnimator objectAnimatorRotateX1 = ObjectAnimator.ofFloat(textView, "rotationX", 0f, 360f);
                ObjectAnimator objectAnimatorTranslated = ObjectAnimator.ofFloat(textView, "translationX", 0f, 500f);
                animatorSetGroup1.setDuration(5000);
                animatorSetGroup1.play(objectAnimatoralpha).with(objectAnimatorScaleY1)
                        .before(objectAnimatorRotateX1).before(objectAnimatorTranslated);
                animatorSetGroup1.start();
                break;
            case R.id.animation_group2://先播放旋转动画，完成后播放位移动画
                AnimatorSet animatorSetGroup2 = new AnimatorSet();
                ObjectAnimator objectAnimatorTranslate2 = ObjectAnimator.ofFloat(textView, "translationX", 0f, 500f);
                ObjectAnimator objectAnimatorRotateX2 = ObjectAnimator.ofFloat(textView, "rotationX", 0f, 360f);
                ObjectAnimator objectAnimatorRotateY2 = ObjectAnimator.ofFloat(textView, "rotationY", 0f, 360f);
                animatorSetGroup2.setDuration(2000);
                animatorSetGroup2.play(objectAnimatorTranslate2).after(objectAnimatorRotateX2)
                        .after(objectAnimatorRotateY2);
                animatorSetGroup2.start();
                break;
            case R.id.animation_group3://重复的透明度动画
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
                objectAnimator2.setDuration(500);
                objectAnimator2.setRepeatCount(3);
                objectAnimator2.start();
                break;
            case R.id.animation_group4://重复的位移动画
                ObjectAnimator objectAnimatorTranslate3 = ObjectAnimator.ofFloat(textView, "translationX", -50f, 50f);
                objectAnimatorTranslate3.setDuration(500);
                objectAnimatorTranslate3.setRepeatCount(3);
                objectAnimatorTranslate3.start();
                break;

        }
    }
}
