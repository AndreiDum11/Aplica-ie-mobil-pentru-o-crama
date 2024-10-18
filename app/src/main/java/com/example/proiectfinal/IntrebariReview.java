package com.example.proiectfinal;

public class IntrebariReview {
    public String vectIntreb[] = {
            "Ce sunt sulfitii si de ce sunt periculosi?",
            "Cat timp este bun vinul dupa deschidere?",
            "Cum trebuie depozitat vinul?",
            "Este vinul bun pentru tine?",
            "Conteaza pretul cu adevarat?",

    };
    public String vectRasp[][] = {
            {"Sunt compusi chimici", "Sunt Naturali", "Sunt prezenti in vin", "Sunt compusi "},
            {"7 zile", "3 zile", "4 zile", "6 zile"},
            {"Sticle Deschise", "Sticle Nedeschise", "orizontala", "verticala"},
            {"Da", "Nu", "Poate", "Probabil"},
            {"Da ", "Nu ", "Depinde", "Poate"}
    };
    public String raspCorecte[] = {"Sunt compusi chimici", "6 zile", "Sticle Nedeschise", "Da", "Depinde"};
    public String getIntrebare(int i) {
        return vectIntreb[i];
    }
    public String getRaspA(int i) {
        return vectRasp[i][0];
    }
    public String getRaspB(int i) {
        return vectRasp[i][1];
    }
    public String getRaspC(int i) {
        return vectRasp[i][2];
    }
    public String getRaspD(int i) {
        return vectRasp[i][3];
    }
    public String getRaspunsCorect(int i) {
        return raspCorecte[i];
    }
}
