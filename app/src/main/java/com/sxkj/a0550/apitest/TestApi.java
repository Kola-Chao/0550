package com.sxkj.a0550.apitest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sxkj.a0550.R;
import com.tang.demo.mmsjapi.bean.BaseResultEntity;
import com.tang.demo.mmsjapi.factory.DecodeConverterFactory;
import com.tang.demo.mmsjapi.http.HttpManager;
import com.tang.demo.mmsjapi.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Introduce: 网络请求的测试类
 * Author：mac
 * Date：2017/2/23
 * Time: 上午10:11
 */

public class TestApi extends RxAppCompatActivity {
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.resylt_txt)
    TextView resyltTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onClick() {
        test1();
//        simpleDao();
    }

    /**
     * 简单封装
     */
    private void simpleDao() {
        SubjectPostApi postEntity = new SubjectPostApi(simpleOnNestListener, this);
//        postEntity.set
        HttpManager manaer = HttpManager.getInstance();
        manaer.doHttpDeal(postEntity);
    }

    private void test1() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(DecodeConverterFactory.create())
                .baseUrl("http://www.izaodao.com/Api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpPostService service = retrofit.create(HttpPostService.class);
        service.getAllVideo(true);
    }

    HttpOnNextListener simpleOnNestListener = new HttpOnNextListener<List<SubjectResult>>() {

        @Override
        public void onNext(List<SubjectResult> subjectResults) {
            String result = "";
            for (SubjectResult s : subjectResults) {
                result += s.toString();
            }
            resyltTxt.setText(result);
        }

        @Override
        public void onCacheNext(String string) {
            Gson gson = new Gson();
            Type type = new TypeToken<BaseResultEntity<List<SubjectResult>>>() {
            }.getType();
            BaseResultEntity resultEntity = gson.fromJson(string, type);
            resyltTxt.setText("缓存返回" + resultEntity.getData().toString());
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }
    };
}
