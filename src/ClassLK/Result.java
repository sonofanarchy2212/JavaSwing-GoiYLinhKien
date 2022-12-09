/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLK;


public class Result {
    private String MaCPU,MaMain,MaRAM,MaCase,MaVGA,MaPSU,MaOCung;

    public Result(String MaCPU, String MaMain, String MaRAM, String MaCase, String MaVGA, String MaPSU, String MaOCung) {
        this.MaCPU = MaCPU;
        this.MaMain = MaMain;
        this.MaRAM = MaRAM;
        this.MaCase = MaCase;
        this.MaVGA = MaVGA;
        this.MaPSU = MaPSU;
        this.MaOCung = MaOCung;
    }
    public Result(){
        MaCPU = new String();
        MaMain = new String();
        MaRAM = new String();
        MaCase = new String();
        MaVGA = new String();
        MaPSU = new String();
        MaOCung = new String();
    }
    public String getMaCPU() {
        return MaCPU;
    }

    public void setMaCPU(String MaCPU) {
        this.MaCPU = MaCPU;
    }

    public String getMaMain() {
        return MaMain;
    }

    public void setMaMain(String MaMain) {
        this.MaMain = MaMain;
    }

    public String getMaRAM() {
        return MaRAM;
    }

    public void setMaRAM(String MaRAM) {
        this.MaRAM = MaRAM;
    }

    public String getMaCase() {
        return MaCase;
    }

    public void setMaCase(String MaCase) {
        this.MaCase = MaCase;
    }

    public String getMaVGA() {
        return MaVGA;
    }

    public void setMaVGA(String MaVGA) {
        this.MaVGA = MaVGA;
    }

    public String getMaPSU() {
        return MaPSU;
    }

    public void setMaPSU(String MaPSU) {
        this.MaPSU = MaPSU;
    }

    public String getMaOCung() {
        return MaOCung;
    }

    public void setMaOCung(String MaOCung) {
        this.MaOCung = MaOCung;
    }
    
}
