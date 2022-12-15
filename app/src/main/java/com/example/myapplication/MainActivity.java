package com.example.myapplication;

import static android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //VIEWS
    CheckBox cbMayusculas, cbRojo;
    EditText etLacteos, etFrutas, etBebidas;
    Button btLacteos, btFrutas, btBebidas;
    Spinner spLacteos, spFrutas, spBebidas;
    RadioButton radioAñadir1, radioAñadir2, radioAñadir3, radioBorrar1, radioBorrar2, radioBorrar3;

    //ARRAYS
    private List<String> listaLacteos;
    private List<String> listaFrutas;
    private List<String> listaBebidas;

    //ADAPTERS
    private ArrayAdapter<String> adapterLacteos;
    private ArrayAdapter<String> adapterFrutas;
    private ArrayAdapter<String> adapterBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initReferences();
        setListenersToButtons();
        configuracionSpinnerLacteos();
        configuracionSpinnerFrutas();
        configuracionSpinnerBebidas();
        //Al pulsar el botón de Lácteos
        btLacteos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioAñadir1.isChecked()){
                    adapterLacteos.add(etLacteos.getText().toString());
                    adapterLacteos.notifyDataSetChanged();
                } else if (radioBorrar1.isChecked()) {
                    adapterLacteos.remove(etLacteos.getText().toString());
                    adapterLacteos.notifyDataSetChanged();
                }
            }
        });

        //Al pulsar el botón de Frutas
        btFrutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioAñadir2.isChecked()){
                    adapterFrutas.add(etFrutas.getText().toString());
                    adapterFrutas.notifyDataSetChanged();
                } else if (radioBorrar2.isChecked()) {
                    adapterFrutas.remove(etFrutas.getText().toString());
                    adapterFrutas.notifyDataSetChanged();
                }
            }
        });

        //Al pulsar el botón de Bebidas
        btBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioAñadir3.isChecked()){
                    adapterBebidas.add(etBebidas.getText().toString());
                    adapterBebidas.notifyDataSetChanged();
                } else if (radioBorrar3.isChecked()) {
                    adapterBebidas.remove(etBebidas.getText().toString());
                    adapterBebidas.notifyDataSetChanged();
                }
            }
        });
    }

    //Método que configura el Spinner de los Lácteos
    private void configuracionSpinnerLacteos() {
        //inicializo ArrayList
        listaLacteos = new ArrayList<>(); // vacío

        //configuro adaptador
        adapterLacteos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaLacteos);
        adapterLacteos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //asigno adaptador al spinner
        spLacteos.setAdapter(adapterLacteos);
        //asigno escuchador evento itemSelected
        spLacteos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                String elegido = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this, "Has elegido " + elegido, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No has elegido nada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Método que configura el Spinner de las Frutas
    private void configuracionSpinnerFrutas() {
        //inicializo ArrayList
        listaFrutas = new ArrayList<>(); // vacío

        //configuro adaptador
        adapterFrutas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaFrutas);
        adapterFrutas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //asigno adaptador al spinner
        spFrutas.setAdapter(adapterFrutas);
        //asigno escuchador evento itemSelected
        spFrutas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                String elegido = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this, "Has elegido " + elegido, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No has elegido nada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Método que configura el Spinner de las Bebidas
    private void configuracionSpinnerBebidas() {
        //inicializo ArrayList
        listaBebidas = new ArrayList<>(); // vacío

        //configuro adaptador
        adapterBebidas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaBebidas);
        adapterBebidas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //asigno adaptador al spinner
        spBebidas.setAdapter(adapterBebidas);
        //asigno escuchador evento itemSelected
        spBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                String elegido = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this, "Has elegido " + elegido, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No has elegido nada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Obtiene referencias a las Views
    private void initReferences(){
        cbMayusculas = findViewById(R.id.checkBoxMayusculas);
        cbRojo = findViewById(R.id.checkBoxRojo);
        etLacteos = findViewById(R.id.etLacteos);
        etFrutas = findViewById(R.id.etFrutas);
        etBebidas = findViewById(R.id.etBebidas);
        btLacteos = findViewById(R.id.btAceptar1);
        btFrutas = findViewById(R.id.btAceptar2);
        btBebidas = findViewById(R.id.btAceptar3);
        spLacteos = findViewById(R.id.spLacteos);
        spFrutas = findViewById(R.id.spFrutas);
        spBebidas = findViewById(R.id.spBebidas);
        radioAñadir1 = findViewById(R.id.rbAñadir1);
        radioAñadir2 = findViewById(R.id.rbAñadir2);
        radioAñadir3 = findViewById(R.id.rbAñadir3);
        radioBorrar1 = findViewById(R.id.rbBorrar1);
        radioBorrar2 = findViewById(R.id.rbBorrar2);
        radioBorrar3 = findViewById(R.id.rbBorrar3);
    }

    //Asigna escuchadores a los botones
    private void setListenersToButtons(){
        btLacteos.setOnClickListener(this);
        btFrutas.setOnClickListener(this);
        btBebidas.setOnClickListener(this);
        //Si el CheckBox de mayúsculas está checkeado, los EditText serán mayúsculas
        cbMayusculas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (cbMayusculas.isChecked()){    //Si el CheckBox está activado, los EditText son mayúsculas
                    //Pongo que en los EditText se tenga que escribir en mayúscula
                    etLacteos.setInputType(TYPE_TEXT_FLAG_CAP_CHARACTERS);
                    etFrutas.setInputType(TYPE_TEXT_FLAG_CAP_CHARACTERS);
                    etBebidas.setInputType(TYPE_TEXT_FLAG_CAP_CHARACTERS);
                    //Pongo que el texto de cada EditText sea el mismo pero en mayúsculas
                    etLacteos.setText(etLacteos.getText().toString().toUpperCase());
                    etFrutas.setText(etLacteos.getText().toString().toUpperCase());
                    etBebidas.setText(etLacteos.getText().toString().toUpperCase());

                } else {
                    //Pongo que en los EditText no se tenga que escribir en mayúscula
                    etLacteos.setInputType(InputType.TYPE_CLASS_TEXT);
                    etFrutas.setInputType(InputType.TYPE_CLASS_TEXT);
                    etBebidas.setInputType(InputType.TYPE_CLASS_TEXT);
                    //Pongo que el texto de los EditText sea en minúsculas
                    etLacteos.setText(etLacteos.getText().toString().toLowerCase());
                    etFrutas.setText(etLacteos.getText().toString().toLowerCase());
                    etBebidas.setText(etLacteos.getText().toString().toLowerCase());
                }
            }
        });

        //Si el CheckBox de rojo está checkeado, el texto de los EditText será rojo
        cbRojo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (cbRojo.isChecked()){    //Si el CheckBox está activado, los EditText son rojos
                    etLacteos.setTextColor(Color.RED);
                    etFrutas.setTextColor(Color.RED);
                    etBebidas.setTextColor(Color.RED);
                } else {    //Si el CheckBox está desactivado, los EditText son negros
                    etLacteos.setTextColor(Color.BLACK);
                    etFrutas.setTextColor(Color.BLACK);
                    etBebidas.setTextColor(Color.BLACK);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}