package com.adm.magicanswers;





import com.adm.magicanswers.ShakeDetector.OnShakeListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.Menu;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;


import android.widget.TextView;


public class MagicMainActivity extends Activity {
	
	private TextView answer;
	private Generate_Answer new_Answer = new Generate_Answer();
	private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    
   
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magic_main);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		answer = (TextView) findViewById(R.id.answer_view); 
	
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new OnShakeListener() {
 
            @Override
            public void onShake(int count) {
                //on Shake generates a new Answer
                generateAnswer();
            }
        });
        
	
		
		
	}
   
	@Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,    SensorManager.SENSOR_DELAY_UI);
    }
 
    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.magic_main, menu);
		return true;
	}
	 
	
	    	
	       
	private void textAnima(){
		AlphaAnimation fade = new AlphaAnimation (1,0);
	    	fade.setDuration(3000); 
	    	fade.setFillAfter(true); 
	    	answer.setAnimation(fade);
	   
		
	    	fade.setAnimationListener(new Animation.AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					answer.setText("Ask me a question and Shake Me!");
					AlphaAnimation fade = new AlphaAnimation (0,1);
		    		 
		 	    	fade.setDuration(3000); 
		 	    	fade.setFillAfter(true); 
		 	    	answer.setAnimation(fade);
				   
				}
			});
		
	}
	
	 private void generateAnswer() {
	    	answer.setText(new_Answer.get_answer());
	    	
	    	 AlphaAnimation fade = new AlphaAnimation (0,1);
    		 
	 	    	fade.setDuration(3000); 
	 	    	fade.setFillAfter(true); 
	 	    	answer.setAnimation(fade);
	 	    	
	 	    	fade.setAnimationListener(new Animation.AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						textAnima();
					
					}
				});
	 	    
	    	
	    	
	    	
	    }


}
