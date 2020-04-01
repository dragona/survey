package com.qin.imagezxlingdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import  android.support.v4.content.ContextCompat;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class TimeActivity extends AppCompatActivity {

    Intent intent;

    public static String time1;

    private TextView t1;
    private TextView t2;

    private LocationManager locationManager;
    private String provider;

    private Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        t1 = (TextView) findViewById(R.id.time);
        t2 = (TextView) findViewById(R.id.location);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b1.setOnClickListener(this::gettime);
        b2.setOnClickListener(this::getlocation);
        b3.setOnClickListener(this::next);

    }

   //定位按键响应
    //记得在AndroidManifest.xml文件里面添加定位权限
    //就是下面这两行
    //问题在于还是需要手动打开手机的位置定位，并且要手动添加该应用的定位权限
     /*   <!-- 两种provider的权限 -->
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <!-- 仅网络定位的权限 -->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

      */
    public void getlocation(View view)
    {
        //获取定位服务
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取当前可用的位置控制器

        List<String> list = locationManager.getProviders(true);

        if (list.contains(LocationManager.GPS_PROVIDER)) {
            //是否为GPS位置控制器
            provider = LocationManager.GPS_PROVIDER;
        } else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
            //是否为网络位置控制器
            provider = LocationManager.NETWORK_PROVIDER;

        } else {
            Toast.makeText(this, "请检查网络或GPS是否打开",
                    Toast.LENGTH_LONG).show();
            return;
        }


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {}

        Location location =locationManager.getLastKnownLocation(provider);
        if(location!=null)
        {
            String string = "纬度为：" + location.getLatitude() + ",经度为："
                    + location.getLongitude();
            t2.setText(string);
        }
        //绑定定位事件，监听位置是否改变
//第一个参数为控制器类型第二个参数为监听位置变化的时间间隔（单位：毫秒）
//第三个参数为位置变化的间隔（单位：米）第四个参数为位置监听器
        locationManager.requestLocationUpdates(provider, 2000, 2,
                locationListener);

    }



    LocationListener locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location arg0) {
                //更新当前纬度
            }

            @Override
            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

            }

            @Override
            public void onProviderEnabled(String arg0) {

            }

            @Override
            public void onProviderDisabled(String arg0) {

            }
        };

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(locationManager !=null)
        {
            locationManager.removeUpdates(locationListener);
        }
    }


        //时间日期按键响应
    public void gettime (View view)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        time1=simpleDateFormat.format(date);
        t1.setText(simpleDateFormat.format(date));
    }

    public void next (View view){

        Toast.makeText(this,"Thank you for your time",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TimeActivity.this,
                Report.class);
        startActivity(intent);
    }
}
