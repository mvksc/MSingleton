package com.mdev.msingleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mdev.msingleton.R;
import com.mdev.msingleton.model.ModelDataBall;
import java.util.List;

public class CustomAdapterTableBall extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private onClickItem onClickItem;
    private Context mContent;
    private List<ModelDataBall> mDataSet;
    private int ftOrHt = 0;

    //Constructor
    public CustomAdapterTableBall(Context context, List<ModelDataBall> dataSet,int ftOrHt) {
        this.mContent = context;
        this.mDataSet = dataSet;
        this.ftOrHt = ftOrHt;
    }

    //Override Method
    @Override
    public int getItemViewType(int position) {
        return mDataSet.get(position).getTypeContent();

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0:
                View vHeader = inflater.inflate(R.layout.item_header_table_ball, parent, false);
                return new ContentHeaderTableBall(vHeader);
            case 1:
                View vBodyHTorFT = inflater.inflate(R.layout.item_body_table_ball, parent, false);
                return new ContentBodyTableBall(vBodyHTorFT);
            case 2:
                View vBody1x2 = inflater.inflate(R.layout.item_body_table_ball, parent, false);
                return new ContentBodyTableBall(vBody1x2);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ModelDataBall dataBall = mDataSet.get(position);
        switch (holder.getItemViewType()) {
            case 0:
                ContentHeaderTableBall headerTableBall = (ContentHeaderTableBall) holder;
                headerTableBall.tvHeader.setText(dataBall.getLeague());
                break;
            case 1:
                ContentBodyTableBall tableBall = (ContentBodyTableBall) holder;
                tableBall.tvItem1.setText(dataBall.getBallID());
                tableBall.tvItem2.setText(dataBall.getHF());
                tableBall.tvItem3.setText(dataBall.getTeam1());
                tableBall.tvItem4.setText(dataBall.getTeam2());
                tableBall.tvItem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo1().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo1(),
                                    1,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getHdc1().toString().trim());
                        }
                    }
                });

                tableBall.tvItem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo2().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo2(),
                                    2,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getHdc2().toString().trim());
                        }
                    }
                });

                tableBall.tvItem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo3().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo3(),
                                    3,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getGoal1().toString().trim());
                        }
                    }
                });

                tableBall.tvItem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo4().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo4(),
                                    4,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getGoal2().toString().trim());
                        }
                    }
                });
                tableBall.tvItem1.setBackgroundResource(R.color.color_time);
                tableBall.tvItem2.setBackgroundResource(R.color.color_time);
                tableBall.tvItem3.setBackgroundResource(R.color.color_time);
                tableBall.tvItem4.setBackgroundResource(R.color.color_time);
                switch (mDataSet.get(position).getClickNo()) {
                    case 1:
                        tableBall.tvItem1.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                    case 2:
                        tableBall.tvItem2.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                    case 3:
                        tableBall.tvItem3.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                    case 4:
                        tableBall.tvItem4.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                }
                break;
            case 2:
                ContentBodyTableBall tableBall1x2 = (ContentBodyTableBall) holder;
                tableBall1x2.tvItem1.setText(dataBall.getBallID());
                tableBall1x2.tvItem2.setText(dataBall.getHF());
                tableBall1x2.tvItem3.setText(dataBall.getTeam1());
                tableBall1x2.tvItem4.setText(dataBall.getTeam2());
                tableBall1x2.tvItem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo1().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo1(),
                                    1,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getHdc1().toString().trim());
                        }
                    }
                });

                tableBall1x2.tvItem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo2().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo2(),
                                    2,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getHdc2().toString().trim());
                        }
                    }
                });

                tableBall1x2.tvItem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo3().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo3(),
                                    3,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getGoal1().toString().trim());
                        }
                    }
                });

                tableBall1x2.tvItem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDataSet.get(position).getNo4().toString().trim().length() > 0) {
                            onClickItem.onClickItem(position,
                                    mDataSet.get(position).getAdd(),
                                    mDataSet.get(position).getNo4(),
                                    4,
                                    mDataSet.get(position).getSubTypeTangBall(),
                                    mDataSet.get(position).getBallID(),
                                    mDataSet.get(position).getGoal2().toString().trim());
                        }
                    }
                });
                tableBall1x2.tvItem1.setBackgroundResource(R.color.color_time);
                tableBall1x2.tvItem2.setBackgroundResource(R.color.color_time);
                tableBall1x2.tvItem3.setBackgroundResource(R.color.color_time);
                tableBall1x2.tvItem4.setBackgroundResource(R.color.color_time);
                switch (mDataSet.get(position).getClickNo()) {
                    case 1:
                        tableBall1x2.tvItem1.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                    case 2:
                        tableBall1x2.tvItem2.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                    case 3:
                        tableBall1x2.tvItem3.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                    case 4:
                        tableBall1x2.tvItem4.setBackgroundResource(R.color.color_bg_no_s);
                        break;
                }
                break;
        }
    }
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    //Inner Class
    static class ContentBodyTableBall extends RecyclerView.ViewHolder {
        private TextView tvItem1, tvItem2, tvItem3,tvItem4;

        public ContentBodyTableBall(View itemView) {
            super(itemView);
            this.tvItem1 = (TextView) itemView.findViewById(R.id.tvItem1);
            this.tvItem2 = (TextView) itemView.findViewById(R.id.tvItem2);
            this.tvItem3 = (TextView) itemView.findViewById(R.id.tvItem3);
            this.tvItem4 = (TextView) itemView.findViewById(R.id.tvItem4);
        }
    }

    static class ContentHeaderTableBall extends RecyclerView.ViewHolder {
        private TextView tvHeader;
        public ContentHeaderTableBall(View itemView) {
            super(itemView);
            this.tvHeader = (TextView) itemView.findViewById(R.id.tvHeader);
        }
    }

    public interface onClickItem{
        public void onClickItem(int position,String add, String no, int subClick, String subTypeTangBall,String billID,String playStep);
    }
    public void setOnClickItem(onClickItem onClickItem){
        this.onClickItem = onClickItem;
    }

}
