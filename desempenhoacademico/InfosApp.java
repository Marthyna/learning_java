package com.example.aluno.desempenhoacademico;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by jack on 7/4/2018.
 */

public class InfosApp extends Application{
    private ArrayList<Aluno> listaAlunos;

    @Override
    public void onCreate(){
        super.onCreate();
        listaAlunos = new ArrayList<Aluno>();
    }

    public ArrayList<Aluno> getListaAlunos() {return listaAlunos;}

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
