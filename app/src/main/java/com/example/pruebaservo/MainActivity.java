package com.example.pruebaservo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.bluetoothjhr.BluetoothJhr;

public class MainActivity extends AppCompatActivity {

    ListView Dispositivos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dispositivos = (ListView) findViewById(R.id.dispositivos);
        final BluetoothJhr bluetoothJhr = new BluetoothJhr(this,Dispositivos);
        bluetoothJhr.EncenderBluetooth();

        Dispositivos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bluetoothJhr.Disp_Seleccionado(view,position,ServoMotores.class);
            }
        });
    }
}