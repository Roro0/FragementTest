package edu.feucui.fragementtest;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OneActivity extends Fragment {
    /**
     * 给Fragement加载界面
     *
     * @param inflater  布局填充器，加载xml，Framnent的布局
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_file_manager,container,false);
        return view;
    }
    /**
     * s1:先拿到FragemetManager , getSupportFragmentManager
     * s2:开启一项事物beginTransaction
     * s3:操作事物：法1：添加 替换  移除 -----法2：show()和hide()配合使用
     * s4:提交事物：committ(必须提交，否则不生效)
     *      注意：同一事物只能添加一次
     *      切换两个Fragement：直接切换,replace
     *                     show和hide配合使用
     */
}
