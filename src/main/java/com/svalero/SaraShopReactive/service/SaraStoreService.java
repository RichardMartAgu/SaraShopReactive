package com.svalero.SaraShopReactive.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svalero.SaraShopReactive.model.AllProducts;
import com.svalero.SaraShopReactive.model.Product;
import com.svalero.SaraShopReactive.model.Shop;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class SaraStoreService {
    private String BASE_URL = "http://localhost:8080";
    private SaraStoreAPI saraStoreAPI;

    public SaraStoreService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        // Configuración de Gson para el análisis de JSON
        Gson gsonParser = new GsonBuilder()
                .setLenient()
                .create();

        // Configuración de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gsonParser))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        // Creación de una instancia de la interfaz SaraStoreAPI
        this.saraStoreAPI = retrofit.create(SaraStoreAPI.class);
    }

    // Método para obtener todos los productos
    public Observable<Shop> getAllShops() {
        System.out.println("Hola");
        // Realizar la solicitud a la API y mapear la respuesta
        return this.saraStoreAPI.getAllShops()
                .flatMapIterable(shops -> shops);
    }
}
