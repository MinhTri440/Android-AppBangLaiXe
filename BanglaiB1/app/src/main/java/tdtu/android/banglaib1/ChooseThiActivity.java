package tdtu.android.banglaib1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChooseThiActivity extends AppCompatActivity {
    private ImageView imageDe1,imageDe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_thi);
        imageDe1 = findViewById(R.id.imageView2);
        imageDe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTest1();

            }
        });
        imageDe2 = findViewById(R.id.imageView3);
        imageDe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTest2();

            }
        });
    }
    public void openTest1(){
        Intent intent;
        intent = new Intent(this,De1Activity.class);
        intent.putExtra("dethi","de1");
        startActivity(intent);
    }
    public void openTest2(){
        Intent intent;
        intent = new Intent(this,De1Activity.class);
        intent.putExtra("dethi","de2");
        startActivity(intent);
    }
}