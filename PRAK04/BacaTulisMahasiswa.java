package PRAK04;
import java.time.LocalDate;

public class BacaTulisMahasiswa {
    private BacaBerkas01 bacaBerkas;
    
    private void bacaFileData() {
        String fileini = "D:\\Data.txt";
        bacaBerkas = new BacaBerkas01(fileini);
        if(!bacaBerkas.getStatus()) {
            System.out.println("File Data.txt gagal dimuat");
            System.exit(0);
        }
    }
    public Mahasiswa[] simpanKeArray() {
        String[] tmp1 = bacaBerkas.BacaKonten2();
        String npm = "", nama = "", gender = "", alamat = "",tempatLahir = "",tanggalLahir = "";
        int ukuran,pos,idx = 0;
        
        ukuran = Integer.parseInt(tmp1[0]);
        Mahasiswa arrayMahasiswa[] = new Mahasiswa[ukuran];
        
        for(int i = 1; i < tmp1.length; i++) {
            pos = (i-1) % 6;
            switch(pos) {
                case 0 : npm = tmp1[i]; break;
                case 1 : nama = tmp1[i]; break;
                case 2 : gender = tmp1[i]; break;
                case 3 : alamat = tmp1[i]; break;
                case 4 : tempatLahir = tmp1[i]; break;
                case 5 : tanggalLahir = tmp1[i];
                arrayMahasiswa[idx] = new Mahasiswa(npm, nama, gender,
                alamat, tempatLahir, tanggalLahir);
                idx++;
            }
        }
        return arrayMahasiswa;
    }
    public void simpankeFile(Mahasiswa arrayMahasiswa[]) {
        int banyak,ukuran, pos = 0;
        banyak = arrayMahasiswa.length;
        ukuran = banyak*6 + 1;
        
        String fileIni = "D:\\PRAK04\\Data.txt";
        String tmp1[] = new String[ukuran];
        
        tmp1[pos] = String.valueOf(banyak); pos++;
        for(int i = 0; i < arrayMahasiswa.length;i++) {
            Mahasiswa tmp2 = arrayMahasiswa[i];
            tmp1[pos] = tmp2.getNpm(); pos++;
            tmp1[pos] = tmp2.getNama(); pos++;
            tmp1[pos] = tmp2.getGender(); pos++;
            tmp1[pos] = tmp2.getAlamat(); pos++;
            tmp1[pos] = tmp2.getTempatLahir(); pos++;
            tmp1[pos] = String.valueOf(tmp2.getTanggalLahir()); pos++;
        }
        TulisBerkas01 tulisBerkas = new TulisBerkas01(fileIni);
        if(!tulisBerkas.getStatus()) System.exit(0);
        tulisBerkas.TulisKonten(tmp1);
    }
    public BacaTulisMahasiswa() {
        bacaFileData();
    }
}
