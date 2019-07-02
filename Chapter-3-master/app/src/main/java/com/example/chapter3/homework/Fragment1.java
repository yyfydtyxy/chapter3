package com.example.chapter3.homework;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment {
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;

    private ViewGroup G1;
    private ListView G2;
    private List<listway> myBeanList = new ArrayList<>();
    private Context context;
    private List<String> list=null;

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){
        View view=View .inflate(getActivity(),R.layout .activity_fragment1 ,null) ;
        animationView = view.findViewById(R.id.animation_view);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1,0);
        animator1.setDuration(5000);
        G2 = (ListView) view.findViewById(R.id.rv_list);
        init();
        myadpat adapter = new myadpat(getActivity(),R.layout.mytest,myBeanList);
        G2.setAdapter(adapter);
        G2.setAlpha(0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(G2,"alpha",0,1);
        animator2.setDuration(5000);
        animator2.setStartDelay(5000);

        animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator1);
        animatorSet.playTogether(animator2);
        animatorSet.start();
        return view;
    }

    private void init(){
        listway bean1 = new listway("a1",R.mipmap.ic_launcher);
        myBeanList.add(bean1);

        listway bean2 = new listway("a2",R.mipmap.ic_launcher);
        myBeanList.add(bean2);

        listway bean3 = new listway("a3",R.mipmap.ic_launcher);
        myBeanList.add(bean3);

        listway bean4 = new listway("a4",R.mipmap.ic_launcher);
        myBeanList.add(bean4);

        listway bean5 = new listway("a5",R.mipmap.ic_launcher);
        myBeanList.add(bean5);

        listway bean6 = new listway("a6",R.mipmap.ic_launcher);
        myBeanList.add(bean6);

        listway bean7 = new listway("a7",R.mipmap.ic_launcher);
        myBeanList.add(bean7);

        listway bean8 = new listway("a8",R.mipmap.ic_launcher);
        myBeanList.add(bean8);

        listway bean9 = new listway("a9",R.mipmap.ic_launcher);
        myBeanList.add(bean9);
    }

}

