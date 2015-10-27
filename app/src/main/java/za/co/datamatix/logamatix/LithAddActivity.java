package za.co.datamatix.logamatix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseObject;

public class LithAddActivity extends AppCompatActivity {

    EditText project;
    EditText borehole;
    EditText lithtype;
    EditText depthfrom;
    EditText depthto;
    EditText lith1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlithology);

// Test the SDK is working - temp code
       // ParseObject testObject = new ParseObject("TestObject");
      //  testObject.put("foo", "bar");
      //  testObject.saveInBackground();

        project =  (EditText)findViewById(R.id.project);
        borehole =  (EditText)findViewById(R.id.username);
        lithtype =  (EditText)findViewById(R.id.lithtype);
        depthfrom =  (EditText)findViewById(R.id.depthfrom);
        depthto =  (EditText)findViewById(R.id.depthto);
        lith1 =  (EditText)findViewById(R.id.lithcode1);

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

    public void addRecord(View view) {
        // ParseObject testObject = new ParseObject("TestObject");
        //  testObject.put("foo", "bar");
        //  testObject.saveInBackground();

           ParseObject lithology = new ParseObject("Lithology");

        lithology.put("Project",project.toString());
        lithology.put("Borehole",borehole.toString());
        lithology.put("IntervalType",lithtype.toString());
        lithology.put("DepthFrom",depthfrom.toString());
        lithology.put("DepthTo",depthto.toString());
        lithology.put("Lith1",lith1.toString());
        lithology.saveInBackground();

    }
}
