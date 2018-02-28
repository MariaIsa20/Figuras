package com.isabel.figuras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eValor1, eValor2, eValor3;
    TextView tResultado;
    RadioButton rCirculo, rTriangulo, rCuadrado, rCubo;
    String S1, S2, S3;
    Button bCalcular;
    Float valor1, valor2, valor3;
    ImageView Iimagen;
    double perimetro, area, volumen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eValor1 = findViewById(R.id.eValor1);
        eValor2 = findViewById(R.id.eValor2);
        eValor3 = findViewById(R.id.eValor3);

        tResultado = findViewById(R.id.tResultado);

        rCirculo = findViewById(R.id.rCirculo);
        rTriangulo = findViewById(R.id.rTriangulo);
        rCuadrado = findViewById(R.id.rCuadrado);
        rCubo = findViewById(R.id.rCubo);

        bCalcular = findViewById(R.id.bcalcular);

        Iimagen = findViewById(R.id.Iimagen);

        eValor1.setEnabled(false);
        eValor2.setEnabled(false);
        eValor3.setEnabled(false);


    }

    public void onRadioButtonClicked(View view) {

        eValor1.setEnabled(false);
        eValor2.setEnabled(false);
        eValor3.setEnabled(false);


        int id = view.getId();

        switch (id) {

            case R.id.rCirculo:
                eValor1.setText(null);
                eValor2.setHint(null);
                eValor3.setHint(null);
                eValor1.setHint("Ingrese el radio");
                eValor1.setEnabled(true);


                break;

            case R.id.rTriangulo:
                eValor1.setText(null);
                eValor2.setText(null);
                eValor3.setText(null);
                eValor2.setHint(null);
                eValor3.setHint(null);
                eValor1.setHint("Ingrese lado 1");
                eValor1.setEnabled(true);
                eValor2.setHint("Ingrese lado 2");
                eValor2.setEnabled(true);
                eValor3.setHint("Ingrese lado 3");
                eValor3.setEnabled(true);
                break;

            case R.id.rCuadrado:
                eValor1.setText(null);
                eValor2.setHint(null);
                eValor3.setHint(null);
                eValor1.setHint("Ingrese el lado");
                eValor1.setEnabled(true);
                break;

            case R.id.rCubo:
                eValor1.setText(null);
                eValor2.setHint(null);
                eValor3.setHint(null);
                eValor1.setHint("Ingrese el lado");
                eValor1.setEnabled(true);
                break;


        }


    }


    public void calcular(View view) {

        int id = view.getId();

        if (id == R.id.bcalcular) {
            S1 = eValor1.getText().toString();
            S2 = eValor2.getText().toString();
            S3 = eValor3.getText().toString();




            if (rCirculo.isChecked()) {

                if (S1.isEmpty() ) {

                    //esta vacio
                    tResultado.setText("Campo vacío");

                }else {

                    valor1 = Float.parseFloat(eValor1.getText().toString());
                    perimetro = 2 * valor1 * Math.PI;
                    area = Math.pow(valor1, 2) * Math.PI;

                    tResultado.setText("Perimetro=" + (String.format("%.2f", perimetro)) + "cm" + "\n" + "Area=" + (String.format("%.2f", area)) + "cm^2");


                    Iimagen.setImageResource(R.drawable.circulo);
                }

                }
            else if (rTriangulo.isChecked()) {

                if (S1.isEmpty() || S2.isEmpty() || S3.isEmpty() ) {

                    //esta vacio
                    tResultado.setText("Campo vacío");

                }else {

                    valor1 = Float.parseFloat(eValor1.getText().toString());
                    valor2 = Float.parseFloat(eValor2.getText().toString());
                    valor3 = Float.parseFloat(eValor3.getText().toString());

                    perimetro = valor1 + valor2 + valor3;
                    area = Math.sqrt((0.5 * perimetro) * (0.5 * perimetro - valor1) * (0.5 * perimetro - valor2) * (0.5 * perimetro - valor3)); // Formula de Herón

                    tResultado.setText("Perimetro=" + (String.format("%.2f", perimetro)) + "cm" + "\n" + "Area=" + (String.format("%.2f", area)) + "cm^2");

                    Iimagen.setImageResource(R.drawable.triangulo);
                }
                }
            else if (rCuadrado.isChecked()) {

                if (S1.isEmpty()  ) {

                    //esta vacio
                    tResultado.setText("Campo vacío");

                }else {
                    valor1 = Float.parseFloat(eValor1.getText().toString());

                    perimetro = 4 * valor1;
                    area = valor1 * valor1;

                    tResultado.setText("Perimetro=" + (String.format("%.2f", perimetro)) + "cm" + "\n" + "Area=" + (String.format("%.2f", area)) + "cm^2");

                    Iimagen.setImageResource(R.drawable.cuadrado);
                }

                }
            else if (rCubo.isChecked()) {

                if (S1.isEmpty() ) {

                    //esta vacio
                    tResultado.setText("Campo vacío");

                }else {
                    valor1 = Float.parseFloat(eValor1.getText().toString());

                    perimetro = 12 * valor1;
                    area = 6 * valor1 * valor1;
                    volumen = valor1 * valor1 * valor1;
                    tResultado.setText("Perimetro=" + (String.format("%.2f", perimetro)) + "cm" + "\n" + "Area=" + (String.format("%.2f", area)) + "cm^2" + "\n" +
                            "Volumen=" + (String.format("%.2f", volumen)) + "cm^3");

                    Iimagen.setImageResource(R.drawable.cubo);
                }

                }



        }
    }
}
