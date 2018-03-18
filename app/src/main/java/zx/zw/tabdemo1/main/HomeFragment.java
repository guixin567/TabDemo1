package zx.zw.tabdemo1.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zx.zw.tabdemo1.R;

/**
 * @author zxKueen 2018/3/17 0:43
 *         email 4994766@qq.com
 */
public class HomeFragment extends Fragment {

    private String mType;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mType = getArguments().getString("type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tv = rootView.findViewById(R.id.textView2);
        if("1".equals(mType)){
            tv.setText("首页");
        }else if("2".equals(mType)){
            tv.setText("分类");
        }else if("3".equals(mType)){
            tv.setText("资讯");
        }else if("4".equals(mType)){
            tv.setText("购物车");
        }else if("5".equals(mType)){
            tv.setText("我的");
        }

        return rootView;
    }
}