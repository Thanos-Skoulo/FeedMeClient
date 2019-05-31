package thanos.skoulopoulos.stores;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import thanos.skoulopoulos.ApiResult;
import thanos.skoulopoulos.FeedMeApi;
import thanos.skoulopoulos.stores.Store;

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

    public void getStoresAsync(Callback<ArrayList<Store>> callback) {


        Call<ArrayList<Store>> toDosCallAsync = feedMeApi.getStores();

        toDosCallAsync.enqueue(callback);
    }

    public void createStore(Store store){

        feedMeApi.createStore(store).enqueue(new Callback<ApiResult<Store>>() {
            @Override
            public void onResponse(Call<ApiResult<Store>> call, Response<ApiResult<Store>> response) {

                ApiResult<Store> apiResult = response.body();

                if(apiResult != null) {
                    if (apiResult.isSuccess()) {
                        System.out.println("store with name: " + apiResult.getResult().getStoreName() + " created");
                    } else {
                        System.out.println(apiResult.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResult<Store>> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }

    public  void deleteStore(int id){

        feedMeApi.deleteStore(id).enqueue(new Callback<ApiResult<Integer>>() {
            @Override
            public void onResponse(Call<ApiResult<Integer>> call, Response<ApiResult<Integer>> response) {

                ApiResult<Integer> apiResult = response.body();
                if(apiResult!= null){
                    if(apiResult.isSuccess()){
                        System.out.println("store with id: " + apiResult.getResult().toString() + " deleted");
                    }else{
                        System.out.println(apiResult.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResult<Integer>> call, Throwable throwable) {

            }
        });
    }
}
