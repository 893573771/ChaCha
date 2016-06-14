package com.ghy.baseapp.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

/**
 * Created by HY on 2016/5/1.
 * 动画工具类
 */
public class AnimUtils {

    /**
     * 淡入
     */
    public static void fadeIn(Object object){
        fadeIn(object,400);
    }

    /**
     * 淡入
     */
    public static void fadeIn(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "alpha", 0f, 1f);
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 淡出
     */
    public static void fadeOut(Object object){
        fadeOut(object,400);
    }

    /**
     * 淡出
     */
    public static void fadeOut(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "alpha", 1f, 0f);
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 首页触摸动画组合 触摸
     * @param duration
     */
    public static void touchAnimDown(Object object,long duration){
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(object, "scaleX", 1f, 0.8f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(object, "scaleY", 1f, 0.8f);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(object, "rotation", 0f, 10f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(scaleX).with(scaleY).with(rotation);
        animSet.setDuration(duration);
        animSet.start();
    }

    /**
     * 首页触摸动画组合 抬起
     * @param duration
     */
    public static void touchAnimUp(Object object,long duration){
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(object, "scaleX", 0.8f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(object, "scaleY", 0.8f, 1f);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(object, "rotation", 10f, 0f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(scaleX).with(scaleY).with(rotation);
        animSet.setDuration(duration);
        animSet.start();
    }

}
