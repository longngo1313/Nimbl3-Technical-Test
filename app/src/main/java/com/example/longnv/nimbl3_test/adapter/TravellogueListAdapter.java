package com.example.longnv.nimbl3_test.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.longnv.nimbl3_test.R;
import com.example.longnv.nimbl3_test.models.Travelogue;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Vu Long on 8/27/2018.
 * nguyenvulong2002@gmail.com
 */
public class TravellogueListAdapter extends RecyclerView.Adapter<TravellogueListAdapter.CustomViewHolder> {


    private Activity mActivity;

    private LayoutInflater mInflater;

    private ArrayList<Travelogue> mListData = new ArrayList<>();

    public TravellogueListAdapter(ArrayList<Travelogue> personContact, Activity activity) {
        this.mListData = personContact;
        this.mInflater = LayoutInflater.from(activity);
        this.mActivity = activity;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_travelogue, viewGroup, false);
        return new TravellogueListAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        if(mListData==null || mActivity==null){
            return;
        }

        Travelogue travelogue = mListData.get(position);

        if(travelogue == null){
            return;
        }

        RequestOptions avatarRequest = new RequestOptions()
                .circleCrop()
                .autoClone()
                .placeholder(R.drawable.ic_person_black_24dp);

        RequestOptions bgRequest = new RequestOptions()
                .placeholder(R.drawable.progress);

        Glide.with(mActivity).load(travelogue.getCoverImageUrl())
                .apply(bgRequest)
                .into(holder.mBackground);
        Glide.with(mActivity).load(travelogue.getUser().getAvatar())
                .apply(avatarRequest)
                .into(holder.mAvatar);
        holder.mAvatarName.setText(travelogue.getUser().getName());
        holder.mDate.setText(travelogue.getStartDate());
        holder.mComment.setText(travelogue.getSlug());

    }

    @Override
    public int getItemCount() {
        return (mListData!=null && !mListData.isEmpty()) ? mListData.size() : 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImageView mAvatar;

        private TextView mAvatarName,mDate,mComment;

        private ImageView mBackground;


        public CustomViewHolder(View view) {
            super(view);
            this.mAvatar = view.findViewById(R.id.img_user_avatar);
            this.mAvatarName = view.findViewById(R.id.txt_user_name);
            this.mDate = view.findViewById(R.id.txt_date);
            this.mComment = view.findViewById(R.id.txt_travelogue_comment);
            this.mBackground = view.findViewById(R.id.bg_travelogue);
        }
    }

}
