package com.github.obsessive.tests.laifeng_sdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.obsessive.tests.R;
import com.laifeng.sopcastsdk.configuration.CameraConfiguration;
import com.laifeng.sopcastsdk.configuration.VideoConfiguration;
import com.laifeng.sopcastsdk.ui.CameraLivingView;

public class laifengTest extends AppCompatActivity {
    private CameraLivingView mLFLiveView;
    public static final int DEFAULT_HEIGHT = 1280;
    public static final int DEFAULT_WIDTH = 720;
    public static final int DEFAULT_FPS = 15;
    public static final CameraConfiguration.Facing DEFAULT_FACING = CameraConfiguration.Facing.FRONT;
    public static final CameraConfiguration.Orientation DEFAULT_ORIENTATION = CameraConfiguration.Orientation.PORTRAIT;
    public static final CameraConfiguration.FocusMode DEFAULT_FOCUSMODE = CameraConfiguration.FocusMode.AUTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laifeng_test);
        initViews();
    }

    private void initViews() {
        mLFLiveView = (CameraLivingView) findViewById(R.id.liveView);
        CameraConfiguration.Builder cameraBuilder = new CameraConfiguration.Builder();
        cameraBuilder.setOrientation(CameraConfiguration.Orientation.LANDSCAPE)
                .setFacing(CameraConfiguration.Facing.BACK).setPreview(720, 1280)
                .setFps(24).setFocusMode(CameraConfiguration.FocusMode.TOUCH);
        CameraConfiguration cameraConfiguration = cameraBuilder.build();
        mLFLiveView.setCameraConfiguration(cameraConfiguration);


        //视频参数设置
        VideoConfiguration.Builder videoBuilder = new VideoConfiguration.Builder();
        videoBuilder.setSize(640, 360).setMime(DEFAULT_MIME)
                .setFps(15).setBps(300, 800).setIfi(2);
        mVideoConfiguration = videoBuilder.build();
        mLFLiveView.setVideoConfiguration(mVideoConfiguration);

    }
}
