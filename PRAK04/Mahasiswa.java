package PRAK04;

import java.time.LocalDate;

public class Mahasiswa {
    //atribut
    private String npm, nama, gender, alamat, tempatLahir, tanggalLahir;
    
    Mahasiswa(String npm, String nama, String gender, String alamat,
    String tempatLahir, LocalDate tanggalLahir) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //perilaku
    public String getNpm() {
        return npm;
    }
    public void setNpm(String npm) {
        this.npm = npm;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getTempatLahir() {
        return tempatLahir;
    }
    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    public String getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    public Mahasiswa(String npm, String nama, String gender, String alamat,
    String tempatLahir, String tanggalLahir) {
    this.npm = npm;
    this.nama = nama;
    this.gender = gender;
    this.alamat = alamat;
    this.tempatLahir = tempatLahir;
    this.tanggalLahir = tanggalLahir;
    }
    public void cetak(){
    System.out.println("NPM : " + getNpm());
    System.out.println("Nama : " + getNama());
    System.out.println("Jenis Kelamin : " + getGender());
    System.out.println("Alamat : " + getAlamat());
    System.out.println("Tempat Lahir : " + getTempatLahir());
    System.out.println("Tanggal Lahir : " + getTanggalLahir());
    }   
}
