package it.moondroid.popupwindowdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
    implements LoginPopupWindow.LoginPopupListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_channels).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopup(view);
                ChannelsPopupWindow popupWindow = new ChannelsPopupWindow(MainActivity.this);
                popupWindow.showToggle(view, 0, 0);
            }
        });

        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopup(view);
                LoginPopupWindow popupWindow = new LoginPopupWindow(MainActivity.this);
                popupWindow.showToggle(view, 0, 0);
            }
        });

        findViewById(R.id.button_dispositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopup(view);
                DispositivePopupWindow popupWindow = new DispositivePopupWindow(MainActivity.this);
                popupWindow.showToggle(view, 0, 0);
            }
        });
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

    private void showPopup(View view){
        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(this);

        ArrayList<String> sortList = new ArrayList<String>();
        sortList.add("A to Z");
        sortList.add("Z to A");
        sortList.add("Low to high price");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, sortList);
        // the drop down list is a list view
        ListView listViewSort = new ListView(this);

        // set our adapter and pass our pop up window contents
        listViewSort.setAdapter(adapter);

        // set on item selected
        //listViewSort.setOnItemClickListener(onItemClickListener());

        // some other visual settings for popup window
        popupWindow.setFocusable(true);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        //popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.white));
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        // set the list view as pop up window content
        popupWindow.setContentView(listViewSort);

        popupWindow.showAsDropDown(view, 0, 0); // show popup like dropdown list
    }

    @Override
    public void onLogin() {

    }
}
