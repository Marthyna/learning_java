package com.example.aluno.desempenhoacademico;

/**
 * Created by jack on 7/4/2018.
 */

public class Aluno {

    String nome;
    int curso;
    float media, frequencia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(float frequencia) {
        this.frequencia = frequencia;
    }

    public Aluno(String nome, int curso, float media, float frequencia) {
        this.nome = nome;
        this.curso = curso;

        this.media = media;
        this.frequencia = frequencia;
    }


    public boolean passou(float media, float frequencia){
        boolean retorno = false;
        if(media >= 6 && frequencia >= 75){
            retorno = true;
        }
        return retorno;
    }
}
