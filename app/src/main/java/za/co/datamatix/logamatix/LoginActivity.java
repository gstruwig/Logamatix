package za.co.datamatix.logamatix;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import za.co.datamatix.logamatix.register.Register;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "psOrPKMeYoZ8ZLS3TxRRx3jze63iOayM06FEtCPN", "HPMgShvLAomb2kanY9R27N1pTHoXebLhagzhSynj");

        username =  (EditText)findViewById(R.id.username);
        password =  (EditText)findViewById(R.id.password);

//        ParseUser currentUser = ParseUser.getCurrentUser();
//        if (currentUser != null) {
//            // do stuff with the user
//            startActivity(new Intent(LoginActivity.this, LithAddActivity.class));
//        } else {
//            // show the signup or login screen
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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


    public void viewdataForm(View view){
        if (username.length() == 0 || password.length() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please enter login details");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else {
            ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        System.out.println(user.getEmail())  ;
                     System.out.println(user.get("cellNumber"))  ;
                        // Hooray! The user is logged in.
                        //do something in response to logon button
                        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                    } else {
                        // Signup failed. Look at the ParseException to see what happened.
                       displayErrorMsg(e.getMessage());

                    }
                }
            });

        }


    }

    public void registerUser(View view) {
        startActivity(new Intent(LoginActivity.this, Register.class));
    }

    private void displayErrorMsg (String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage( msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
