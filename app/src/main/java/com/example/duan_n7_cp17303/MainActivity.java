package com.example.duan_n7_cp17303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.duan_n7_cp17303.Sqlserver.DbSqlServer;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbSqlServer dbSqlServer = new DbSqlServer();
        Connection conn = dbSqlServer.openConnect();
    }
}