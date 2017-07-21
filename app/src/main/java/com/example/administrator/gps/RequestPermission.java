package com.example.administrator.gps;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


public class RequestPermission extends AppCompatActivity {
    public final int  MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;
    public final int  MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 2;




    void ReqPer(Activity A){


    int permissionCheck = ContextCompat.checkSelfPermission(A, Manifest.permission.ACCESS_COARSE_LOCATION);

        if (permissionCheck == PackageManager.PERMISSION_DENIED) {

        // 권한 없음
    } else {
        // 권한 있음
    }






    if (ContextCompat.checkSelfPermission(A, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // 이 권한을 필요한 이유를 설명해야하는가?
            if (ActivityCompat.shouldShowRequestPermissionRationale(A, Manifest.permission.ACCESS_COARSE_LOCATION)) {

                // 다이어로그같은것을 띄워서 사용자에게 해당 권한이 필요한 이유에 대해 설명합니다

                // 해당 설명이 끝난뒤 requestPermissions()함수를 호출하여 권한허가를 요청해야 합니다

            } else {

                ActivityCompat.requestPermissions(A,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);

                // 필요한 권한과 요청 코드를 넣어서 권한허가요청에 대한 결과를 받아야 합니다

            }
        }
        int permissionCheck2 = ContextCompat.checkSelfPermission(A, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck2 == PackageManager.PERMISSION_DENIED) {

            // 권한 없음
        } else {
            // 권한 있음
        }





        if (ContextCompat.checkSelfPermission(A, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // 이 권한을 필요한 이유를 설명해야하는가?
            if (ActivityCompat.shouldShowRequestPermissionRationale(A, Manifest.permission.ACCESS_FINE_LOCATION)) {

                // 다이어로그같은것을 띄워서 사용자에게 해당 권한이 필요한 이유에 대해 설명합니다

                // 해당 설명이 끝난뒤 requestPermissions()함수를 호출하여 권한허가를 요청해야 합니다

            } else {

                ActivityCompat.requestPermissions(A,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

                // 필요한 권한과 요청 코드를 넣어서 권한허가요청에 대한 결과를 받아야 합니다

            }
        }

    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION:

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 권한 허가
                    // 해당 권한을 사용해서 작업을 진행할 수 있습니다
                } else {
                    // 권한 거부
                    // 사용자가 해당권한을 거부했을때 해주어야 할 동작을 수행합니다
                }
                return;
            case MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION:

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 권한 허가
                    // 해당 권한을 사용해서 작업을 진행할 수 있습니다
                } else {
                    // 권한 거부
                    // 사용자가 해당권한을 거부했을때 해주어야 할 동작을 수행합니다
                }
                return;
        }
    }


}
