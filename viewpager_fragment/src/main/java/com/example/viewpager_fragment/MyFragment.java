package com.example.viewpager_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 小钊 on 2016/8/23.
 */
public class MyFragment extends Fragment {
    int num;
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    public static MyFragment newInstance(int num){
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        num = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment,null);
        TextView textView = (TextView) view.findViewById(R.id.text);
        switch (num) {
            case 0:
                textView.setText("聊天界面");
                break;
            case 1:
                textView.setText("好友");
                break;
            case 2:
                textView.setText("通信录");
                break;
        }

        return view;
    }


}
