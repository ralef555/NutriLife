package com.example.nutrilife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    private TextView txt_resul;
    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txt_resul = findViewById(R.id.txt_resul);
        btn_voltar = findViewById(R.id.btn_voltar);

        Intent intent = getIntent();
        Double pesoI = intent.getDoubleExtra("Peso", 0);
        Double alturaI = intent.getDoubleExtra("Altura", 0);
        String gender = intent.getStringExtra("Sexo");
        String nome = intent.getStringExtra("Nome");

        String resultado = "";
        Double mmc = pesoI / (alturaI * alturaI);

        if (gender.equals("Masculino")){

            if (mmc<20){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Abaixo do normal.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Abaixo do normal.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");*/
                if ((mmc <= 16) && (mmc<=16.9)){
                    resultado+="\nQueda de cabelo, infertilidade, ausência menstrual.";
                }else if ((mmc >= 17) && (mmc<=18.4)){
                    resultado+="\nFadiga, stress, ansiedade";
                }else if ((mmc >= 18.5) && (mmc<20)){
                    resultado+="\nMenos riscos de doenças cardíacas e vasculares.";
                }
                txt_resul.setText(resultado);

            }else if ((mmc>=20) && (mmc<24.9)){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Normal.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                resultado+="\nMenos riscos de doenças cardíacas e vasculares.";
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Normal.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");
                resultado.append("\nMenos riscos de doenças cardíacas e vasculares.").append("\n");*/
                txt_resul.setText(resultado);


            }else if ((mmc>=25) && (mmc<29.9)){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Obesidade leve..\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                resultado+="\nFadiga, má circulação, varizes.";
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Obesidade leve.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");
                resultado.append("\nFadiga, má circulação, varizes.").append("\n");*/
                txt_resul.setText(resultado);


            }else if ((mmc>=30) && (mmc<39.9)){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Obesidade moderada.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Obesidade moderada.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");*/
                if ((mmc>=30) && (mmc<=34.9)){
                    resultado+="\nDiabetes, angina, infarto, aterosclerose.";
                    //resultado.append("\nDiabetes, angina, infarto, aterosclerose.").append("\n");
                }else if ((mmc>=35) && (mmc<=39.9)){
                    resultado+="\nApneia do sono, falta de ar.";
                    //resultado.append("\nApneia do sono, falta de ar.").append("\n");
                }
                txt_resul.setText(resultado);


            }else if (mmc >= 40){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Obesidade mórbida.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                resultado+="\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Obesidade mórbida.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");
                resultado.append("\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.").append("\n");*/
                txt_resul.setText(resultado);
            }

        }
        else if (gender.equals("Feminino")){

            if (mmc<19){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Abaixo do normal.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Abaixo do normal.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");*/
                if (mmc<=16.9){
                    resultado+="\nQueda de cabelo, infertilidade, ausência menstrual.";
                    //resultado.append("\nQueda de cabelo, infertilidade, ausência menstrual.").append("\n");
                }else if ((mmc >= 17) && (mmc<=18.4)){
                    resultado+="\nFadiga, stress, ansiedade";
                    //resultado.append("\nFadiga, stress, ansiedade").append("\n");
                }else if ((mmc >= 18.5) && (mmc<19)){
                    resultado+="\nMenos riscos de doenças cardíacas e vasculares.";
                    //resultado.append("\nMenos riscos de doenças cardíacas e vasculares.").append("\n");
                }
                txt_resul.setText(resultado);

            }else if ((mmc>=19) && (mmc<=23.9)){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Normal.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                resultado+="\nMenos riscos de doenças cardíacas e vasculares.";
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Normal.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");
                resultado.append("\nMenos riscos de doenças cardíacas e vasculares.").append("\n");*/
                txt_resul.setText(resultado);


            }else if ((mmc>=24) && (mmc<=28.9)){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Obesidade leve.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                resultado+="\nFadiga, má circulação, varizes.";
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Obesidade leve.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");
                resultado.append("\nFadiga, má circulação, varizes.").append("\n");*/
                txt_resul.setText(resultado);


            }else if ((mmc>=29) && (mmc<=38.9)){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Obesidade moderada.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Obesidade moderada.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");*/
                if ((mmc>=29) && (mmc<=34.9)){
                    resultado+="\nDiabetes, angina, infarto, aterosclerose.";
                    //resultado.append("\nDiabetes, angina, infarto, aterosclerose.").append("\n");
                }else if ((mmc>=35) && (mmc<=38.9)){
                    resultado+="\nApneia do sono, falta de ar.";
                    //resultado.append("\nApneia do sono, falta de ar.").append("\n");
                }
                txt_resul.setText(resultado);

            }else if (mmc >= 39){
                resultado = String.format("Olá, %s\nSeu IMC é: %5.2f\nClassificação: Obesidade mórbida.\nAbaixo estão os riscos associados ao seu resultado: ", nome, mmc);
                resultado+="\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
                /*resultado.append("Olá, ").append(nome).append("\n");
                resultado.append("Seu IMC é:  ").append(mmc).append("\n");
                resultado.append("Classificação: Obesidade mórbida.").append("\n");
                resultado.append("\nAbaixo estão os riscos associados ao seu resultado: ").append("\n");
                resultado.append("\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.").append("\n");*/
                txt_resul.setText(resultado);
            }
        }

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}
