package com.coderwjq.simplefactory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IOFactory.getIOHandler(DBHandler.class).insert();
        IOFactory.getIOHandler(XMLHandler.class).insert();
    }
}
