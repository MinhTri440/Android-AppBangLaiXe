package tdtu.android.banglaib1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toolbar;

import tdtu.android.banglaib1.R;

public class ChooseLTActivity extends AppCompatActivity {
    private ImageButton imageButton1,imageButton2;

    private Toolbar back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ltactivity);

        imageButton1= (ImageButton) findViewById(R.id.imageButton12);
                imageButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nexttofragment();
                    }
                });
        imageButton2= (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nexttofragment2();
            }
        });
    }
    public void nexttofragment()
    {
        Intent intent;
        intent = new Intent(this,SlideLTActivity.class);
        startActivity(intent);
    }
    public void nexttofragment2()
    {
        Intent intent;
        intent = new Intent(this,SlideLT_liet_Activity.class);
        startActivity(intent);
    }
}