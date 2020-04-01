package com.qin.imagezxlingdemo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.king.zxing.Intents;


import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/*AppCompatActivity implements EasyPermissions.PermissionCallbacks*/

public class MainActivity extends Activity implements View.OnClickListener, LocusPassWordView.OnCompleteListener  {

    private TextView mExplainTv;
    private Button mRepaintBtn;
    private Button mConfirmBtn;
    private LocusPassWordView mPwdView;

    private String firstPassword;
    public static String againPassword;

    private boolean isFirst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }


    private void initViews() {
        mExplainTv = (TextView) findViewById(R.id.tv_explain);
        mRepaintBtn = (Button) findViewById(R.id.btn_repaint);
        mConfirmBtn = (Button) findViewById(R.id.btn_confirm);
        mPwdView = (LocusPassWordView) findViewById(R.id.mPassWordView2);

        mRepaintBtn.setOnClickListener(this);
        mConfirmBtn.setOnClickListener(this);
        mPwdView.setOnCompleteListener(this);
        initChoose();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_repaint:
                repaint();
                break;
            case R.id.btn_confirm:
                confirm(againPassword);
                break;
        }
    }

    private void repaint() {
        mPwdView.clearPassword(0);
        initChoose();
    }

    private void confirm(String password) {
        Toast.makeText(MainActivity.this, "你设置的密码：" + againPassword,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,
                SActivity.class);
        intent.putExtra("password", password);
        startActivity(intent);
    }

    @Override
    public void onComplete(String password) {
        if (isFirst) {
            firstChoose(password);
        } else {
            secondChoose(password);
        }
    }

    @Override
    public void onPrompt(String prompt) {
        mExplainTv.setText(prompt);
    }

    private void initChoose() {
        isFirst = true;
        firstPassword = "";
        againPassword = "";
        mPwdView.setFirstPassword("");
        mRepaintBtn.setVisibility(View.GONE);
        mConfirmBtn.setVisibility(View.GONE);
    }

    private void firstChoose(String password) {
        isFirst = false;
        firstPassword = password;
        mPwdView.setFirstPassword(password);
        mPwdView.clearPassword(0);
        mRepaintBtn.setEnabled(true);
        mConfirmBtn.setEnabled(false);
        mRepaintBtn.setVisibility(View.VISIBLE);
        mConfirmBtn.setVisibility(View.VISIBLE);
    }

    private void secondChoose(String password) {
        isFirst = true;
        againPassword = password;
        mRepaintBtn.setEnabled(true);
        mConfirmBtn.setEnabled(true);
    }

}
