package com.ggvc.clienteholamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    Button btRequest;
    TextView tvMessage,tvRequest;
    String respuesta = "";

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
        String url = "https://10.10.33.184:3000/mensaje";
        OkHttpClient cliente = new OkHttpClient();
        Request get = new Request.Builder()
                .url(url)
                .build();
        cliente.newCall(get).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    ResponseBody responseBody = response.body();
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);

                    } else {

                        respuesta = responseBody.string();
                        Toast.makeText(MainActivity.this,"----------------------"+respuesta,Toast.LENGTH_LONG).show();

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    tvMessage.setText(respuesta);
                                    Toast.makeText(MainActivity.this,"----------------------"+respuesta,Toast.LENGTH_LONG).show();

                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        });
                    }
                    Log.i("data", responseBody.string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}