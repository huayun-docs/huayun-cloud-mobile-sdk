# TestChinacSDK

### 使用注意

1. 导入 ChinacSDK.jar
2. 在 Application 中初始化

```
    ChinacSDK.getInstance().initSDK(application);
```

### api 介绍

1.获取唯一id

```
ChinacSDK.getInstance().getId(new ChinacCB<CSystemInform>() {
            @Override
            public void callback(CSystemInform callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    String phoneid = callback.getPhoneId();
                } else {
                    String errorMsg = callback.getMsg();
                }
            }
        });
```

2.获取定位信息

```
ChinacSDK.getInstance().getLocation(new ChinacCB<CLocation>() {
            @Override
            public void callback(CLocation callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                            String lng = callback.getLongitude();
                            String lat = callback.getLatitude();
                            String mcc = callback.getMcc();
                            String mnc = callback.getMnc();
                            String lac = callback.getLac();
                            String cid = callback.getCid();
                } else {
                    String errorMsg = callback.getMsg();
                }
            }
        });
```

3.设置定位信息

```
ChinacSDK.getInstance().setLocation("longitude", "latitude", new ChinacCB<CBaseResponse>() {
            @Override
            public void callback(CBaseResponse callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    Toast.makeText(MainActivity.this,"设置定位成功",Toast.LENGTH_SHORT).show();
                } else {
                    String errorMsg = callback.getMsg();
                }
            }
        });
```

4.设置系统信息

```
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
                } else {
                    String errorMsg = callback.getMsg();
                }
            }
        });
```

5.设置是否ROOT

```
ChinacSDK.getInstance().setRoot(true, new ChinacCB<CBaseResponse>() {
            @Override
            public void callback(CBaseResponse callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    Toast.makeText(MainActivity.this,"设置ROOT成功",Toast.LENGTH_SHORT).show();
                } else {
                    String errorMsg = callback.getMsg();
                }
            }
        });
```

6.设置状态栏是否隐藏

```
ChinacSDK.getInstance().setStatusBar(true, new ChinacCB<CBaseResponse>() {
            @Override
            public void callback(CBaseResponse callback) {
                if (callback.getCode().equals(CResponseCode.SUCCESS)) {
                    Toast.makeText(MainActivity.this,"设置状态栏隐藏成功",Toast.LENGTH_SHORT).show();
                } else {
                    String errorMsg = callback.getMsg();
                }
            }
        });
```
