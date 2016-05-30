package com.ghy.baseapp.utils;

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
     * 缩放1.0-0.8 X
     */
    public static void scaleX1(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "scaleX", 1f, 0.8f);
        animator.setDuration(duration);
        animator.start();
    }
    /**
     * 缩放1.0-0.8 Y
     */
    public static void scaleY1(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "scaleY", 1f, 0.8f);
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 缩放0.8-1.0 X
     */
    public static void scaleX2(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "scaleX", 0.8f, 1f);
        animator.setDuration(duration);
        animator.start();
    }
    /**
     * 缩放0.8-1.0 Y
     */
    public static void scaleY2(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "scaleY", 0.8f, 1f);
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 旋转
     */
    public static void rotation1(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "rotation", 0f, 10f);
        animator.setDuration(duration);
        animator.start();
    }
    /**
     * 旋转
     */
    public static void rotation2(Object object,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "rotation", 10f, 0f);
        animator.setDuration(duration);
        animator.start();
    }
}
