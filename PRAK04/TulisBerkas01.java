package PRAK04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TulisBerkas01 {
    private String alamatFile;
    private boolean status;
    private FileWriter buka;
    private BufferedWriter tulis ;
    
    public String getAlamatFile() {
        return alamatFile;
    }
    public boolean getStatus() {
        return status;
    }
    public void setAlamatFile(String alamatFile) {
        this.alamatFile = alamatFile;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public TulisBerkas01(String alamatFile) {
        setAlamatFile(alamatFile);
        try {
            buka = new FileWriter(alamatFile);
            setStatus(true);
            System.out.println("File berhasil dimuat");
        } catch (IOException e) {
            setStatus(false);
            System.out.println("file tidak ditemukan");
        }
    }
    public void TulisKonten(String[] data) {
        tulis = new BufferedWriter(buka);
        for (int i = 0; i < data.length; i++) {
            String tmp = data[i];
            try {
                tulis.write(tmp);
                tulis.newLine();
            } catch (IOException e) {
                System.out.println("Terjadi permasalahan pada penampung");
            }
        }
        try {
            tulis.flush();
        } catch (IOException ex) {
            System.out.println("Gagal dalam menulis File");
        }
    }
}
