package edu.feucui.fragementtest;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * 碎片练习
 * Created by Administrator on 2016/9/28.
 */
public class MyActivity extends FragmentActivity implements AdapterView.OnItemClickListener {


    TextView t;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String[] str = new String[]{"添加","替换","移除"};
        mListView = (ListView) findViewById(R.id.lv_my_activity);
        mListView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,str));//第二个参数，自带的
        mListView.setOnItemClickListener(this);
        }


    OneActivity one= new OneActivity();
    TwoActivity two = new TwoActivity();
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
                FragmentManager mg0 = getSupportFragmentManager();
                FragmentTransaction fragmnetTra0 = mg0.beginTransaction();
              fragmnetTra0.add(R.id.ll_add,one);
                fragmnetTra0.add(R.id.ll_add,two);
                 fragmnetTra0.commit();
                break;
            case 1:
                FragmentManager mg1 = getSupportFragmentManager();
                FragmentTransaction fragmnetTra1 = mg1.beginTransaction();
                fragmnetTra1.hide(two);
                fragmnetTra1.show(one);
                fragmnetTra1.commit();
                break;
            case 2:
                FragmentManager mg2 = getSupportFragmentManager();
                FragmentTransaction fragmnetTra2 = mg2.beginTransaction();
                fragmnetTra2.hide(one);
                fragmnetTra2.show(two);
                fragmnetTra2.commit();
                break;
        }
    }
    /**
     * Fragement的生命周期
     *    onAttach----------当Activity和碎片相关联的时候执行   add
     *    onCreate----------fragement开始创建的时候
     *    onCreateView------创建Fragement的View的时候
     *    onActivityCreated-----当创建Fragement的Acticity
     */
}
