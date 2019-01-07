package com.example.enghatoun.aqwas.HTTP;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {
    @GET("GenerateFS.php")
    Observable<Resturant> getRestaurant(@Query("uid") String uid,
                                        @Query("get_param") String get_param);

}
