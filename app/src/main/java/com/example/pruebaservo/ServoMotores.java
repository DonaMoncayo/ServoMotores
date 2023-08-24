package com.example.pruebaservo;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.*;
import com.example.hp.bluetoothjhr.BluetoothJhr;

public class ServoMotores extends AppCompatActivity  {

    BluetoothJhr bluetoothJhr;
    SeekBar Grados, Grados1;
    TextView Textogrado, Textogrado1;

    Button noventa, cientochenta,cero, noventa1, cientochenta1,cero1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servo_motores);
        bluetoothJhr = new BluetoothJhr(MainActivity.class,this);

        Grados = (SeekBar) findViewById(R.id.xsb1);
        Textogrado = (TextView) findViewById(R.id.xtvg1);

        Grados1 = (SeekBar) findViewById(R.id.xsb2);
        Textogrado1 = (TextView) findViewById(R.id.xtvg2);

        noventa = (Button)findViewById(R.id.noventa);
        cientochenta = (Button)findViewById(R.id.cienochenta);
        cero = (Button)findViewById(R.id.cero);

        noventa1 = (Button)findViewById(R.id.noventa1);
        cientochenta1 = (Button)findViewById(R.id.cienochenta1);
        cero1 = (Button)findViewById(R.id.cero1);


        int seekBarMax = 180;
        int seekBarMid = seekBarMax / 2;

        Grados.setMax(seekBarMax);
        Grados.setProgress(seekBarMid);

        Grados1.setMax(seekBarMax);
        Grados1.setProgress(seekBarMid);


        Grados.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String GradosTexto = String.valueOf(progress);
                bluetoothJhr.Tx("v"+GradosTexto);
                Textogrado.setText("Grados = "+GradosTexto);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(seekBarMid);
                bluetoothJhr.Tx("r");
            }
        });

        Grados1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String GradosTexto = String.valueOf(progress);
                bluetoothJhr.Tx("h"+GradosTexto);
                Textogrado1.setText("Grados = "+GradosTexto);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(seekBarMid);
                bluetoothJhr.Tx("f");
            }
        });


        noventa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr.Tx("n");
                Textogrado.setText("Grados = "+90);
                // Acciones a realizar cuando se presiona el botón
                //Toast.makeText(MainActivity.this, "¡Botón presionado!", Toast.LENGTH_SHORT).show();
            }
        });

        cientochenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr.Tx("c");
                Textogrado.setText("Grados = "+180);
                // Acciones a realizar cuando se presiona el botón
                //Toast.makeText(MainActivity.this, "¡Botón presionado!", Toast.LENGTH_SHORT).show();
            }
        });

        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr.Tx("z");
                Textogrado.setText("Grados = "+0);
                // Acciones a realizar cuando se presiona el botón
                //Toast.makeText(MainActivity.this, "¡Botón presionado!", Toast.LENGTH_SHORT).show();
            }
        });



        noventa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr.Tx("a");
                Textogrado1.setText("Grados = "+90);
                // Acciones a realizar cuando se presiona el botón
                //Toast.makeText(MainActivity.this, "¡Botón presionado!", Toast.LENGTH_SHORT).show();
            }
        });

        cientochenta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr.Tx("e");
                Textogrado1.setText("Grados = "+180);
                // Acciones a realizar cuando se presiona el botón
                //Toast.makeText(MainActivity.this, "¡Botón presionado!", Toast.LENGTH_SHORT).show();
            }
        });

        cero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr.Tx("i");
                Textogrado1.setText("Grados = "+0);
                // Acciones a realizar cuando se presiona el botón
                //Toast.makeText(MainActivity.this, "¡Botón presionado!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
        bluetoothJhr.ConectaBluetooth();
    }

    @Override
    public void onPause(){
        super.onPause();
        bluetoothJhr.CierraConexion();
    }
}