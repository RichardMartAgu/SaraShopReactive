package com.svalero.SaraShopReactive.service;

import com.svalero.SaraShopReactive.model.AllProducts;
import com.svalero.SaraShopReactive.model.Product;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface SaraStoreAPI {

    @GET("/products")
    Observable <List<Product>> getAllProducts();

}
