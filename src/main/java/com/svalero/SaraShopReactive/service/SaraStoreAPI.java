package com.svalero.SaraShopReactive.service;

import com.svalero.SaraShopReactive.model.AllProducts;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SaraStoreAPI {

    @GET("/products")
    Observable<AllProducts> getAllProducts();

}
