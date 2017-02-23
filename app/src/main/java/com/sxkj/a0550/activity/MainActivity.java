package com.sxkj.a0550.activity;

import android.os.Bundle;
import android.widget.Button;

import com.sxkj.a0550.R;
import com.sxkj.a0550.activity.base.BaseActivity;
import com.sxkj.a0550.bean.Person;
import com.sxkj.a0550.common.ConstantValue;
import com.sxkj.a0550.utils.Utils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.GetListener;

public class MainActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBmob();
//        addFirstData();
        findFirstData();
    }

    /**
     * 第一次查找数据
     */
    private void findFirstData() {
        //查找Person表里面id为6b6c11c537的数据
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject(this, "837a619632", new GetListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                Utils.showToast(person.getName(), getApplicationContext());
            }

            @Override
            public void onFailure(int i, String s) {

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
        p2.save(this);
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

    @OnClick(R.id.button)
    public void onClick() {
    }
}
