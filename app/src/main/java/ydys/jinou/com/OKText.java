package ydys.jinou.com;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKText {

   public void onText(){
       OkHttpClient client1 = new OkHttpClient();
       OkHttpClient client = new OkHttpClient.Builder().build();
       Request request = new Request.Builder()
               .get()
               .url("")
               .build();
       Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
   }

}
