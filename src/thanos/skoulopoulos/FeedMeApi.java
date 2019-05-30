package thanos.skoulopoulos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.ArrayList;

public interface FeedMeApi {

    @GET("stores")
    Call<ArrayList<Store>> getStores();

    @POST("stores/new")
    Call<Store> createStore(@Body Store store);
}
