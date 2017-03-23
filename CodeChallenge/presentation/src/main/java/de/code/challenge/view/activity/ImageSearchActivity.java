package de.code.challenge.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import de.code.challenge.R;
import de.code.challenge.presenter.ImageSearchPresenter;
import de.code.challenge.view.adpater.ImageSearchAdapter;

public class ImageSearchActivity extends AppCompatActivity {
    @Inject
    private ImageSearchPresenter imageSearchPresenter;
    @Inject
    ImageSearchAdapter imageSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search);
    }
}
