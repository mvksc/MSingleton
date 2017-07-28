package com.mdev.msingleton.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KHUNTONGDANG on 27/7/2560.
 */

public class ModelDataBall implements Parcelable{
    private String BallID,Team1,Team2,Score,Play_Time,Play_Score,Play_Date,League,
            Hdc,Hdc1,Hdc2,Goal,Goal1,Goal2,Big,HF,PriceTeam1,PriceAye,PriceTeam2,
            Odd,Even,SubTypeTangBall,Add,No1,No2,No3,No4,No5,RedCard1,RedCard2;
    private int clickNo,typeContent;
    private boolean flash1,flash2,flash3,flash4,flash5;

    public ModelDataBall(){}

    protected ModelDataBall(Parcel in) {
        BallID = in.readString();
        Team1 = in.readString();
        Team2 = in.readString();
        Score = in.readString();
        Play_Time = in.readString();
        Play_Score = in.readString();
        Play_Date = in.readString();
        League = in.readString();
        Hdc = in.readString();
        Hdc1 = in.readString();
        Hdc2 = in.readString();
        Goal = in.readString();
        Goal1 = in.readString();
        Goal2 = in.readString();
        Big = in.readString();
        HF = in.readString();
        PriceTeam1 = in.readString();
        PriceAye = in.readString();
        PriceTeam2 = in.readString();
        Odd = in.readString();
        Even = in.readString();
        SubTypeTangBall = in.readString();
        Add = in.readString();
        No1 = in.readString();
        No2 = in.readString();
        No3 = in.readString();
        No4 = in.readString();
        No5 = in.readString();
        RedCard1 = in.readString();
        RedCard2 = in.readString();
        clickNo = in.readInt();
        typeContent = in.readInt();
        flash1 = in.readByte() != 0;
        flash2 = in.readByte() != 0;
        flash3 = in.readByte() != 0;
        flash4 = in.readByte() != 0;
        flash5 = in.readByte() != 0;
    }

    public static final Creator<ModelDataBall> CREATOR = new Creator<ModelDataBall>() {
        @Override
        public ModelDataBall createFromParcel(Parcel in) {
            return new ModelDataBall(in);
        }

        @Override
        public ModelDataBall[] newArray(int size) {
            return new ModelDataBall[size];
        }
    };

    public String getBallID() {
        return BallID;
    }

    public void setBallID(String ballID) {
        BallID = ballID;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getPlay_Time() {
        return Play_Time;
    }

    public void setPlay_Time(String play_Time) {
        Play_Time = play_Time;
    }

    public String getPlay_Score() {
        return Play_Score;
    }

    public void setPlay_Score(String play_Score) {
        Play_Score = play_Score;
    }

    public String getPlay_Date() {
        return Play_Date;
    }

    public void setPlay_Date(String play_Date) {
        Play_Date = play_Date;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public String getHdc() {
        return Hdc;
    }

    public void setHdc(String hdc) {
        Hdc = hdc;
    }

    public String getHdc1() {
        return Hdc1;
    }

    public void setHdc1(String hdc1) {
        Hdc1 = hdc1;
    }

    public String getHdc2() {
        return Hdc2;
    }

    public void setHdc2(String hdc2) {
        Hdc2 = hdc2;
    }

    public String getGoal() {
        return Goal;
    }

    public void setGoal(String goal) {
        Goal = goal;
    }

    public String getGoal1() {
        return Goal1;
    }

    public void setGoal1(String goal1) {
        Goal1 = goal1;
    }

    public String getGoal2() {
        return Goal2;
    }

    public void setGoal2(String goal2) {
        Goal2 = goal2;
    }

    public String getBig() {
        return Big;
    }

    public void setBig(String big) {
        Big = big;
    }

    public String getHF() {
        return HF;
    }

    public void setHF(String HF) {
        this.HF = HF;
    }

    public String getPriceTeam1() {
        return PriceTeam1;
    }

    public void setPriceTeam1(String priceTeam1) {
        PriceTeam1 = priceTeam1;
    }

    public String getPriceAye() {
        return PriceAye;
    }

    public void setPriceAye(String priceAye) {
        PriceAye = priceAye;
    }

    public String getPriceTeam2() {
        return PriceTeam2;
    }

    public void setPriceTeam2(String priceTeam2) {
        PriceTeam2 = priceTeam2;
    }

    public String getOdd() {
        return Odd;
    }

    public void setOdd(String odd) {
        Odd = odd;
    }

    public String getEven() {
        return Even;
    }

    public void setEven(String even) {
        Even = even;
    }

    public String getSubTypeTangBall() {
        return SubTypeTangBall;
    }

    public void setSubTypeTangBall(String subTypeTangBall) {
        SubTypeTangBall = subTypeTangBall;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public String getNo1() {
        return No1;
    }

    public void setNo1(String no1) {
        No1 = no1;
    }

    public String getNo2() {
        return No2;
    }

    public void setNo2(String no2) {
        No2 = no2;
    }

    public String getNo3() {
        return No3;
    }

    public void setNo3(String no3) {
        No3 = no3;
    }

    public String getNo4() {
        return No4;
    }

    public void setNo4(String no4) {
        No4 = no4;
    }

    public String getNo5() {
        return No5;
    }

    public void setNo5(String no5) {
        No5 = no5;
    }

    public String getRedCard1() {
        return RedCard1;
    }

    public void setRedCard1(String redCard1) {
        RedCard1 = redCard1;
    }

    public String getRedCard2() {
        return RedCard2;
    }

    public void setRedCard2(String redCard2) {
        RedCard2 = redCard2;
    }

    public int getClickNo() {
        return clickNo;
    }

    public void setClickNo(int clickNo) {
        this.clickNo = clickNo;
    }

    public int getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(int typeContent) {
        this.typeContent = typeContent;
    }

    public boolean isFlash1() {
        return flash1;
    }

    public void setFlash1(boolean flash1) {
        this.flash1 = flash1;
    }

    public boolean isFlash2() {
        return flash2;
    }

    public void setFlash2(boolean flash2) {
        this.flash2 = flash2;
    }

    public boolean isFlash3() {
        return flash3;
    }

    public void setFlash3(boolean flash3) {
        this.flash3 = flash3;
    }

    public boolean isFlash4() {
        return flash4;
    }

    public void setFlash4(boolean flash4) {
        this.flash4 = flash4;
    }

    public boolean isFlash5() {
        return flash5;
    }

    public void setFlash5(boolean flash5) {
        this.flash5 = flash5;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(BallID);
        dest.writeString(Team1);
        dest.writeString(Team2);
        dest.writeString(Score);
        dest.writeString(Play_Time);
        dest.writeString(Play_Score);
        dest.writeString(Play_Date);
        dest.writeString(League);
        dest.writeString(Hdc);
        dest.writeString(Hdc1);
        dest.writeString(Hdc2);
        dest.writeString(Goal);
        dest.writeString(Goal1);
        dest.writeString(Goal2);
        dest.writeString(Big);
        dest.writeString(HF);
        dest.writeString(PriceTeam1);
        dest.writeString(PriceAye);
        dest.writeString(PriceTeam2);
        dest.writeString(Odd);
        dest.writeString(Even);
        dest.writeString(SubTypeTangBall);
        dest.writeString(Add);
        dest.writeString(No1);
        dest.writeString(No2);
        dest.writeString(No3);
        dest.writeString(No4);
        dest.writeString(No5);
        dest.writeString(RedCard1);
        dest.writeString(RedCard2);
        dest.writeInt(clickNo);
        dest.writeInt(typeContent);
        dest.writeByte((byte) (flash1 ? 1 : 0));
        dest.writeByte((byte) (flash2 ? 1 : 0));
        dest.writeByte((byte) (flash3 ? 1 : 0));
        dest.writeByte((byte) (flash4 ? 1 : 0));
        dest.writeByte((byte) (flash5 ? 1 : 0));
    }
}
