package com.example.webrtc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.vidyo.VidyoClient.Connector.Connector;
import com.vidyo.VidyoClient.Connector.ConnectorPkg;

public class MainActivity extends AppCompatActivity implements Connector.IConnect {

    private Connector vc;
    private FrameLayout videoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();
        videoFrame = findViewById(R.id.videoFrame);
    }

    public void Start(View v) {
        vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());
    }

    public void Connect(View v) {

        vc.connect("prod.vidyo.io",
                "cHJvdmlzaW9uAERlbW9Vc2VyQGEzYjY1OS52aWR5by5pbwA2Mzc4ODYxNDg1NQAAZmY2ZmU4ZmVkMjM4MDUzMzNiMzUzNTBlYTc0MzYxODM1ZmVkZDY4Yjk2OTM1Nzc5ZTIxMzUyNDJmYjhlMGM5NGY4MjAxMzAzNjBkZjU5MjIwOGE0NGI2MzdjYWY5OTYy",
                "DemoUser",
                "Psiconline",
                this);
    }

    public void Disconnect(View v) {
        vc.disconnect();
    }

    public void onSuccess() {}

    public void onFailure(Connector.ConnectorFailReason reason) {}

    public void onDisconnected(Connector.ConnectorDisconnectReason reason) {}
}