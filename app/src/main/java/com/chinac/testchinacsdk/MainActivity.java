package com.chinac.testchinacsdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chinac.chinacsdk.ChinacSDK;
import com.chinac.chinacsdk.bean.CBaseResponse;
import com.chinac.chinacsdk.bean.CLocation;
import com.chinac.chinacsdk.bean.CResponseCode;
import com.chinac.chinacsdk.bean.CSystemInform;
import com.chinac.chinacsdk.callback.ChinacCB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvContent;
    private boolean isRoot = true;
    private boolean isHideStatusBar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvContent = (TextView)findViewById(R.id.tv_content);
        findViewById(R.id.btn_getId).setOnClickListener(this);
        findViewById(R.id.btn_getLocation).setOnClickListener(this);
        findViewById(R.id.btn_setLocation).setOnClickListener(this);
        findViewById(R.id.btn_setSystemInform).setOnClickListener(this);
        findViewById(R.id.btn_setRoot).setOnClickListener(this);
        findViewById(R.id.btn_setStatusBar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getId :
                getId();
                break;
            case R.id.btn_getLocation :
                getLocation();
                break;
            case R.id.btn_setLocation :
                setLocation();
                break;
            case R.id.btn_setSystemInform :
                setSystemInform();
                break;
            case R.id.btn_setRoot :
                setRoot();
                break;
            case R.id.btn_setStatusBar :
                setStatusBar();
                break;
        }
    }

    /**
     * 设置ROOT
     */
    private void setRoot() {
        ChinacSDK.getInstance().setRoot(isRoot, new ChinacCB<CBaseResponse>() {
            @Override
            public void callback(CBaseResponse callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    Toast.makeText(MainActivity.this,"设置ROOT成功",Toast.LENGTH_SHORT).show();
                    tvContent.setText(tvContent.getText() + "\n" + "设置ROOT成功");
                    isRoot = !isRoot;
                } else {
                    tvContent.setText(tvContent.getText() + "\n" + "设置ROOT失败：" + callback.getMsg());
                }
            }
        });
    }

    /**
     * 设置状态栏显示
     */
    private void setStatusBar() {
        ChinacSDK.getInstance().setStatusBar(isHideStatusBar, new ChinacCB<CBaseResponse>() {
            @Override
            public void callback(CBaseResponse callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    Toast.makeText(MainActivity.this,"设置状态栏成功",Toast.LENGTH_SHORT).show();
                    tvContent.setText(tvContent.getText() + "\n" + "设置状态栏成功");
                    isHideStatusBar = !isHideStatusBar;
                } else {
                    tvContent.setText(tvContent.getText() + "\n" + "设置状态栏失败：" + callback.getMsg());
                }
            }
        });
    }

    /**
     * 获取唯一id
     */
    private void getId() {
        ChinacSDK.getInstance().getId(new ChinacCB<CSystemInform>() {
            @Override
            public void callback(CSystemInform callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    tvContent.setText(tvContent.getText() + "\n" + callback.getPhoneId());
                } else {
                    tvContent.setText(tvContent.getText() + "\n" + callback.getMsg());
                }
            }
        });
    }

    /**
     * 获取定位信息
     */
    private void getLocation() {
        ChinacSDK.getInstance().getLocation(new ChinacCB<CLocation>() {
            @Override
            public void callback(CLocation callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    tvContent.setText(tvContent.getText()
                            + "\n" + "lng:" + callback.getLongitude()
                            + "\n" + "lat:" + callback.getLatitude()
                            + "\n" + "mcc:" + callback.getMcc()
                            + "\n" + "mnc:" + callback.getMnc()
                            + "\n" + "lac:" + callback.getLac()
                            + "\n" + "cid:" + callback.getCid());
                } else {
                    tvContent.setText(tvContent.getText() + "\n" + callback.getMsg());
                }
            }
        });
    }

    /**
     * 设置定位信息
     */
    private void setLocation() {
        ChinacSDK.getInstance().setLocation("117.999899", "24.504389", new ChinacCB<CBaseResponse>() {
            @Override
            public void callback(CBaseResponse callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    Toast.makeText(MainActivity.this,"设置定位成功",Toast.LENGTH_SHORT).show();
                    tvContent.setText(tvContent.getText() + "\n" + "设置定位成功");
                } else {
                    tvContent.setText(tvContent.getText() + "\n" + "设置定位失败：" + callback.getMsg());
                }
            }
        });
    }

    /**
     * 设置系统信息
     */
    private void setSystemInform() {
        CSystemInform systemInform = new CSystemInform();
        systemInform.setBrand("Xiaomi");
        systemInform.setModel("MI 5");
        systemInform.setIMEI("86451245215458");
        systemInform.setIMSI("460000058555214");
        systemInform.setICCID("708c56eb99999999");
        systemInform.setSerial("AA85452152451254");
        systemInform.setAndroid_id("898604705988888888888");
        systemInform.setWifiMac("77:88:66:77:88:33");
        systemInform.setWifiName("TP-LINK");
        systemInform.setPhoneNum("18542554585");
        ChinacSDK.getInstance().setSystemInform(systemInform, new ChinacCB<CBaseResponse>() {
                    @Override
                    public void callback(CBaseResponse callback) {
                        if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                            Toast.makeText(MainActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                            tvContent.setText(tvContent.getText() + "\n" + "修改成功");
                        } else {
                            tvContent.setText(tvContent.getText() + "\n" + "修改失败：" + callback.getMsg());
                        }
                    }
                });
    }


}