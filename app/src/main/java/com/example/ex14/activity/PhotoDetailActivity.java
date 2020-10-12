package com.example.ex14.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.ex14.R;
import com.example.ex14.utils.Constants;
import com.example.ex14.utils.ImageUtil;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        String url = getIntent().getStringExtra(Constants.INTENT_EXTRAL_PHOTO_URL);
        ImageView pvPhotoDetail = findViewById(R.id.pv_photo_detail);
        ImageUtil.show(this, pvPhotoDetail, url);
    }
}
