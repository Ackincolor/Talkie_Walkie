package com.ackincolor.talkiewalkie.entities;

public class AndroidDevice {
    private Integer id;
    private String ip;
    private String nom;
    private String port;

    public AndroidDevice(String ip, String nom, String port) {
        this.ip = ip;
        this.nom = nom;
        this.port = port;
    }

    public AndroidDevice() {
    }
    public String getName(){
        return this.nom+" : "+this.ip;
    }
}
