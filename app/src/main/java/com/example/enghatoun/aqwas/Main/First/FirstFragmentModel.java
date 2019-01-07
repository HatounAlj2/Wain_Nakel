package com.example.enghatoun.aqwas.Main.First;


import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.example.enghatoun.aqwas.HTTP.ApiUtils;
import io.reactivex.Observable;


public class FirstFragmentModel implements FirstFragmentMVP.Model {

    public FirstFragmentModel() {}

    @Override
    public Observable<Resturant> getResturantFromNetwok(String string) {
      // RxJava
    return ApiUtils.getAPIService().getRestaurant(string,"value");
    }



}
