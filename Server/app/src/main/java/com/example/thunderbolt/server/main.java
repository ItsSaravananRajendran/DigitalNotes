package com.example.thunderbolt.server;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thunderbolt.server.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Girish Bhalerao on 5/4/2017.
 */
public class main extends AppCompatActivity  {


    final Handler handler = new Handler();

    private TextView sc;
    private boolean end = false;
    private PrintWriter output;
    private  String send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = "";
        startServerSocket();


    }

    private void startServerSocket() {

        Thread thread = new Thread(new Runnable() {

            private String stringData = null;

            @Override
            public void run() {

                try {

                    ServerSocket ss = new ServerSocket(15120);

                    while (!end) {
                        //Server is waiting for client here, if needed
                        Socket s = ss.accept();
                        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        output = new PrintWriter(s.getOutputStream());

                        stringData = input.readLine();
                        output.println("FROM SERVER - " + stringData.toUpperCase());
                        output.flush();


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // MotionEvent object holds X-Y values
        if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            String loc = String.valueOf((int) event.getX()) +"+"+ String.valueOf((int) event.getY());
            send = send + "," + loc;

        }

        if (event.getAction() == MotionEvent.ACTION_UP){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                            output.println(send);
                            output.flush();
                            send = "";

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();
        }
        return super.onTouchEvent(event);
    }



}
