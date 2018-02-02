package com.pgzxc.sharesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.pgzxc.sharesample.utils.ShareUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_share_text)
    Button btnShareTxt;

    @BindView(R.id.btn_share_pic)
    Button btnSharePic;

    @BindView(R.id.btn_more_file)
    Button btnMoreFile;
    @BindView(R.id.btn_share_weixin)
    Button btnWeixin;
    @BindView(R.id.btn_share_QQ)
    Button btnQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setListener();
    }

    private void setListener() {
        btnShareTxt.setOnClickListener(view -> {
            ShareUtils.shareText(MainActivity.this);
        });
        btnSharePic.setOnClickListener(view -> {
            ShareUtils.sharePic(MainActivity.this);
        });
        btnMoreFile.setOnClickListener(view -> {
            ShareUtils.shareMoreFile(MainActivity.this);
        });
        btnWeixin.setOnClickListener(view -> {
            ShareUtils.shareWeixin(MainActivity.this);
        });
        btnQQ.setOnClickListener(view -> {
            ShareUtils.shareQQ(MainActivity.this);
        });
    }
}
