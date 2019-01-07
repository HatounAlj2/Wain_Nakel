package com.example.enghatoun.aqwas.Main;


import com.example.enghatoun.aqwas.Main.First.FirstFragment;


public interface MainActivityVP {

    interface View{
        void setFragment(FirstFragment fragment);
    }

    interface Presenter{

        void getMainFragment();
        }

}


