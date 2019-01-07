package com.example.enghatoun.aqwas.Main.First;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.example.enghatoun.aqwas.Main.FragmentNavigation;
import com.example.enghatoun.aqwas.R;
import com.example.enghatoun.aqwas.Resturnat_Information.ResturnatInformation;
import com.example.enghatoun.aqwas.Preview_Images.Images;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class FirstFragment extends Fragment implements OnMapReadyCallback , FirstFragmentMVP.View, FragmentNavigation.View{
    protected FragmentNavigation.Presenter navigationPresenter;
    private MapView mMapView;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private FirstFragmentMVP.Presenter presenter;
    private ProgressDialog progressDialog;
    private TextView ResturanName;
    private TextView ResturanCategory;
    private TextView ResturanRate;
    private double lat;
    private double longg;
    private ImageView GoogleMaps;
    private ImageView Images;
    private ImageView ResturantInfo;
    private Intent i;
    private Intent iGoogleMaps;
    private Intent iImages;
    private Intent iResturantInfo;
    private GoogleMap Mymap;
    private Button suggest;
    private String Link;
    private String name;
    private String hours;
    private List<String> ResturantImages;
    private String[] ArrImages;



    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) { super.onCreate(savedInstanceState);}

   @NonNull
   @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
//Getting textViews
       ResturanName = (TextView)view.findViewById(R.id.name);
       ResturanCategory = (TextView)view.findViewById(R.id.category);
       ResturanRate = (TextView)view.findViewById(R.id.rate);
       GoogleMaps = (ImageView)view.findViewById(R.id.googleMap);
       Images = (ImageView)view.findViewById(R.id.images);
       ResturantInfo = (ImageView)view.findViewById(R.id.info);
       mMapView = (MapView)view.findViewById(R.id.mapView);
       mMapView = (MapView)view.findViewById(R.id.mapView);
       suggest = (Button)view.findViewById(R.id.suggest);
//Finished Getting textViews


        initProgressDialog();
        initGoogleMap(savedInstanceState);

        presenter = new FirstFragmentPresenter();
        presenter.setView(this);
        presenter.getLastLocation();


       suggest.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               presenter.getLastLocation();}
       });

       return view;
    }



    private void initGoogleMap(Bundle savedInstanceState){

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
        }

    @Override
    public void onStart() {
       super.onStart();
       mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Mymap = map;
       map.setMyLocationEnabled(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMapView.onDestroy();
    }




    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void setFragment(FirstFragment fragment) {
    }

    @Override
    public void displayData(Resturant resturant) {

Link=resturant.getLink();
name=resturant.getName();
hours=resturant.getOpen();
ResturantImages=resturant.getImage();

ArrImages = new String[ResturantImages.size()];
for (int i=0; i<ResturantImages.size();i++){
    ArrImages[i]=ResturantImages.get(i);
}
//Displaying
        ResturanName.setText(resturant.getName());
        ResturanCategory.setText(resturant.getCat() + " ");
        ResturanRate.setText(" " + resturant.getRating() + "/10");
        lat = Double.valueOf(resturant.getLat());
        longg = Double.valueOf(resturant.getLon());
        Log.d("HATOOUN", "Object Caaaattt..." + resturant.getLat()+" Latt "+lat+ " LONG  " + longg);
        mMapView.getMapAsync(this);
        Mymap.clear();
        Mymap.addMarker(new MarkerOptions().position(new LatLng(lat, longg)));
        Mymap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longg), 11));
        Mymap.animateCamera(CameraUpdateFactory.zoomTo(14));

//Tab bar
        //Direct to Google Map
        GoogleMaps.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                String uri = "http://maps.google.com/maps?daddr=" + lat + "," + longg;
                Log.e("GOOGLE LINK", uri);
                iGoogleMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
               startActivity(iGoogleMaps);

            }
        });

        //Direct to other activity to display Images
        Images.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
                iImages = new Intent(getActivity(),Images.class);
                iImages.putExtra("images",ArrImages);
        startActivity(iImages);
         }
        });

        //Direct to other activiety to display Restaurant Info
        ResturantInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iResturantInfo = new Intent(getActivity(),ResturnatInformation.class);
                iResturantInfo.putExtra("name",name);
                iResturantInfo.putExtra("link",Link);
                iResturantInfo.putExtra("hours",hours);
                startActivity(iResturantInfo);
            }
        });
//Finish Tab bar

    }

    @Override
    public void hideProgressDialog() {
        try {

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog.hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.setMessage("Loading...");
        } else {
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);

            try {
                progressDialog.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void initProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
    }

  @Override
  public FragmentActivity getAppActivity() {
    return this.getActivity();
  }


  @Override
    public void atachPresenter(FragmentNavigation.Presenter presenter) {
        navigationPresenter = presenter;
    }
}