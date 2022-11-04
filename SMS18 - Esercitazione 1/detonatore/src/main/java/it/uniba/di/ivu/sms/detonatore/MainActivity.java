package it.uniba.di.ivu.sms.detonatore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "detonatore";
    private String ACTION_DETONAZIONE = "it.uniba.di.ivu.sms.detonatore.DETONATE";
    private String PERM_DETONAZIONE = "it.uniba.di.ivu.sms.detonatore.permission.baldari";
    private final int MY_PERMISSION_DETONATE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "-onCreate- The activity has been created");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "-onDestroy- The activity is about to be destroyed");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "-onStart- The activity is started");
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"-onRestart - The activity is restarted");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "-onStop - The activity is stopped");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "-onResume- The activity is resumed");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "-onPause- The activity is paused");
    }
}
