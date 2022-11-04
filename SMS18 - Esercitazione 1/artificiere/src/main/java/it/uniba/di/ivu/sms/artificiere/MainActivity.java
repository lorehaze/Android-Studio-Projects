package it.uniba.di.ivu.sms.artificiere;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private String TAG = "artificiere";
    private String ACTION_DETONAZIONE = "it.uniba.di.ivu.sms.detonatore.DETONATE";
    private String PERM_DETONAZIONE = "it.uniba.di.ivu.sms.detonatore.permission.baldari";
    private final int MY_PERMISSION_DETONATE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "-onCreate- The activity has been created");
        Button btnTest = (Button) findViewById(R.id.buttonDetonate);

        btnTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goDetonation(v);
            }
        });
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

    public void goDetonation(View v){
        Boolean canDetonate = false;
        if (ContextCompat.checkSelfPermission(this, PERM_DETONAZIONE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, PERM_DETONAZIONE)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{PERM_DETONAZIONE},
                        MY_PERMISSION_DETONATE);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{PERM_DETONAZIONE},
                        MY_PERMISSION_DETONATE);
            }
        } else {
            detonate();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_DETONATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    detonate();
                    Log.i(TAG, getClass().getSimpleName() + ": permission granted from package manager YAY!");
                } else {
                    Log.i(TAG, getClass().getSimpleName() + ": permission denied from package manager BOOOO!");
                }
            }
        }
    }

    public void detonate(){
        startActivity(new Intent(ACTION_DETONAZIONE));
    };
}
