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
    public static void fadeIn(Object object) {
        fadeIn(object, 400);
    }

    /**
     * 淡入
     */
    public static void fadeIn(Object object, long duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "alpha", 0f, 1f);
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 淡出
     */
    public static void fadeOut(Object object) {
        fadeOut(object, 400);
    }

    /**
     * 淡出
     */
    public static void fadeOut(Object object, long duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(object, "alpha", 1f, 0f);
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 首页触摸动画组合 触摸
     *
     * @param duration
     */
    public static void touchAnimDown(Object object, long duration) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(object, "scaleX", 1f, 0.8f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(object, "scaleY", 1f, 0.8f);
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(object, "rotation", 0f, 10f);
        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(scaleX).with(scaleY).with(rotation);
        animSet.play(scaleX).with(scaleY);
        animSet.setDuration(duration);
        animSet.start();
    }

    /**
     * 首页触摸动画组合 抬起
     *
     * @param duration
     */
    public static void touchAnimUp(Object object, long duration) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(object, "scaleX", 0.8f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(object, "scaleY", 0.8f, 1f);
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(object, "rotation", 10f, 0f);
        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(scaleX).with(scaleY).with(rotation);
        animSet.play(scaleX).with(scaleY);
        animSet.setDuration(duration);
        animSet.start();
    }

    /**
     * 首页触摸动画组合 抖动
     *
     * @param duration
     */
    public static void touchAnimShake(Object object, long duration) {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(object, "translationX", 0f, 3f, 0f);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(object, "translationY", 0f, 3f, 0f);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(object, "rotation", 0f, 3f, 0f);
        translationX.setRepeatCount(3);
        translationY.setRepeatCount(3);
        rotation.setRepeatCount(3);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(translationX).with(translationY).with(rotation);
        animSet.setDuration(duration);
        animSet.start();
    }

    /**
     * 号码归属进入动画
     *
     * @param duration
     */
    public static void phoneInfoEnterAnim(Object object, long duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(object, "translationY", 720f, 0f);
        objectAnimator.setDuration(duration);
        objectAnimator.start();
    }

}
