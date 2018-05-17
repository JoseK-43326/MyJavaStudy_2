package com.example.test_imageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements android.view.View.OnClickListener{
	private Button backButton,nextButton;
	private ImageView imagePic;
	private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
	private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagePic = (ImageView)findViewById(R.id.imagePic);
        backButton = (Button)findViewById(R.id.backButton);
        nextButton = (Button)findViewById(R.id.nextButton);
        backButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.backButton:
			position--;
			if(position < 0 ) position = images.length - 1;
			imagePic.setImageResource(images[position]);
			break;
		case R.id.nextButton:
			position++;
			if(position >= images.length) position = 0;
			imagePic.setImageResource(images[position]);
			break;
		default:
			break;
		}
	}


    
}
