package com.yunds.xiaodisdk4demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bluetoothle.core.BLELoader;
import com.dsm.xiaodisdk4.base.Xiaodi4ApiRequestFactory;
import com.dsm.xiaodisdk4.base.XiaodiBleFactory;
import com.dsm.xiaodisdk4.blecore.xiaodilock.receiver.XIAODIBLEDataReceivedAnalyzer;
import com.dsm.xiaodisdk4.listener.OnAddDeviceListener;
import com.dsm.xiaodisdk4.listener.OnOpenListener;
import com.dsm.xiaodisdk4.listener.OnResponseListener;
import com.dsm.xiaodisdk4.listener.OnXIAODIBLECollectFingerListener;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BLELoader.init();
        /*demoCall();*/
    }

    private void demoCall() {
        Xiaodi4ApiRequestFactory.Companion.getInstance().getRegisterLockRequest("", "", false, new OnAddDeviceListener() {
            @Override
            public void addSuccess(@Nullable String lockMac, @Nullable String rootKey, @Nullable String lockSn, @Nullable String lockChannelPassword, @Nullable String lockSoftwareVersion, @Nullable String lockSeid) {

            }

            @Override
            public void addFailure(@Nullable Integer errCode) {

            }
        }).request();
        Xiaodi4ApiRequestFactory.Companion.getInstance().getOpenLockRequest("", "", "", false, "", new OnOpenListener() {
            @Override
            public void openSuccess(@NotNull Object obj) {

            }

            @Override
            public void openFail(int errorCode) {

            }
        }).request();
        XiaodiBleFactory.Companion.getInstance().timeSync_0x23("", new OnResponseListener() {
            @Override
            public void onSuccess(@Nullable Object obj) {

            }

            @Override
            public void onFail(int errorCode) {

            }
        });
        XiaodiBleFactory.Companion.getInstance().inputFinger_0x24("", new OnXIAODIBLECollectFingerListener() {
            @Override
            public void onCollectFailure(@NotNull String errorMsg, int loglevel) {

            }

            @Override
            public void onTemplateCollectSuccess(long fingerCollectionCcount, @NotNull XIAODIBLEDataReceivedAnalyzer XIAODIBLEDataReceivedAnalyzer) {

            }

            @Override
            public void onCollectSuccess(@NotNull String generatedFingerID, long fingerCollectionCount, @NotNull XIAODIBLEDataReceivedAnalyzer XIAODIBLEDataReceivedAnalyzer) {

            }
        });
    }
}
