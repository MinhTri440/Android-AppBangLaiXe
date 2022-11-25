package tdtu.android.banglaib1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LytThuyetLietFragment extends Fragment {

    public static final String ARG_PAGE="trang";
    private List<Lythuyet> mdata;
    private int mPageNumber;// vi tri trang hien tai
    private TextView de,a,b,c,d;
    private ImageView hinh;
    private Context context;
    private Button toolbar;
    public LytThuyetLietFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SlideLT_liet_Activity slideLT_liet_activity = (SlideLT_liet_Activity) getActivity();

        mdata= slideLT_liet_activity.getData();

        mPageNumber=getArguments().getInt(ARG_PAGE);
    }

    // tao view cho tung slide
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_lyt_thuyet_liet, container, false);
        de = (TextView) rootView.findViewById(R.id.textView3);
        hinh =(ImageView) rootView.findViewById(R.id.imageViewhoclythuyet);
        a= (TextView) rootView.findViewById(R.id.textViewrow3);
        b= (TextView) rootView.findViewById(R.id.textView6);
        c= (TextView) rootView.findViewById(R.id.textView8);
        d= (TextView) rootView.findViewById(R.id.textView9);
        toolbar = rootView.findViewById(R.id.button);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ChooseLTActivity.class);
                startActivity(intent);
            }
        });



        return rootView;
    }
    //hàm tạo Slide
    public static LytThuyetLietFragment create(int pagenum)
    {
        LytThuyetLietFragment fragment = new LytThuyetLietFragment();
        // dong goi fragment
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,pagenum);
        fragment.setArguments(args);
        //trả về fragment gửi về nền đe hiẹn thị
        return fragment;
    }
    // Truyen noi dung data vao view
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mdata.get(mPageNumber).getSocau() == 2) {
            de.setText("Câu "+(mPageNumber+1)+": "+mdata.get(mPageNumber).getDe());
            String src = mdata.get(mPageNumber).getHinh();
            int drawableId = this.getResources().getIdentifier(src, "drawable", "tdtu.android.banglaib1");
            hinh.setImageResource(drawableId);

            a.setText("a. "+mdata.get(mPageNumber).getA());
            b.setText("b. "+mdata.get(mPageNumber).getB());
            if(mdata.get(mPageNumber).getA().equals(mdata.get(mPageNumber).getCaudung()))
            {
                a.setBackgroundColor(Color.rgb(87,255,51));

            }
            else
            {
                b.setBackgroundColor(Color.rgb(87,255,51));
            }
            c.setVisibility(View.INVISIBLE);
            d.setVisibility(View.INVISIBLE);
        } else if (mdata.get(mPageNumber).getSocau() == 3) {
            de.setText("Câu "+(mPageNumber+1)+": "+mdata.get(mPageNumber).getDe());
            String src = mdata.get(mPageNumber).getHinh();
            int drawableId = this.getResources().getIdentifier(src, "drawable", "tdtu.android.banglaib1");
            hinh.setImageResource(drawableId);
            if(mdata.get(mPageNumber).getA().equals(mdata.get(mPageNumber).getCaudung()))
            {
                a.setBackgroundColor(Color.rgb(87,255,51));

            }
            else if(mdata.get(mPageNumber).getB().equals(mdata.get(mPageNumber).getCaudung()))
            {
                b.setBackgroundColor(Color.rgb(87,255,51));
            }
            else
            {
                c.setBackgroundColor(Color.rgb(87,255,51));
            }
            a.setText("a. "+mdata.get(mPageNumber).getA());
            b.setText("b. "+mdata.get(mPageNumber).getB());
            c.setText("c. "+mdata.get(mPageNumber).getC());
            d.setVisibility(View.INVISIBLE);
        } else{
            if(mdata.get(mPageNumber).getA().equals(mdata.get(mPageNumber).getCaudung()))
            {
                a.setBackgroundColor(Color.rgb(87,255,51));

            }
            else if(mdata.get(mPageNumber).getB().equals(mdata.get(mPageNumber).getCaudung()))
            {
                b.setBackgroundColor(Color.rgb(87,255,51));
            }
            else if(mdata.get(mPageNumber).getC().equals(mdata.get(mPageNumber).getCaudung()))
            {
                c.setBackgroundColor(Color.rgb(87,255,51));
            }
            else
            {
                d.setBackgroundColor(Color.rgb(87,255,51));
            }
            de.setText("Câu "+(mPageNumber+1)+": "+mdata.get(mPageNumber).getDe());
            String src = mdata.get(mPageNumber).getHinh();
            int drawableId = this.getResources().getIdentifier(src, "drawable", "tdtu.android.banglaib1");
            hinh.setImageResource(drawableId);
            a.setText("a. "+mdata.get(mPageNumber).getA());
            b.setText("b. "+mdata.get(mPageNumber).getB());
            c.setText("c. "+mdata.get(mPageNumber).getC());
            d.setText("d. "+mdata.get(mPageNumber).getD());

        }
    }
}