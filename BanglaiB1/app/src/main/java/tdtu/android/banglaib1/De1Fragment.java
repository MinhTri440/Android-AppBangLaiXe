package tdtu.android.banglaib1;

import android.app.PendingIntent;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.security.acl.Group;
import java.util.List;


public class De1Fragment extends Fragment {
    public static final String ARG_PAGE="trang";
    private List<Lythuyet> mdata;
    private int mPageNumber;// vi tri trang hien tai
    private TextView de;
    private RadioButton a,b,c,d;
    private ImageView hinh;
    private Context context;
    private RadioGroup group;
    private RadioButton radioButton;

    public De1Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SlideDe1Activity slideDe1Activity = (SlideDe1Activity) getActivity();

        mdata= slideDe1Activity.getData();

        mPageNumber=getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_de1, container, false);
        de = (TextView) rootView.findViewById(R.id.textView3);
        hinh =(ImageView) rootView.findViewById(R.id.imageViewhoclythuyet);
        a= (RadioButton) rootView.findViewById(R.id.textViewrow3);
        b= (RadioButton) rootView.findViewById(R.id.textView6);
        c= (RadioButton) rootView.findViewById(R.id.textView8);
        d= (RadioButton) rootView.findViewById(R.id.textView9);
        group= (RadioGroup) rootView.findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(R.id.textViewrow3==i)
                {
                    SlideDe1Activity slideDe1Activity = (SlideDe1Activity) getActivity();

                    slideDe1Activity.LuuTraLoi(mdata.get(mPageNumber).getDe(),mdata.get(mPageNumber).getA());
                }
                else if(R.id.textView6==i)
                {
                    SlideDe1Activity slideDe1Activity = (SlideDe1Activity) getActivity();
                    slideDe1Activity.LuuTraLoi(mdata.get(mPageNumber).getDe(),mdata.get(mPageNumber).getB());
                }
                else if(R.id.textView8==i)
                {
                    SlideDe1Activity slideDe1Activity = (SlideDe1Activity) getActivity();
                    slideDe1Activity.LuuTraLoi(mdata.get(mPageNumber).getDe(),mdata.get(mPageNumber).getC());
                }
                else if(R.id.textView9==i)
                {
                    SlideDe1Activity slideDe1Activity = (SlideDe1Activity) getActivity();
                    slideDe1Activity.LuuTraLoi(mdata.get(mPageNumber).getDe(),mdata.get(mPageNumber).getD());
                }
                else
                {
                    ;
                }


            }
        });




        return rootView;
    }
    //hàm tạo Slide
    public static De1Fragment create(int pagenum)
    {
        De1Fragment fragment = new De1Fragment();
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
            c.setVisibility(View.INVISIBLE);
            d.setVisibility(View.INVISIBLE);
        } else if (mdata.get(mPageNumber).getSocau() == 3) {
            de.setText("Câu "+(mPageNumber+1)+": "+mdata.get(mPageNumber).getDe());
            String src = mdata.get(mPageNumber).getHinh();
            int drawableId = this.getResources().getIdentifier(src, "drawable", "tdtu.android.banglaib1");
            hinh.setImageResource(drawableId);
            a.setText("a. "+mdata.get(mPageNumber).getA());
            b.setText("b. "+mdata.get(mPageNumber).getB());
            c.setText("c. "+mdata.get(mPageNumber).getC());
            d.setVisibility(View.INVISIBLE);
        } else{
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