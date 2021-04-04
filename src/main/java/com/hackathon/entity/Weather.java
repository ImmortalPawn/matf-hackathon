package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

  private int vreme;
  private int temperatura;
  private int vlaznost;
  private double pritisak;
  private double brzina;
  private int oblacnost;
  @JsonProperty("dan u nedelji")
  private int danUNedelji;
  private int mesec;

  public Weather() {
  }

  public Weather(int vreme, int temperatura, int vlaznost, double pritisak, double brzina,
      int oblacnost, int danUNedelji, int mesec) {
    this.vreme = vreme;
    this.temperatura = temperatura;
    this.vlaznost = vlaznost;
    this.pritisak = pritisak;
    this.brzina = brzina;
    this.oblacnost = oblacnost;
    this.danUNedelji = danUNedelji;
    this.mesec = mesec;
  }

  public int getVreme() {
    return vreme;
  }

  public void setVreme(int vreme) {
    this.vreme = vreme;
  }

  public int getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(int temperatura) {
    this.temperatura = temperatura;
  }

  public int getVlaznost() {
    return vlaznost;
  }

  public void setVlaznost(int vlaznost) {
    this.vlaznost = vlaznost;
  }

  public double getPritisak() {
    return pritisak;
  }

  public void setPritisak(double pritisak) {
    this.pritisak = pritisak;
  }

  public double getBrzina() {
    return brzina;
  }

  public void setBrzina(double brzina) {
    this.brzina = brzina;
  }

  public int getOblacnost() {
    return oblacnost;
  }

  public void setOblacnost(int oblacnost) {
    this.oblacnost = oblacnost;
  }

  public int getDanUNedelji() {
    return danUNedelji;
  }

  public void setDanUNedelji(int danUNedelji) {
    this.danUNedelji = danUNedelji;
  }

  public int getMesec() {
    return mesec;
  }

  public void setMesec(int mesec) {
    this.mesec = mesec;
  }

}
