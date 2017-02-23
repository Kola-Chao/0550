package com.sxkj.a0550.apitest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.sxkj.a0550.R;
import com.tang.demo.mmsjapi.http.HttpManager;
import com.tang.demo.mmsjapi.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        simpleDao();
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
            super.onCacheNext(string);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }
    };
}
