package thanos.skoulopoulos;

import retrofit2.Call;
import retrofit2.http.*;
import thanos.skoulopoulos.stores.Store;

import java.util.ArrayList;

public interface FeedMeApi {

    @GET("stores")
    Call<ArrayList<Store>> getStores();

    @POST("stores/new")
    Call<ApiResult<Store>> createStore(@Body Store store);

    @DELETE("stores/{id}")
    Call<ApiResult<Integer>> deleteStore(@Path ("id") int id);
}
