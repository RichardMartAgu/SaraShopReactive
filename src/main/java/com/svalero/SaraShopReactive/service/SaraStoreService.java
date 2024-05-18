package com.svalero.SaraShopReactive.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svalero.SaraShopReactive.model.AllProducts;
import com.svalero.SaraShopReactive.model.Product;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class SaraStoreService {
    private String BASE_URL = "http://localhost:8080";
    private SaraStoreAPI saraStoreAPI;

    public SaraStoreService() {

        OkHttpClient client = new OkHttpClient.Builder().build();

        // Configuración de Gson para el análisis de JSON
        Gson gsonParser = new GsonBuilder()
                .setLenient()
                .create();

        // Configuración de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonParser))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        // Creación de una instancia de la interfaz SaraStoreAPI
        this.saraStoreAPI = retrofit.create(SaraStoreAPI.class);
    }

    // Método para obtener todos los productos
    public Observable<Product> getAllProducts() {
        // Realizar la solicitud a la API y mapear la respuesta
        return this.saraStoreAPI.getAllProducts()
                .map(AllProducts::getProducts)
                .flatMapIterable(products -> products);
    }
}
