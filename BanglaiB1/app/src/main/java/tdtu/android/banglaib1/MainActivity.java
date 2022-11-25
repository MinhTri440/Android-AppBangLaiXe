package tdtu.android.banglaib1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "B1";
    private ImageButton buttonHocLythuyet,buttonThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonHocLythuyet =(ImageButton) findViewById(R.id.imageButton2);
        buttonHocLythuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHoclythuyet();

            }
        });
        buttonThi =(ImageButton) findViewById(R.id.imageButton3);
        buttonThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThi();

            }
        });

    }
    public void openHoclythuyet()
    {
        Intent intent;
        intent = new Intent(this,ChooseLTActivity.class);
        startActivity(intent);
    }
    public void openThi()
    {
        Intent intent;
        intent = new Intent(this,ChooseThiActivity.class);
        startActivity(intent);
    }
    //dang ky option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }
    //cac thành phần trong menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder alertDialog;
        switch (item.getItemId()) {
            case R.id.about:
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("About");
                alertDialog.setMessage("Le Minh Tri");

                alertDialog.show();

                return true;
            case R.id.help:
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Help");
                alertDialog.setMessage("Hướng dẫn sử dụng");

                alertDialog.show();
                return true;
            case R.id.exit:
                alertDialog = new
                        AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Confirm?");
                alertDialog.setMessage("Are you sure you want to exit the app");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //...
                    }
                });
                alertDialog.show();
                return true;



            default:
                return super.onOptionsItemSelected(item);

        }
    }

}