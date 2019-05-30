package thanos.skoulopoulos;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoresService {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Store> stores = null;


    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build();
    private FeedMeApi feedMeApi = retrofit.create(FeedMeApi.class);


    ArrayList<Store> getStores(){


        Call<ArrayList<Store>> storeResponceCall = feedMeApi.getStores();

        try {
            Response<ArrayList<Store>> response = storeResponceCall.execute();
            stores = response.body();
        }catch (IOException e){
            e.printStackTrace();
        }
        return stores;

    }

    void getStoresAsync( Callback<ArrayList<Store>> callback) {


        Call<ArrayList<Store>> toDosCallAsync = feedMeApi.getStores();

        toDosCallAsync.enqueue(callback);
    }

    void createStore(Store store){

        feedMeApi.createStore(store).enqueue(new Callback<Store>() {
            @Override
            public void onResponse(Call<Store> call, Response<Store> response) {
                System.out.println("store created");
            }

            @Override
            public void onFailure(Call<Store> call, Throwable throwable) {

            }
        });
    }
}
