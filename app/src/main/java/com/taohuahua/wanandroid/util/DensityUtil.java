package com.taohuahua.wanandroid.util;

public class DensityUtil {
    /**
     * dp -> px
     *
     * @param dpValue dp数值
     * @return dp to  px
     */
    public static int dip2px(float dpValue) {
        final float scale = ContextUtil.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px -> dp
     *
     * @param pxValue px的数值
     * @return px to dp
     */
    public static int px2dip(float pxValue) {
        final float scale = ContextUtil.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);

    }

}
