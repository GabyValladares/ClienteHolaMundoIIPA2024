package com.ggvc.clienteholamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btRequest;
    TextView tvMessage,tvRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btRequest=findViewById(R.id.btnReq);
        tvMessage=findViewById(R.id.txtMensaje);
        tvRequest=findViewById(R.id.txtResp);
        btRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumiWS();
            }
        });

    }
    public void consumiWS()
    {



    }
}