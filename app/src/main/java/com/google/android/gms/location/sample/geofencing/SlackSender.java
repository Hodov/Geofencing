package com.google.android.gms.location.sample.geofencing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by skorokhodov_a on 26.02.2016.
 */
public class SlackSender {

    public void sendText(String message) {

        String url = "https://hooks.slack.com/services/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";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, "{\"text\": \""+message+"\"}");

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();


        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Не удалось отправить запрос");
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response);
                System.out.println(response.body().string());
            }
        });

    }


}
