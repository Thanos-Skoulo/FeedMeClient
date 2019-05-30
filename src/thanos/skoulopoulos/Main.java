package thanos.skoulopoulos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner =  new Scanner(System.in);
        StoresService storesService = new StoresService();

        storesService.getStoresAsync(new Callback<ArrayList<Store>>() {
            @Override
            public void onResponse(Call<ArrayList<Store>> call, Response<ArrayList<Store>> response) {
                for(Store store: response.body()){
                    System.out.println(store.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Store>> call, Throwable throwable) {

            }
        });

        System.out.println("insert new id");
        int newId = scanner.nextInt();
        System.out.println("insert name");
        String newName = scanner.next();
        System.out.println("insert address");
        String newAddress = scanner.next();
        System.out.println("insert website");
        String newWebsite = scanner.next();

        Store store = new Store(newId,newName,newAddress,newWebsite);
        storesService.createStore(store);






    }
}
