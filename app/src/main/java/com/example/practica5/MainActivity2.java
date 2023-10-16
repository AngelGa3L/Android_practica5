package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import com.example.practica5.models.celsius;
import com.example.practica5.models.farentheit;
import com.example.practica5.models.kelvin;
import com.example.practica5.models.grado;



public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Spinner spi;
    private TextView tv1,tv2;
    private EditText et1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spi = findViewById(R.id.spinner);
        tv1 = findViewById(R.id.titulo);
        tv2 = findViewById(R.id.resultado);
        et1 = findViewById(R.id.temperatura);
        btn1 = findViewById(R.id.convertir);

        celsius c = new celsius(0.0);
        farentheit f = new farentheit(0.0);
        kelvin k = new kelvin(0.0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.grados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adapter);

        btn1.setOnClickListener(this);

    }
    public void onClick(View view){
        if (view == btn1){
            convertirTemperatura();
        }
    }
    private void convertirTemperatura() {
        double temperaturaCelsius = Double.parseDouble(et1.getText().toString());
        double temperaturaFahrenheitK = Double.parseDouble(et1.getText().toString());
        String unidadSeleccionada = spi.getSelectedItem().toString();

        if (unidadSeleccionada.equals("De Celsius a Kelvin")) {
            double temperaturaKelvin = celsiuskelvin(temperaturaCelsius);
            tv2.setText("Temperatura en Kelvin: " + temperaturaKelvin + "K");
        } else if (unidadSeleccionada.equals("De Celsius a Fahrenheit")) {
            double temperaturaFahrenheit = celsiusfahrenheit(temperaturaCelsius);
            tv2.setText("Temperatura en Fahrenheit: " + temperaturaFahrenheit + "°F");
        } else if (unidadSeleccionada.equals("De Fahrenheit a Kelvin")) {
            double temperaturaFahreKelvin = farhrenheitKelvin(temperaturaFahrenheitK);
            tv2.setText("Temperatura en Kelvin: " + temperaturaFahreKelvin + "K");
        }
    }
    private double celsiusfahrenheit(double celsius) {
        return celsius * 9/5 + 32;
    }

    private double celsiuskelvin(double celsius) {
        return celsius + 273.15;
    }
    private double farhrenheitKelvin(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = celsius + 273.15;
        return kelvin;
    }
}