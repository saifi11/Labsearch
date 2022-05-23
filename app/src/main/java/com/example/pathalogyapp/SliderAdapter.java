package com.example.pathalogyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

    int [] images;
    String [] text;

    public SliderAdapter(int[] images, String[] text) {
        this.images = images;
        this.text = text;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_slider_image , parent , false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        viewHolder.img.setImageResource(images[position]);
        viewHolder.txt.setText(text[position]);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class SliderViewHolder extends ViewHolder{

        ImageView img;
        TextView txt;
        public SliderViewHolder(View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.image_slider);
            txt=itemView.findViewById(R.id.slider_text);
        }
    }
}
