package com.zhoujg77.mytopbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TopBar topBar =(TopBar) findViewById(R.id.topBar);

        topBar.setOnTopBarClickLister(new TopBar.topbarClickLister() {
            @Override
            public void leftClick() {
                Toast.makeText(getApplicationContext(),"左边按钮",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(getApplicationContext(),"右边按钮",Toast.LENGTH_SHORT).show();

            }
        });

	}


}
