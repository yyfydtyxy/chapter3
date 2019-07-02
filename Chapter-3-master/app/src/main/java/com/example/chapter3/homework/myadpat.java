package com.example.chapter3.homework;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class myadpat extends ArrayAdapter {
    private final int ImageId;
    public myadpat(Context context, int headImage, List<listway> obj){
        super(context,headImage,obj);
        ImageId = headImage;//这个是传入我们自己定义的界面
    }
    @Override
    public View getView(final int position, @Nullable View convertView,@Nullable ViewGroup parent) {
        listway myBean = (listway) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ImageId,null);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);//获取该布局内的图片视图
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);//获取该布局内的文本视图
        fruitImage.setImageResource(myBean.getImageID());//为图片视图设置图片资源
        fruitName.setText(myBean.getText());//为文本视图设置文本内容
        LinearLayout linearLayout = view.findViewById(R.id.ll_view);

        /*linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getContext(),"你点击了第"+(position+1)+"项",Toast.LENGTH_SHORT).show();
            }
        });*/
        return view;
    }

}
