package za.co.datamatix.logamatix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
      //  Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
     //   setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(id.fab);
       // fab.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
         //       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
         //               .setAction("Action", null).show();
          //  }
      //  });
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void viewLithAddForm(View view){

        startActivity(new Intent(MenuActivity.this, LithAddActivity.class));
    }

}
