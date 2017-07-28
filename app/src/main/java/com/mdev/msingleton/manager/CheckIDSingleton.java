package com.mdev.msingleton.manager;

import com.mdev.msingleton.model.ModelDataBall;
import com.mdev.msingleton.model.ModelDataTang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHUNTONGDANG on 27/7/2560.
 */

public class CheckIDSingleton {
    public static CheckIDSingleton CheckIDSingleton;
    private List<ModelDataBall> dataSetFT,dataSetHT,dataSet1x2;
    private List<ModelDataTang> dataTang;
    public static CheckIDSingleton getInstance(){
        if (CheckIDSingleton == null){
            CheckIDSingleton = new CheckIDSingleton();
        }
        return CheckIDSingleton;
    }
    public CheckIDSingleton(){
        if (this.dataTang == null){
            this.dataTang = new ArrayList<>();
        }
    }
    public void onCheckIdTang(int page,int position,String add,String no, int subClick, String subTypeTangBall,String billID,String playStep){
        dataSetFT = FTSingleton.getInstance().getDataBall();
        dataSetHT = HTSingleton.getInstance().getDataBall();
        dataSet1x2 = IxIISingleton.getInstance().getDataBall();

        ModelDataTang modelTang = new ModelDataTang();
        modelTang.setNo(no);
        modelTang.setTypeTang(subTypeTangBall);
        modelTang.setPositionTang(position);
        modelTang.setBillID(billID);
        modelTang.setADD(add);
        modelTang.setPlayStep(playStep);

        int indexBillTang = onCheckIdBillTang(billID);

        if (indexBillTang < 0){
            dataTang.add(modelTang);
        }else {
            if (page == 1){
                if (dataSetFT.get(position).getClickNo() == subClick){
                    dataTang.remove(indexBillTang);
                }else {
                    dataTang.set(indexBillTang,modelTang);
                }
            }else if (page == 2){
                if (dataSetHT.get(position).getClickNo() == subClick){
                    dataTang.remove(indexBillTang);
                }else {
                    dataTang.set(indexBillTang,modelTang);
                }
            }else if (page == 3){
                if (dataSet1x2.get(position).getClickNo() == subClick){
                    dataTang.remove(indexBillTang);
                }else {
                    dataTang.set(indexBillTang,modelTang);
                }
            }
        }

        //แสดงสีเขียวเมื่อเลือกรายการแทง
        if (page == 1){
            ModelDataBall modelData = new ModelDataBall();
            modelData.setLeague(dataSetFT.get(position).getLeague());
            modelData.setBallID(dataSetFT.get(position).getBallID());
            modelData.setTeam1(dataSetFT.get(position).getTeam1());
            modelData.setTeam2(dataSetFT.get(position).getTeam2());
            modelData.setPlay_Time(dataSetFT.get(position).getPlay_Time());
            modelData.setPlay_Score(dataSetFT.get(position).getPlay_Score());
            modelData.setHdc(dataSetFT.get(position).getHdc());
            modelData.setRedCard1(dataSetFT.get(position).getRedCard1());
            modelData.setRedCard2(dataSetFT.get(position).getRedCard2());
            modelData.setHdc1(dataSetFT.get(position).getHdc1());
            modelData.setHdc2(dataSetFT.get(position).getHdc2());
            modelData.setGoal(dataSetFT.get(position).getGoal());
            modelData.setGoal1(dataSetFT.get(position).getGoal1());
            modelData.setGoal2(dataSetFT.get(position).getGoal2());
            modelData.setBig(dataSetFT.get(position).getBig());
            modelData.setHF(dataSetFT.get(position).getHF());
            modelData.setAdd(dataSetFT.get(position).getAdd());
            modelData.setNo1(dataSetFT.get(position).getNo1());
            modelData.setNo2(dataSetFT.get(position).getNo2());
            modelData.setNo3(dataSetFT.get(position).getNo3());
            modelData.setNo4(dataSetFT.get(position).getNo4());
            modelData.setFlash1(dataSetFT.get(position).isFlash1());
            modelData.setFlash2(dataSetFT.get(position).isFlash2());
            modelData.setFlash3(dataSetFT.get(position).isFlash3());
            modelData.setFlash4(dataSetFT.get(position).isFlash4());
            if (dataSetFT.get(position).getClickNo() == subClick){
                modelData.setClickNo(0);
            }else {
                modelData.setClickNo(subClick);
            }
            modelData.setSubTypeTangBall(dataSetFT.get(position).getSubTypeTangBall());
            modelData.setTypeContent(2);//Table Ball
            dataSetFT.set(position,modelData);
        }else if (page == 2){
            ModelDataBall modelData = new ModelDataBall();
            modelData.setLeague(dataSetHT.get(position).getLeague());
            modelData.setBallID(dataSetHT.get(position).getBallID());
            modelData.setTeam1(dataSetHT.get(position).getTeam1());
            modelData.setTeam2(dataSetHT.get(position).getTeam2());
            modelData.setPlay_Time(dataSetHT.get(position).getPlay_Time());
            modelData.setPlay_Score(dataSetHT.get(position).getPlay_Score());
            modelData.setHdc(dataSetHT.get(position).getHdc());
            modelData.setRedCard1(dataSetHT.get(position).getRedCard1());
            modelData.setRedCard2(dataSetHT.get(position).getRedCard2());
            modelData.setHdc1(dataSetHT.get(position).getHdc1());
            modelData.setHdc2(dataSetHT.get(position).getHdc2());
            modelData.setGoal(dataSetHT.get(position).getGoal());
            modelData.setGoal1(dataSetHT.get(position).getGoal1());
            modelData.setGoal2(dataSetHT.get(position).getGoal2());
            modelData.setBig(dataSetHT.get(position).getBig());
            modelData.setHF(dataSetHT.get(position).getHF());
            modelData.setAdd(dataSetHT.get(position).getAdd());
            modelData.setNo1(dataSetHT.get(position).getNo1());
            modelData.setNo2(dataSetHT.get(position).getNo2());
            modelData.setNo3(dataSetHT.get(position).getNo3());
            modelData.setNo4(dataSetHT.get(position).getNo4());
            modelData.setFlash1(dataSetHT.get(position).isFlash1());
            modelData.setFlash2(dataSetHT.get(position).isFlash2());
            modelData.setFlash3(dataSetHT.get(position).isFlash3());
            modelData.setFlash4(dataSetHT.get(position).isFlash4());
            if (dataSetHT.get(position).getClickNo() == subClick){
                modelData.setClickNo(0);
            }else {
                modelData.setClickNo(subClick);
            }
            modelData.setSubTypeTangBall(dataSetHT.get(position).getSubTypeTangBall());
            modelData.setTypeContent(2);//Table Ball
            dataSetHT.set(position,modelData);
        }else if (page == 3){
            ModelDataBall modelData = new ModelDataBall();
            modelData.setLeague(dataSet1x2.get(position).getLeague());
            modelData.setBallID(dataSet1x2.get(position).getBallID());
            modelData.setTeam1(dataSet1x2.get(position).getTeam1());
            modelData.setTeam2(dataSet1x2.get(position).getTeam2());
            modelData.setPlay_Time(dataSet1x2.get(position).getPlay_Time());
            modelData.setPlay_Score(dataSet1x2.get(position).getPlay_Score());
            modelData.setHdc(dataSet1x2.get(position).getHdc());
            modelData.setRedCard1(dataSet1x2.get(position).getRedCard1());
            modelData.setRedCard2(dataSet1x2.get(position).getRedCard2());
            modelData.setHdc1(dataSet1x2.get(position).getHdc1());
            modelData.setHdc2(dataSet1x2.get(position).getHdc2());
            modelData.setGoal(dataSet1x2.get(position).getGoal());
            modelData.setGoal1(dataSet1x2.get(position).getGoal1());
            modelData.setGoal2(dataSet1x2.get(position).getGoal2());
            modelData.setBig(dataSet1x2.get(position).getBig());
            modelData.setHF(dataSet1x2.get(position).getHF());
            modelData.setAdd(dataSet1x2.get(position).getAdd());
            modelData.setNo1(dataSet1x2.get(position).getNo1());
            modelData.setNo2(dataSet1x2.get(position).getNo2());
            modelData.setNo3(dataSet1x2.get(position).getNo3());
            modelData.setNo4(dataSet1x2.get(position).getNo4());
            modelData.setFlash1(dataSet1x2.get(position).isFlash1());
            modelData.setFlash2(dataSet1x2.get(position).isFlash2());
            modelData.setFlash3(dataSet1x2.get(position).isFlash3());
            modelData.setFlash4(dataSet1x2.get(position).isFlash4());
            if (dataSet1x2.get(position).getClickNo() == subClick){
                modelData.setClickNo(0);
            }else {
                modelData.setClickNo(subClick);
            }
            modelData.setSubTypeTangBall(dataSet1x2.get(position).getSubTypeTangBall());
            modelData.setTypeContent(2);//Table Ball
            dataSet1x2.set(position,modelData);
        }

        //เคียร์สีเขียวเมื่อยกเลิกรายการแทง
        if (page != 1 && indexBillTang > -1){
            ModelDataBall modelData = new ModelDataBall();
            modelData.setLeague(dataSetFT.get(position).getLeague());
            modelData.setBallID(dataSetFT.get(position).getBallID());
            modelData.setTeam1(dataSetFT.get(position).getTeam1());
            modelData.setTeam2(dataSetFT.get(position).getTeam2());
            modelData.setPlay_Time(dataSetFT.get(position).getPlay_Time());
            modelData.setPlay_Score(dataSetFT.get(position).getPlay_Score());
            modelData.setHdc(dataSetFT.get(position).getHdc());
            modelData.setRedCard1(dataSetFT.get(position).getRedCard1());
            modelData.setRedCard2(dataSetFT.get(position).getRedCard2());
            modelData.setHdc1(dataSetFT.get(position).getHdc1());
            modelData.setHdc2(dataSetFT.get(position).getHdc2());
            modelData.setGoal(dataSetFT.get(position).getGoal());
            modelData.setGoal1(dataSetFT.get(position).getGoal1());
            modelData.setGoal2(dataSetFT.get(position).getGoal2());
            modelData.setBig(dataSetFT.get(position).getBig());
            modelData.setHF(dataSetFT.get(position).getHF());
            modelData.setAdd(dataSetFT.get(position).getAdd());
            modelData.setNo1(dataSetFT.get(position).getNo1());
            modelData.setNo2(dataSetFT.get(position).getNo2());
            modelData.setNo3(dataSetFT.get(position).getNo3());
            modelData.setNo4(dataSetFT.get(position).getNo4());
            modelData.setFlash1(dataSetFT.get(position).isFlash1());
            modelData.setFlash2(dataSetFT.get(position).isFlash2());
            modelData.setFlash3(dataSetFT.get(position).isFlash3());
            modelData.setFlash4(dataSetFT.get(position).isFlash4());
            modelData.setClickNo(0);
            modelData.setSubTypeTangBall(dataSetFT.get(position).getSubTypeTangBall());
            modelData.setTypeContent(2);//Table Ball
            dataSetFT.set(position,modelData);
        }

        if (page != 2 && indexBillTang > -1){
            ModelDataBall modelData = new ModelDataBall();
            modelData.setLeague(dataSetHT.get(position).getLeague());
            modelData.setBallID(dataSetHT.get(position).getBallID());
            modelData.setTeam1(dataSetHT.get(position).getTeam1());
            modelData.setTeam2(dataSetHT.get(position).getTeam2());
            modelData.setPlay_Time(dataSetHT.get(position).getPlay_Time());
            modelData.setPlay_Score(dataSetHT.get(position).getPlay_Score());
            modelData.setHdc(dataSetHT.get(position).getHdc());
            modelData.setRedCard1(dataSetHT.get(position).getRedCard1());
            modelData.setRedCard2(dataSetHT.get(position).getRedCard2());
            modelData.setHdc1(dataSetHT.get(position).getHdc1());
            modelData.setHdc2(dataSetHT.get(position).getHdc2());
            modelData.setGoal(dataSetHT.get(position).getGoal());
            modelData.setGoal1(dataSetHT.get(position).getGoal1());
            modelData.setGoal2(dataSetHT.get(position).getGoal2());
            modelData.setBig(dataSetHT.get(position).getBig());
            modelData.setHF(dataSetHT.get(position).getHF());
            modelData.setAdd(dataSetHT.get(position).getAdd());
            modelData.setNo1(dataSetHT.get(position).getNo1());
            modelData.setNo2(dataSetHT.get(position).getNo2());
            modelData.setNo3(dataSetHT.get(position).getNo3());
            modelData.setNo4(dataSetHT.get(position).getNo4());
            modelData.setFlash1(dataSetHT.get(position).isFlash1());
            modelData.setFlash2(dataSetHT.get(position).isFlash2());
            modelData.setFlash3(dataSetHT.get(position).isFlash3());
            modelData.setFlash4(dataSetHT.get(position).isFlash4());
            modelData.setClickNo(0);
            modelData.setSubTypeTangBall(dataSetHT.get(position).getSubTypeTangBall());
            modelData.setTypeContent(2);//Table Ball
            dataSetHT.set(position,modelData);
        }

        if (page != 3 && indexBillTang > -1){
            ModelDataBall modelData = new ModelDataBall();
            modelData.setLeague(dataSet1x2.get(position).getLeague());
            modelData.setBallID(dataSet1x2.get(position).getBallID());
            modelData.setTeam1(dataSet1x2.get(position).getTeam1());
            modelData.setTeam2(dataSet1x2.get(position).getTeam2());
            modelData.setPlay_Time(dataSet1x2.get(position).getPlay_Time());
            modelData.setPlay_Score(dataSet1x2.get(position).getPlay_Score());
            modelData.setHdc(dataSet1x2.get(position).getHdc());
            modelData.setRedCard1(dataSet1x2.get(position).getRedCard1());
            modelData.setRedCard2(dataSet1x2.get(position).getRedCard2());
            modelData.setHdc1(dataSet1x2.get(position).getHdc1());
            modelData.setHdc2(dataSet1x2.get(position).getHdc2());
            modelData.setGoal(dataSet1x2.get(position).getGoal());
            modelData.setGoal1(dataSet1x2.get(position).getGoal1());
            modelData.setGoal2(dataSet1x2.get(position).getGoal2());
            modelData.setBig(dataSet1x2.get(position).getBig());
            modelData.setHF(dataSet1x2.get(position).getHF());
            modelData.setAdd(dataSet1x2.get(position).getAdd());
            modelData.setNo1(dataSet1x2.get(position).getNo1());
            modelData.setNo2(dataSet1x2.get(position).getNo2());
            modelData.setNo3(dataSet1x2.get(position).getNo3());
            modelData.setNo4(dataSet1x2.get(position).getNo4());
            modelData.setFlash1(dataSet1x2.get(position).isFlash1());
            modelData.setFlash2(dataSet1x2.get(position).isFlash2());
            modelData.setFlash3(dataSet1x2.get(position).isFlash3());
            modelData.setFlash4(dataSet1x2.get(position).isFlash4());
            modelData.setClickNo(0);
            modelData.setSubTypeTangBall(dataSet1x2.get(position).getSubTypeTangBall());
            modelData.setTypeContent(2);//Table Ball
            dataSet1x2.set(position,modelData);
        }

    }
    private int onCheckIdBillTang(String billID){
        for (int i = 0; i< dataTang.size(); i++){
            if (dataTang.get(i).getBillID().toString().equals(billID)){
                return i;
            }
        }
        return -1;
    }
    public List<ModelDataTang> getDataTang(){
        return this.dataTang;
    }
}
