package com.example.nutrilife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText edit_nome;
    private EditText edit_peso;
    private EditText edit_altura;
    private RadioGroup rd_grupo;
    private RadioButton rd_masc;
    private RadioButton rd_fem;
    private Button btn_calc;
    String gender;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nome = findViewById(R.id.edit_nome);
        edit_peso = findViewById(R.id.edit_peso);
        edit_altura = findViewById(R.id.edit_altura);
        rd_grupo = findViewById(R.id.rd_grupo);
        rd_masc = findViewById(R.id.rd_masc);
        rd_fem = findViewById(R.id.rd_fem);
        btn_calc = findViewById(R.id.btn_calc);


        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nome = findViewById(R.id.edit_nome);
                EditText peso = findViewById(R.id.edit_peso);
                EditText altura = findViewById(R.id.edit_altura);

                if (nome.getText().toString().length() == 0) {
                    janelaErro();
                }else if (peso.getText().toString().length() == 0) {
                    janelaErro();
                }else if (altura.getText().toString().length() == 0) {
                    janelaErro();
                }else if (rd_grupo.getCheckedRadioButtonId() == -1){
                    janelaErro();
                }else{

                    Double pesoI = Double.parseDouble(peso.getText().toString());
                    Double alturaI = Double.parseDouble(altura.getText().toString());

                    String nomeI = nome.getText().toString();

                    Intent intent = new Intent(getBaseContext(), Resultado.class);
                    intent.putExtra("Peso", pesoI);
                    intent.putExtra("Altura", alturaI);
                    intent.putExtra("Sexo", gender);
                    intent.putExtra("Nome", nomeI);
                    startActivity(intent);

                    edit_nome.setText("");
                    edit_peso.setText("");
                    edit_altura.setText("");

                }

            }



        });
        RadioGroup rg = (RadioGroup) findViewById(R.id.rd_grupo);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup rd_grupo , int checkedId) {
                RadioButton radioButton;
                switch(checkedId){
                    case R.id.rd_masc:
                        radioButton = (RadioButton) findViewById(checkedId);
                        gender=radioButton.getText().toString();
                        break;
                    case R.id.rd_fem:
                        radioButton = (RadioButton) findViewById(checkedId);
                        gender=radioButton.getText().toString();
                        break;
                }
            }
        });
    }




    public void janelaErro(){
        AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
        janela.setTitle(R.string.app_name);
        janela.setMessage("Todos os campos devem ser preenchidos!");
        janela.setNeutralButton("Ok", null);
        janela.show();
    }

}