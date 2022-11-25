package tdtu.android.banglaib1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChooseThiActivity extends AppCompatActivity {
    private ImageView imageDe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_thi);
        imageDe1 = findViewById(R.id.imageView2);
        imageDe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTest();

            }
        });
    }
    public void openTest(){
        Intent intent;
        intent = new Intent(this,De1Activity.class);
        startActivity(intent);
    }
}