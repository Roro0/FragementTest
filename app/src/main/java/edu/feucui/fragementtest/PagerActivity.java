package edu.feucui.fragementtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import edu.feucui.fragementtest.adapter.HomeAdapter;

/**
 * Created by Administrator on 2016/9/28.
 */
public class PagerActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    RadioGroup mRadioGroup;
    ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

          mViewPager = (ViewPager) findViewById(R.id.viewPager_content);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rb_01);
          mRadioGroup = (RadioGroup) findViewById(R.id.rg);


        //数据源
        ArrayList<Fragment> mList = new ArrayList<>();
        mList.add(new OneActivity());
        mList.add(new TwoActivity());
        mList.add(new ThreeActivity());
        //适配器
        HomeAdapter adapter = new HomeAdapter(getSupportFragmentManager(),mList);
        mViewPager.setAdapter(adapter);

mViewPager.addOnPageChangeListener(this);
mRadioGroup.setOnCheckedChangeListener(this);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    /**
     * 当前所选择的Page
     * 根据选择的page设置相对应的RadioButton的状态
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
      RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(position);
        radioButton.setChecked(true);
    }


    @Override
    public void onPageScrollStateChanged(int state) {


    }

    /**
     *  当RadioButton状态改变的时候, 给相对应的page也改变状态
  */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
      for (int i=0;i<group.getChildCount();i++){
          RadioButton radioButton = (RadioButton) group.getChildAt(i);//根据下标i获取对应的radionButton
          if (radioButton.getId()==checkedId){//如果RadioButton是选中的状态，改变对应的viewPager的状态
       mViewPager.setCurrentItem(i);
          }
      }
    }
}
