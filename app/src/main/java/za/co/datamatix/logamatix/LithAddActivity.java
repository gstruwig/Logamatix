package za.co.datamatix.logamatix;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class LithAddActivity extends AppCompatActivity {

    EditText project;
    EditText borehole;
    EditText lithtype;
    EditText depthfrom;
    EditText depthto;
    EditText lith1;
    ProgressDialog mDialog;
// testing commit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlithology);

// Test the SDK is working - temp code
        // ParseObject testObject = new ParseObject("TestObject");
        //  testObject.put("foo", "bar");
        //  testObject.saveInBackground();

        project =  (EditText)findViewById(R.id.project);
        borehole =  (EditText)findViewById(R.id.borehole);
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
    } // test

    public void addRecord(View view) {
        boolean problem = false;
        String msg = "";
        if (project.getText().toString().length() == 0) {
            problem = true;
            msg = "Please enter a project name";
        }
        else if (borehole.getText().toString().length() == 0) {
            problem = true;
            msg = "Please enter a borehole name";
        }
        else if (lithtype.getText().toString().length() == 0) {
            problem = true;
            msg = "Please enter a lithtype name";
        }
        else if (depthfrom.getText().toString().length() == 0) {
            problem = true;
            msg = "Please enter a depth from";
        }
        else if (depthto.getText().toString().length() == 0) {
            problem = true;
            msg = "Please enter a depth to";
        }
        if (!problem) {
            addRecord();
        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);//,R.style.myBackgroundStyle

            alert.setTitle("Error");
            alert.setMessage(msg);
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });
            alert.show();
        }
    }



    private void addRecord() {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Saving");
        mDialog.setCancelable(false);
        mDialog.show();
        final ParseObject lithology = new ParseObject("Lithology");

        lithology.put("Project",project.getText().toString());
        lithology.put("Borehole",borehole.getText().toString());
        lithology.put("IntervalType",lithtype.getText().toString());
        lithology.put("DepthFrom",Integer.parseInt(depthfrom.getText().toString()));
        lithology.put("DepthTo",Integer.parseInt(depthto.getText().toString()));
        lithology.put("Lith1",lith1.getText().toString());

        lithology.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    project.setText(project.getText().toString());
                    borehole.setText(borehole.getText().toString());
                    lithtype.setText(lithtype.getText().toString());
                    depthfrom.setText(depthto.getText().toString());
                    depthto.setText("");
                    lith1.setText("");
                    mDialog.cancel();
                } else {
                    // The save failed.
                    System.out.println("Error updating user data: " + e);
                    mDialog.cancel();
                }
            }
        });

    }



}
