package com.teclever.test.androidassignment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadImage();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction tm = fm.beginTransaction();
        FragmentActivity obj1 = new FragmentActivity();
        FragmentActivity2 obj2 = new FragmentActivity2();
        tm.add(R.id.container1, obj1);
        tm.add(R.id.container2, obj2);
        tm.commit();
    }

    private void downloadImage() {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "News", "images");
        if (!file.exists())
            file.mkdirs();
    }
}


