package PRAK04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BacaBerkas01 {
    private String alamatFile;
    private boolean status;
    private FileReader buka;
    private BufferedReader baca;
    
    public String getAlamatFile() {
        return alamatFile;
    }
    public void setAlamatFile(String alamatFile) {
        this.alamatFile = alamatFile;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public BacaBerkas01 (String alamatFile){
        setAlamatFile (alamatFile);
        try{
            buka = new FileReader (alamatFile);
            setStatus(true);
            System.out.println("File berhasil dibuka");
        } catch (FileNotFoundException e){
            setStatus(false);
            System.out.println("File tidak dapat ditemukan atau tidak dapat diakses");
        }
    }
    public void BacaKonten() {
        String tmp = "";
        baca = new BufferedReader(buka);
        while(true) {
            try {
                tmp = baca.readLine();
                if(tmp == null) break;
                System.out.println(tmp);
            } catch (IOException e) {
                System.out.println("Karakter tidak bisa dibaca");
            }
        }
    }
    private String[] update(String S[], String val) {
        int idx = S.length;
        S = Arrays.copyOf(S, S.length+1);
        S[idx] = val;
        return S;
    }
    public String[] BacaKonten2() {
        String tmp = "",hasil[] = null;
        baca = new BufferedReader(buka);
        while(true) {
            try {
                tmp = baca.readLine();
                if(tmp == null) break;
                if(hasil == null) {
                    hasil = new String[] {tmp};
                } else {
                    hasil = update(hasil, tmp);
                }
            } catch (IOException e) {
                System.out.println("Karakter tidak bisa dibaca");
            }
        }
        return hasil;
    }
}
