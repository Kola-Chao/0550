package com.sxkj.a0550.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.sxkj.a0550.R;
import com.sxkj.a0550.activity.base.BaseActivity;
import com.sxkj.a0550.bean.Person;
import com.sxkj.a0550.common.ConstantValue;
import com.sxkj.a0550.fragment.FavoriteFragment;
import com.sxkj.a0550.fragment.MineHomeFragment;
import com.sxkj.a0550.utils.Utils;
import com.sxkj.a0550.vp.ParallaxPageTransformer;
import com.sxkj.a0550.vp.adapter.MineFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.main_bb)
    BottomBar mainBb;


    private ViewPager.PageTransformer transformer;
    private MineFragmentPagerAdapter adapter;
    private ArrayList<Fragment> framents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBmob();
//        addFirstData();
        findFirstData();

        initVP();
        setListener();
    }

    /**
     * 设置监听器
     */
    private void setListener() {
        mainBb.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_favorites:
                        mainVp.setCurrentItem(0);
                        break;
                    case R.id.tab_nearby:
                        Utils.showToast("nearby");
                        break;
                    case R.id.tab_friends:
                        mainVp.setCurrentItem(2);
                        break;
                    default:
                        break;
                }

            }
        });
    }

    @Override
    public void initLayout() {
        setContentView(R.layout.activity_main);
    }

    /**
     * 初始化ViewPager数据
     */
    private void initVP() {
        framents = new ArrayList<>();
        framents.add(new FavoriteFragment());
        framents.add(new FavoriteFragment());
        framents.add(new MineHomeFragment());
        adapter = new MineFragmentPagerAdapter(getSupportFragmentManager(), framents);
        transformer = new ParallaxPageTransformer();
        mainVp.setPageTransformer(true, transformer);
        mainVp.setAdapter(adapter);
        mainVp.setCurrentItem(0);

    }

    /**
     * 第一次查找数据
     */
    private void findFirstData() {
        //查找Person表里面id为6b6c11c537的数据
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject("837a619632", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {

            }
        });
        bmobQuery.addWhereEqualTo("name", "asd");
    }

    /**
     * 初始化BMOB数据库
     */
    private void initBmob() {
        //        //第一：默认初始化
//        Bmob.initialize(this, ConstantValue.BMOBID);

//        第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config = new BmobConfig.Builder(this)
                //设置appkey
                .setApplicationId(ConstantValue.BMOBID)
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(30)
                //文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024 * 1024)
                //文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);
    }

    /**
     * 第一次向BMOB添加数据
     * 执行后会自动在后台添加表
     */
    private void addFirstData() {
        Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
//        p2.save(this, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT);
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
//            }
//        });
    }
}
