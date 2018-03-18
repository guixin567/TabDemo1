package zx.zw.tabdemo1.tabUtil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import zx.zw.tabdemo1.R;

/**
 * Email: 4994766@qq.com
 * @author zxKueen on 2017-10-23 10:21.
 *  TabLayout和ViewPager关联的工具类
 */

public class TabUtil {
    /**
     * 关联TabLayout和ViewPager
     * @param tabLayout
     * @param viewPager
     * @param tabInfos 封装了TabInfo的集合
     * @param fragmentManager v4包下的
     * @param context 用于Fragment实例
     */
    public static void bind(TabLayout tabLayout, ViewPager viewPager, final List<ItemTab> tabInfos, final FragmentManager fragmentManager, final Context context){

        if (tabLayout == null||viewPager==null||tabInfos==null||fragmentManager==null||context==null) {
            return;
        }


        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                if(tabInfos.get(position).mFragmentClass==null){
                    throw new NullPointerException("FragmentClass is Null");
                }
                return  Fragment.instantiate(context,tabInfos.get(position).mFragmentClass.getName(),tabInfos.get(position).mBundle);
            }

            @Override
            public int getCount() {
                return tabInfos.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabInfos.get(position).mTitle;
            }
        });
        tabLayout.setupWithViewPager(viewPager);



        initTablayout(context,tabInfos,tabLayout);



    }

    private static void initTablayout(Context context,List<ItemTab> tabInfos,TabLayout tabLayout) {
        /**
         * 绑定视图
         */
        for (int i = 0; i < tabInfos.size(); i++) {
            ItemTab itemTab = tabInfos.get(i);
            View rootView = LayoutInflater.from(context).inflate(R.layout.item_main_tab, null);
            TextView tvTab = rootView.findViewById(R.id.tv_tab);
            ImageView ivTab = rootView.findViewById(R.id.iv_tab);
            tvTab.setText(tabInfos.get(i).mTitle);

            /**
             * tab图片设置
             */
            if(itemTab.mNormalImage!= ItemTab.DEFAULT_IMAGE_ID&&itemTab.mSelectImage!=ItemTab.DEFAULT_IMAGE_ID){
                ivTab.setVisibility(View.VISIBLE);
                Drawable selector = SelectorUtil.getSelector(context, tabInfos.get(i).mNormalImage, tabInfos.get(i).mSelectImage);
                ivTab.setImageDrawable(selector);
            }else if(itemTab.mNormalImage== ItemTab.DEFAULT_IMAGE_ID&&itemTab.mSelectImage!=ItemTab.DEFAULT_IMAGE_ID){
                ivTab.setVisibility(View.VISIBLE);
                ivTab.setImageDrawable(context.getResources().getDrawable(itemTab.mSelectImage));
            }else if(itemTab.mNormalImage!= ItemTab.DEFAULT_IMAGE_ID&&itemTab.mSelectImage==ItemTab.DEFAULT_IMAGE_ID){
                ivTab.setVisibility(View.VISIBLE);
                ivTab.setImageDrawable(context.getResources().getDrawable(itemTab.mNormalImage));
            }else {
                ivTab.setVisibility(View.GONE);
            }

            /**
             * 图片的默认颜色是#333333，选中文本颜色是FF2222
             */
            ColorStateList colorStateList = SelectorUtil.getColorSelector(context.getResources().getColor(tabInfos.get(i).mNormalTitleColor), context.getResources().getColor(tabInfos.get(i).mSelectTitleColor));
            tvTab.setTextColor(colorStateList);

            tabLayout.getTabAt(i).setCustomView(rootView);

        }
    }


}
