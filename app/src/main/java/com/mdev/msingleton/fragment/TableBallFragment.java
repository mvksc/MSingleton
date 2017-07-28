package com.mdev.msingleton.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mdev.msingleton.BuildConfig;
import com.mdev.msingleton.R;
import com.mdev.msingleton.Util.Util;
import com.mdev.msingleton.manager.AllCommand;
import com.mdev.msingleton.manager.FTSingleton;
import com.mdev.msingleton.manager.HTSingleton;
import com.mdev.msingleton.manager.IxIISingleton;
import com.mdev.msingleton.model.ModelDataBall;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class TableBallFragment extends Fragment{
    private AllCommand allCommand;
    private ViewPager viewPager;
    private List<ModelDataBall> dataSetFT,dataSetHT,dataSet1x2;
    private List<String> nameLeagueFT,nameLeagueHT,nameLeague1x2;

    public TableBallFragment() {}

    public static TableBallFragment newInstance() {
        TableBallFragment fragment = new TableBallFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSetFT = new ArrayList<>();
        nameLeagueFT = new ArrayList<>();
        dataSetHT = new ArrayList<>();
        nameLeagueHT = new ArrayList<>();
        dataSet1x2 = new ArrayList<>();
        nameLeague1x2 = new ArrayList<>();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_table_ball, container, false);
        initView(rootView);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {

                return Util.DATA_BALL;
            }

            @Override
            protected void onPostExecute(String s) {
                onSetDataToListFirst(s);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0: return FTFragment.newInstance();
                    case 1: return HTFragment.newInstance();
                    case 2: return IxIIFragment.newInstance();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FTSingleton.getInstance().clear();
        HTSingleton.getInstance().clear();
        IxIISingleton.getInstance().clear();
    }

    private void onSetDataToListFirst(String data) {
        try {
            JSONObject jObject;
            JSONArray jArray = new JSONArray(allCommand.CoverStringFromServer_Two(data));
            for (int i = 0; i < jArray.length(); i++) {
                jObject = jArray.getJSONObject(i);
                String leagName = jObject.getString("League").toString().trim();
                String HF = jObject.getString("HF").toString().trim();//1 คือ 1H, 2 คือ FT ที่เหลือ 1x2
                //add league all
                if (HF.toString().trim().equals("1")){//1H
                    if (jObject.getString("Hdc").toString().trim().length() > 0 &&
                            jObject.getString("Hdc1").toString().trim().length() > 0 &&
                            jObject.getString("Hdc2").toString().trim().length() > 0 ||
                            jObject.getString("Goal").toString().trim().length() > 0 &&
                            jObject.getString("Goal1").toString().trim().length() > 0 &&
                            jObject.getString("Goal2").toString().trim().length() > 0) {
                        if (!nameLeagueHT.contains(leagName)) {
                            nameLeagueHT.add(leagName);
                            ModelDataBall modelDataTitle = new ModelDataBall();
                            modelDataTitle.setLeague(leagName);
                            modelDataTitle.setTypeContent(0);
                            dataSetHT.add(modelDataTitle);
                        }
                        ModelDataBall modelData = new ModelDataBall();
                        modelData.setLeague(jObject.getString("League").toString().trim());
                        modelData.setBallID(jObject.getString("BallID").toString());
                        modelData.setTeam1(jObject.getString("Team1").toString().trim());
                        modelData.setTeam2(jObject.getString("Team2").toString().trim());
                        modelData.setPlay_Time(jObject.getString("Play_Time").toString().trim());
                        modelData.setPlay_Score(jObject.getString("Play_Score").toString().trim());
                        modelData.setHdc(jObject.getString("Hdc").toString().trim());
                        modelData.setRedCard1((jObject.isNull("Red1")) ? "0" : jObject.getString("Red1").toString().trim());
                        modelData.setRedCard2((jObject.isNull("Red2")) ? "0" : jObject.getString("Red2").toString().trim());
                        modelData.setHdc1(jObject.getString("Hdc1").toString().trim());
                        modelData.setHdc2(jObject.getString("Hdc2").toString().trim());
                        modelData.setGoal(jObject.getString("Goal").toString().trim());
                        modelData.setGoal1(jObject.getString("Goal1").toString().trim());
                        modelData.setGoal2(jObject.getString("Goal2").toString().trim());
                        modelData.setBig(jObject.getString("Big").toString().trim());
                        modelData.setHF(jObject.getString("HF").toString().trim());//1 คือ 1H, 2 คือ FT ที่เหลือ 1x2
                        modelData.setAdd(jObject.getString("ADD").toString().trim());
                        modelData.setClickNo(0);
                        modelData.setSubTypeTangBall(getResources().getString(R.string.SUB_TYPE_TANG_STEP_BALL_1H));
                        modelData.setNo1(jObject.getString("No1").toString().trim());
                        modelData.setNo2(jObject.getString("No2").toString().trim());
                        modelData.setNo3(jObject.getString("No3").toString().trim());
                        modelData.setNo4(jObject.getString("No4").toString().trim());
                        modelData.setFlash1(false);
                        modelData.setFlash2(false);
                        modelData.setFlash3(false);
                        modelData.setFlash4(false);
                        modelData.setTypeContent(1);//Table Ball
                        dataSetHT.add(modelData);
                    }
                }else if (HF.toString().trim().equals("2")){//FT
                    if (jObject.getString("Hdc").toString().trim().length() > 0 &&
                            jObject.getString("Hdc1").toString().trim().length() > 0 &&
                            jObject.getString("Hdc2").toString().trim().length() > 0 ||
                            jObject.getString("Goal").toString().trim().length() > 0 &&
                                    jObject.getString("Goal1").toString().trim().length() > 0 &&
                                    jObject.getString("Goal2").toString().trim().length() > 0) {
                        if (!nameLeagueFT.contains(leagName)) {
                            nameLeagueFT.add(leagName);
                            ModelDataBall modelDataTitle = new ModelDataBall();
                            modelDataTitle.setLeague(leagName);
                            modelDataTitle.setTypeContent(0);
                            dataSetFT.add(modelDataTitle);
                        }
                        ModelDataBall modelData = new ModelDataBall();
                        modelData.setLeague(jObject.getString("League").toString().trim());
                        modelData.setBallID(jObject.getString("BallID").toString());
                        modelData.setTeam1(jObject.getString("Team1").toString().trim());
                        modelData.setTeam2(jObject.getString("Team2").toString().trim());
                        modelData.setPlay_Time(jObject.getString("Play_Time").toString().trim());
                        modelData.setPlay_Score(jObject.getString("Play_Score").toString().trim());
                        modelData.setHdc(jObject.getString("Hdc").toString().trim());
                        modelData.setRedCard1((jObject.isNull("Red1")) ? "0" : jObject.getString("Red1").toString().trim());
                        modelData.setRedCard2((jObject.isNull("Red2")) ? "0" : jObject.getString("Red2").toString().trim());
                        modelData.setHdc1(jObject.getString("Hdc1").toString().trim());
                        modelData.setHdc2(jObject.getString("Hdc2").toString().trim());
                        modelData.setGoal(jObject.getString("Goal").toString().trim());
                        modelData.setGoal1(jObject.getString("Goal1").toString().trim());
                        modelData.setGoal2(jObject.getString("Goal2").toString().trim());
                        modelData.setBig(jObject.getString("Big").toString().trim());
                        modelData.setHF(jObject.getString("HF").toString().trim());//1 คือ 1H, 2 คือ FT ที่เหลือ 1x2
                        modelData.setAdd(jObject.getString("ADD").toString().trim());
                        modelData.setClickNo(0);
                        modelData.setSubTypeTangBall(getResources().getString(R.string.SUB_TYPE_TANG_STEP_BALL_FT));
                        modelData.setNo1(jObject.getString("No1").toString().trim());
                        modelData.setNo2(jObject.getString("No2").toString().trim());
                        modelData.setNo3(jObject.getString("No3").toString().trim());
                        modelData.setNo4(jObject.getString("No4").toString().trim());
                        modelData.setFlash1(false);
                        modelData.setFlash2(false);
                        modelData.setFlash3(false);
                        modelData.setFlash4(false);
                        modelData.setTypeContent(1);//Table Ball
                        dataSetFT.add(modelData);
                    }
                }

                if (jObject.getString("X1").toString().trim().length() > 0 &&
                     jObject.getString("XX").toString().trim().length() > 0 &&
                     jObject.getString("X2").toString().trim().length() > 0 ||
                     jObject.getString("Odd").toString().trim().length() > 0 &&
                     jObject.getString("Even").toString().trim().length() > 0){

                    if (!nameLeague1x2.contains(leagName)) {
                        nameLeague1x2.add(leagName);
                        ModelDataBall modelDataTitle = new ModelDataBall();
                        modelDataTitle.setLeague(leagName);
                        modelDataTitle.setTypeContent(0);
                        dataSet1x2.add(modelDataTitle);
                    }
                    ModelDataBall modelData1x2 = new ModelDataBall();
                    modelData1x2.setLeague(jObject.getString("League").toString().trim());
                    modelData1x2.setBallID(jObject.getString("BallID").toString());
                    modelData1x2.setTeam1(jObject.getString("Team1").toString().trim());
                    modelData1x2.setTeam2(jObject.getString("Team2").toString().trim());
                    modelData1x2.setPlay_Time(jObject.getString("Play_Time").toString().trim());
                    modelData1x2.setPlay_Score(jObject.getString("Play_Score").toString().trim());
                    modelData1x2.setHdc(jObject.getString("Hdc").toString().trim());
                    modelData1x2.setRedCard1((jObject.isNull("Red1")) ? "0" : jObject.getString("Red1").toString().trim());
                    modelData1x2.setRedCard2((jObject.isNull("Red2")) ? "0" : jObject.getString("Red2").toString().trim());
                    modelData1x2.setHdc1(jObject.getString("Hdc1").toString().trim());
                    modelData1x2.setHdc2(jObject.getString("Hdc2").toString().trim());
                    modelData1x2.setGoal(jObject.getString("Goal").toString().trim());
                    modelData1x2.setGoal1(jObject.getString("Goal1").toString().trim());
                    modelData1x2.setGoal2(jObject.getString("Goal2").toString().trim());
                    modelData1x2.setBig(jObject.getString("Big").toString().trim());
                    modelData1x2.setHF(jObject.getString("HF").toString().trim());//1 คือ 1H, 2 คือ FT ที่เหลือ 1x2
                    modelData1x2.setAdd(jObject.getString("ADD").toString().trim());
                    modelData1x2.setClickNo(0);
                    modelData1x2.setSubTypeTangBall(getResources().getString(R.string.SUB_TYPE_TANG_STEP_BALL_1X2));
                    modelData1x2.setNo1(jObject.getString("No5").toString().trim());
                    modelData1x2.setNo2(jObject.getString("No6").toString().trim());
                    modelData1x2.setNo3(jObject.getString("No7").toString().trim());
                    modelData1x2.setNo4(jObject.getString("No8").toString().trim());
                    modelData1x2.setNo5(jObject.getString("No9").toString().trim());
                    modelData1x2.setFlash1(false);
                    modelData1x2.setFlash2(false);
                    modelData1x2.setFlash3(false);
                    modelData1x2.setFlash4(false);
                    modelData1x2.setFlash5(false);
                    modelData1x2.setPriceTeam1(jObject.getString("X1").toString().trim());
                    modelData1x2.setPriceAye(jObject.getString("XX").toString().trim());
                    modelData1x2.setPriceTeam2(jObject.getString("X2").toString().trim());
                    modelData1x2.setOdd(jObject.getString("Odd").toString().trim());
                    modelData1x2.setEven(jObject.getString("Even").toString().trim());
                    modelData1x2.setTypeContent(2);//Table 1x2
                    dataSet1x2.add(modelData1x2);
                }
            }
            FTSingleton.getInstance().setDataBall(dataSetFT);
            HTSingleton.getInstance().setDataBall(dataSetHT);
            IxIISingleton.getInstance().setDataBall(dataSet1x2);
        } catch (Exception e) {
            ShowLogCat("Err", "getDataSet " + e.getMessage());
        }
    }
    private void initView(View rootView) {
        allCommand = new AllCommand();
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPagerTable);
    }
    public void ShowLogCat(String tag, String msg){
        if (BuildConfig.DEBUG) {
            Log.e("***TableBall***",tag +" ==> "+ msg);
        }
    }
}
