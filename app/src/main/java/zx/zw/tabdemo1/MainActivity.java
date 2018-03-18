package zx.zw.tabdemo1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import zx.zw.tabdemo1.databinding.ActivityMainBinding;
import zx.zw.tabdemo1.main.HomeFragment;
import zx.zw.tabdemo1.tabUtil.ItemTab;
import zx.zw.tabdemo1.tabUtil.TabUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ArrayList<ItemTab>  mTabInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initTabLayout();
    }

    private void initTabLayout() {
        mTabInfos = new ArrayList<>();

        Bundle bundle1 = new Bundle();
        bundle1.putString("type","1");;
        mTabInfos.add(new ItemTab.Builder()
                .setTitle("首页")
                .setNormalImage(R.mipmap.home)
                .setSelectImage(R.mipmap.home_press)
                .setFragmentClass(HomeFragment.class)
                .setBundle(bundle1)
                .build()
        );

        Bundle bundle2 = new Bundle();
        bundle2.putString("type","2");;
        mTabInfos.add(new ItemTab.Builder()
                .setNormalImage(R.mipmap.fenlei)
                .setBundle(bundle2)
                .setSelectImage(R.mipmap.fenlei_press)
                .setTitle("分类")
                .setFragmentClass(HomeFragment.class)
                .build()
        );

        Bundle bundle3 = new Bundle();
        bundle3.putString("type","3");
        mTabInfos.add(new ItemTab.Builder()
                .setTitle("资讯")
                .setNormalImage(R.mipmap.news)
                .setSelectImage(R.mipmap.news_press)
                .setFragmentClass(HomeFragment.class)
                .setBundle(bundle3)
                .build()
        );

        Bundle bundle4 = new Bundle();
        bundle4.putString("type","4");
        mTabInfos.add(new ItemTab.Builder()
                .setTitle("购物车")
                .setNormalImage(R.mipmap.cart)
                .setSelectImage(R.mipmap.cart_press)
                .setFragmentClass(HomeFragment.class)
                .setBundle(bundle4)
                .build()
        );

        Bundle bundle5 = new Bundle();
        bundle5.putString("type","5");
        mTabInfos.add(new ItemTab.Builder()
                .setTitle("我的")
                .setNormalImage(R.mipmap.me)
                .setSelectImage(R.mipmap.me_press)
                .setFragmentClass(HomeFragment.class)
                .setBundle(bundle5)
                .build()
        );

        TabUtil.bind(mBinding.tabMain,mBinding.vpMain,mTabInfos,getSupportFragmentManager(),this);

    }
}
