package areeb.udacity.project0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "App Portfolio";
    private static final int[]    ids    = {R.id.spotify, R.id.scores, R.id.library, R.id.build, R.id.xyz, R.id.capstone};
    private static final String[] toasts = {"Spotify Streamer", "Super Duo : Football Scores",
                                            "Super Duo : Library", "Build it Bigger", "XYZ Reader", "Capstone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set On Click Listeners on all Buttons
        for(int id : ids){
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int index = Arrays.asList(ids).indexOf(view.getId());

        // Check if the required button is clicked, otherwise return
        if(index<0)
            return;

        //Map the ID index with toast index, and catch for exception
        try{
            Toast.makeText(this, "This button will launch my " + toasts[index] + " app!", Toast.LENGTH_SHORT).show();
        } catch (ArrayIndexOutOfBoundsException ae){
            Log.d(TAG, "No toast string found for corresponding ID : " + index);
            ae.printStackTrace();
            Toast.makeText(this, "Invalid click registered", Toast.LENGTH_SHORT).show();
        }

    }
}
