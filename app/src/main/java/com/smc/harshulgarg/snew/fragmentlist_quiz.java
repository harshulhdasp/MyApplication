package com.smc.harshulgarg.snew;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshul garg on 09-Jun-15.
 */
public class fragmentlist_quiz extends android.support.v4.app.Fragment
{
    quizlistAdapter adapter;
    RecyclerView recyclerView;
    private static List<list_info> demoData;

    public fragmentlist_quiz() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_quiz, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        demoData = new ArrayList<list_info>();
            list_info mode0 = new list_info();
            mode0.a1 = "GEOGRAPHY";
            mode0.a2="Dive right into this section to test your knowlegde on all things related to Earth.";
           /* mode0.bMap = BitmapFactory.decodeResource(getResources(), R.drawable.world);
            mode0.bMapScaled = Bitmap.createScaledBitmap(mode0.bMap, 500, 334, true);*/
            mode0.imagecode=getResources().getIdentifier("world", "drawable","com.smc.harshulgarg.snew");
            demoData.add(mode0);
            list_info mode1=new list_info();
            mode1.a1="HISTORY";
            mode1.a2="Think you know the history? Test your knowledge here.";
            /*mode1.bMap = BitmapFactory.decodeResource(getResources(), R.drawable.world);
            mode1.bMapScaled = Bitmap.createScaledBitmap(mode1.bMap, 500, 334, true);*/
            mode1.imagecode=getResources().getIdentifier("hist", "drawable","com.smc.harshulgarg.snew");
            demoData.add(mode1);
            list_info mode2=new list_info();
            mode2.a1="GEN. KNOWLEDGE";
            mode2.a2="Prove your general knowledge by answering these questions.";
            /*mode2.bMap = BitmapFactory.decodeResource(getResources(), R.drawable.world);
            mode2.bMapScaled = Bitmap.createScaledBitmap(mode2.bMap, 500, 334, true);*/
            mode2.imagecode=getResources().getIdentifier("gk", "drawable","com.smc.harshulgarg.snew");
            demoData.add(mode2);
        adapter = new quizlistAdapter(demoData);
        recyclerView.setAdapter(adapter);
    }
}
     class quizlistAdapter extends RecyclerView.Adapter<quizlistAdapter.quizViewHolder>{
        private List<list_info> listinfo;
         quizlistAdapter(List<list_info> modelData) {
             if (modelData == null) {
                 throw new IllegalArgumentException("modelData must not be null");
             }
             listinfo = modelData;

         }

        @Override
        public quizViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.avc, viewGroup, false);

            return new quizViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(quizViewHolder quizviewholder, int i) {
            list_info ci=listinfo.get(i);
            quizviewholder.mshowtitle.setText(ci.a1);
            quizviewholder.mshowdesc.setText(ci.a2);
            quizviewholder.mimage.setImageResource(ci.imagecode);
        }

        @Override
        public int getItemCount() {
            return listinfo.size();
        }
        public static class quizViewHolder extends RecyclerView.ViewHolder{
            public View view;
             TextView mshowtitle;
            TextView mshowdesc;
            ImageView mimage;
            quizViewHolder(View v){
                super(v);
                view=v;
                mshowtitle=(TextView)v.findViewById(R.id.title);
                mshowdesc=(TextView)v.findViewById(R.id.desc);
                mimage=(ImageView)v.findViewById(R.id.img_thumbnail);
                view.setOnClickListener(new View.OnClickListener(){
                    @Override
                public void onClick(View v){
                        Toast.makeText(v.getContext(),"HELLO",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    }

