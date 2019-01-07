package com.example.enghatoun.aqwas.Main.First;

import android.support.v4.app.FragmentActivity;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;


public interface FirstFragmentMVP {

    interface View{
        void setFragment(FirstFragment fragment);
        void displayData(Resturant resturant);
        void hideProgressDialog();
        void showProgressDialog();
        void initProgressDialog();

        FragmentActivity getAppActivity();
    }

    interface Presenter{

        void getMainFragment();
        void getLastLocation();
        void loadData(String str);
        void setView(FirstFragmentMVP.View view);

    }

    interface Model{
        io.reactivex.Observable<Resturant> getResturantFromNetwok(String str);

    }
}
