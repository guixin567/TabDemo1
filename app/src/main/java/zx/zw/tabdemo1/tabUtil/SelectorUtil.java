package zx.zw.tabdemo1.tabUtil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;

/**
 * @author zxKueen 2018/3/18 19:55
 *         email 4994766@qq.com
 *         代码生成图片选择器，颜色选择器
 */
public class SelectorUtil {
    /**
     * 获取图片选择器
     * @param context
     * @param normal
     * @param press
     * @return
     */
    public static Drawable getSelector(Context context,int normal, int press){
        Drawable normalDrawable = ContextCompat.getDrawable(context, normal);
        Drawable pressDrawable = ContextCompat.getDrawable(context, press);

        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_selected}, pressDrawable);//  状态  , 设置按下的图片
        drawable.addState(new int[]{}, normalDrawable);//默认状态,默认状态下的图片
        return drawable;
    }

    /**
     * 获取颜色选择器
     * @param normal
     * @param press
     * @return
     */
    public static ColorStateList getColorSelector(int normal, int press){
        int[][] states =  {{android.R.attr.state_selected}, {}}; //状
        int[] colors = {press,normal};
        ColorStateList drawable = new ColorStateList(states,colors);
        return drawable;
    }
}
