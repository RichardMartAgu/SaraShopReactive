package com.svalero.SaraShopReactive.service;

import com.svalero.SaraShopReactive.model.Product;
import com.svalero.SaraShopReactive.model.Shop;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface SaraStoreAPI {

    @GET("/shops")
    Observable<List<Shop>> getAllShops();

}
