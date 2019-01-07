package com.example.enghatoun.aqwas.Main;

import com.example.enghatoun.aqwas.Main.First.FirstFragment;

public interface FragmentNavigation {
    interface View {
        void atachPresenter(Presenter presenter);
    }
    interface Presenter {
        void addFragment(FirstFragment fragment);
    }
}