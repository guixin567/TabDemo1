package zx.zw.tabdemo1.tabUtil;

import android.os.Bundle;

import zx.zw.tabdemo1.R;

/**
 * @author zxKueen 2018/3/18 16:08
 *         email 4994766@qq.com
 *         建造者模式设置Tablayout需要的参数
 *
 */
public class ItemTab {

    public static final int DEFAULT_IMAGE_ID = 0;
    /**
     * 标题设置
     */
    public String mTitle;
    /**
     * tab相应的Fragment字节码对象
     */
    public Class mFragmentClass;


    /**
     * 跳转需要参数
     */
    public Bundle mBundle;
    /**
     * 默认标题颜色
     */
    public int mNormalTitleColor = R.color.colorMainTabNormal;
    /**
     * 选中时标题颜色
     */
    public int mSelectTitleColor = R.color.colorMainTabSelect;
    /**
     * 默认的图片
     */
    public int mNormalImage = DEFAULT_IMAGE_ID;
    /**
     * 选中时的图片
     */
    public int mSelectImage = DEFAULT_IMAGE_ID;

    /**
     * 定义参数集
     */
  public static class Builder{
        public   ItemTab mItemTab;
        public Builder() {
            mItemTab = new ItemTab();
        }

        public Builder setFragmentClass(Class fragmentClass){
            mItemTab.mFragmentClass = fragmentClass;
            return this;
        }

        public Builder setBundle(Bundle bundle){
            mItemTab.mBundle = bundle;
            return this;
        }

        public Builder setNormalTitleColor(int normalTitleColor){
            mItemTab.mNormalTitleColor = normalTitleColor;
            return this;
        }
        public Builder setSelectTitleColor(int selectTitleColor){
            mItemTab.mSelectTitleColor = selectTitleColor;
            return this;
        }
        public Builder setNormalImage(int normalImage){
            mItemTab.mNormalImage = normalImage;
            return this;
        }

        public Builder setSelectImage(int selectImage){
            mItemTab.mSelectImage = selectImage;
            return this;
        }
        public Builder setTitle(String title){
            mItemTab.mTitle = title;
            return this;
        }

        public ItemTab build(){
            return mItemTab;
        }


    }
}

