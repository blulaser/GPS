package com.example.administrator.gps;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class Service2 extends Service {
    Location location;
    protected LocationManager locationManager;

    private GPS gps2;
    private boolean isStop;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private  Context mContext;
    double lat1;
    double lon1;
    Location locationA = new Location("point A");
    double distance;
    Location locationB = new Location("point B");

    // 최소 GPS 정보 업데이트 시간 밀리세컨이므로 1분

    private static final long MIN_TIME_BW_UPDATES = 1000 * 5 * 1;

    @Override
    public IBinder onBind(Intent intent) {
        // Service 객체와 (화면단 Activity 사이에서)
        // 통신(데이터를 주고받을) 때 사용하는 메서드
        // 데이터를 전달할 필요가 없으면 return null;
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        isStop=false;
        gps2 = new GPS(this);

        mContext = this;
        Log.d("test", "서비스의 onCreate");
        Thread counter = new Thread(new Counter()); counter.start();
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);








    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    private class  Counter implements Runnable { private int count; private Handler handler = new Handler(); @Override public void run() { for (count = 0; count < 5; count++) { // STOP 버튼을 눌렀다면 종료한다.

        if (isStop) { break; } /** * Thread 안에서는 UI와 관련된 Toast를 쓸 수 없습니다. * 따라서, Handler를 통해 이용할 수 있도록 만들어줍니다. */
        handler.post(new Runnable() { @Override public void run() {
            // Toast로 Count 띄우기


                if(count==0) {
                    lat1 = gps2.lat;
                    lon1 = gps2.lon;
                    locationA.setLatitude(lat1);
                    locationA.setLongitude(lon1);
                }



            locationB.setLatitude(gps2.lat);
            locationB.setLongitude(gps2.lon);

            distance = locationA.distanceTo(locationB);
                if(distance<100) {
                    Toast.makeText(getApplicationContext(), distance + "m," + gps2.lat + "," + gps2.lon + " "+lat1+","+lon1, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "#"+distance + "m," + gps2.lat + "," + gps2.lon + " "+lat1+","+lon1, Toast.LENGTH_SHORT).show();
                   isStop=true;
                }
                if(count==4)
                {
                    //TODO 저장할건지 호출하는거 넣는위치
                }

            // Log로 Count 찍어보기
            Log.d("COUNT,", count + ""); } });
        // Sleep을 통해 1초씩 쉬도록 한다.
        try { Thread.sleep(1000*30); } catch (InterruptedException e) { e.printStackTrace(); } } handler.post(new Runnable() { @Override public void run() { Toast.makeText(getApplicationContext(), "서비스가 종료되었습니다.", Toast.LENGTH_SHORT).show(); } }); } }




    @Override
    public void onDestroy() {


        Log.d("test", "서비스의 onDestroy");
        super.onDestroy();
        isStop = true;
        // 서비스가 종료될 때 실행
    }










}
