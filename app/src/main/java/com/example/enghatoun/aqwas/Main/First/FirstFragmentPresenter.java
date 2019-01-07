package com.example.enghatoun.aqwas.Main.First;


import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import io.reactivex.disposables.Disposable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FirstFragmentPresenter implements FirstFragmentMVP.Presenter {
    private FirstFragmentMVP.View view;
    private FirstFragmentMVP.Model model;
    private FusedLocationProviderClient mfusedLocationClient;
    private double latitud,longitude;
    private Location mLastLocation;
    private Disposable subscription = null;
    SharedPreferences mPrefs;

    public FirstFragmentPresenter() {
        this.model = new FirstFragmentModel();
    }
    @Override
    public void getMainFragment() {

    }

    @Override
    public void loadData(String str) {

        // RxJava
        subscription = model.getResturantFromNetwok(str)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableObserver<Resturant>() {
                @Override
                public void onNext(Resturant resturant) {
                    if (view != null) {
                        view.displayData(resturant);
                    }
                }

                @Override
                protected void onStart() {
                    if (view != null) {
                        view.showProgressDialog();
                    }
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {
                    if (view != null) {
                        view.hideProgressDialog();
                    }
                }
            });

    }
    @Override
    public void setView(FirstFragmentMVP.View view) {
        this.view = view;
    }

    @Override
    public void getLastLocation()
    {
        mfusedLocationClient = LocationServices.getFusedLocationProviderClient(view.getAppActivity());

        if (ActivityCompat.checkSelfPermission(view.getAppActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(view.getAppActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        } else {
            mfusedLocationClient.getLastLocation().addOnCompleteListener(view.getAppActivity(), new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        mLastLocation = task.getResult();
                        latitud = mLastLocation.getLatitude();
                        longitude = mLastLocation.getLongitude();
                        Log.d("123", "latitud + \",\" + longituden");
                        loadData(latitud + "," + longitude);

                    } else {
                        Log.v("Error", "GetLastLocation:Exception", task.getException());
                    }
                }
            });

        }
    }


}
