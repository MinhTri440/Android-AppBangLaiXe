package tdtu.android.banglaib1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SlideDe1Activity extends FragmentActivity {
    private static final int NUM_PAGES = 30;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    //khai bao viewPage
    private ViewPager mPager;
    //Bien cua fragment
    private PagerAdapter pagerAdapter;
    private TextView timeText;
    private Button submit,thoat;
    private List<Lythuyet> mData;
    private DataHelper mDbHelper;
    private CountDownTimer countDownTimer;
    private long TimeOfTest=600000*2;
    private boolean timeRunning;
    int count=0;
    private String value;
    public static String de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_de1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("dethi");
            //The key argument here must match that used in the other activity
        }
        if(value.equals("de1")) {
            mDbHelper = new DataHelper(this);
            mDbHelper.createDefaultLythuyet();
            mData = mDbHelper.getAllLythuyet();
            de="de1";
        }
        else if(value.equals("de2"))
        {
            mDbHelper = new DataHelper(this);
            mDbHelper.createDefaultLythuyet();
            mData = mDbHelper.getAllLythuyetDe2();
            de="de2";
        }
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager3);
        //set adapter giong nhu listview
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setAdapter(pagerAdapter);
        timeText = (TextView) findViewById(R.id.timetest);
        startTime();
        thoat = (Button) findViewById(R.id.textView16);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder b = new AlertDialog.Builder(SlideDe1Activity.this);
                //Thiết lập tiêu đề
                b.setTitle("Ngừng kiểm tra");
                b.setMessage("Bạn có đồng ý thoát kiểm tra không?");
                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mData=mDbHelper.getAllLythuyet();
                        OutTest();
                    }
                });
                //Nút Cancel
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                //Tạo dialog
                AlertDialog al = b.create();
                //Hiển thị
                al.show();
            }
        });
        submit = (Button) findViewById(R.id.textView21);
        //check dap an
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            //lấy câu đúng
            public void onClick(View view) {
                for (Lythuyet e: mData) {
                    if(!e.getCaudung().equals(e.getTraloi()))
                    {
                        if(e.getCauliet()==1)
                        {
                            count=-1;
                            break;
                        }
                        else
                        {
                            count++;
                        }

                    }

                }
                countDownTimer.cancel();
                openKetqua(count);

            }
        });
    }
    public String getDe()
    {
        return de;
    }
    public void OutTest(){
        Intent intent;
        intent = new Intent(this,ChooseThiActivity.class);
        startActivity(intent);
    }


    public void openKetqua(int count)
    {
        Intent intent;
        intent = new Intent(this,KetQuaActivity.class);
        intent.putExtra("causai",count);
        startActivity(intent);
    }
    //bat dau thoi gian lam
    public void startTime()
    {
        countDownTimer = new CountDownTimer(TimeOfTest,1000) {
            @Override
            public void onTick(long l) {
                TimeOfTest=l;
                updateTime();
                timeRunning=true;

            }

            @Override
            public void onFinish() {
                openKetqua(count);
                timeRunning=false;
            }
        }.start();

    }
    //cap nhat thoi gian
    public void updateTime()
    {
        int minutes=(int) TimeOfTest/60000;
        int second= (int) TimeOfTest % 60000 / 1000;
        String time;
        time=""+minutes+":";
        if(second<10) time+="0";
        time+=second;
        timeText.setText(time);
    }
    public List<Lythuyet> getData()
    {
        return  mData;
    }
    public void LuuTraLoi(String de,String traloi)
    {
        for (Lythuyet l: mData
             ) {
            if(l.getDe().equals(de))
            {
                l.setTraloi(traloi);
                break;
            }

        }

    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //goi ham tao
        // tra ve fragment position dau fragment
        @Override
        public Fragment getItem(int position) {
            return De1Fragment.create(position);
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    //hieu ung
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
}