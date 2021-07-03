package PRAK04;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class OlahDataMahasiswa {
    private BacaTulisMahasiswa BTM;
    private Mahasiswa arrayMahasiswa[];
    private Scanner input = new Scanner(System.in);
    
    private void plusArray(Mahasiswa AT) {
        int idx, ukuran;
        idx = arrayMahasiswa.length;
        ukuran = idx + 1;
        arrayMahasiswa = Arrays.copyOf(arrayMahasiswa, ukuran);
        arrayMahasiswa[idx] = AT;
    }
    
    private void menuTambahData() {
        String npm,nama,gender,alamat,tempatlahir, tanggallahir;
        Mahasiswa tmp;
        
        System.out.println("Menu Tambah Data Mahasiswa...");
        System.out.println("NPM : "); npm = input.nextLine();
        System.out.println("Nama : "); nama = input.nextLine();
        System.out.println("Gender : "); gender = input.nextLine();
        System.out.println("Alamat : "); alamat = input.nextLine();
        System.out.println("Tempat Lahir : "); tempatlahir = input.nextLine();
        System.out.println("Tanggal Lahir : "); tanggallahir = input.nextLine();
        tmp = new Mahasiswa(npm, nama, gender, alamat, tempatlahir, tanggallahir);
        plusArray(tmp);
        System.out.println("Data telah berhasil disimpan.\n");
    }
    
    private void minusArray(int idx) {
        for(int i = idx; i < arrayMahasiswa.length-1;i++)
        arrayMahasiswa[i] = arrayMahasiswa[i+1];
        arrayMahasiswa = Arrays.copyOf(arrayMahasiswa, arrayMahasiswa.length-1);
    }
    
    private int cariData(String kode) {
        int pos = -1;
        for(int i = 0;i < arrayMahasiswa.length;i++) {
            if(arrayMahasiswa[i].getNpm().equals(kode)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    private void menuHapusData() {
        String kode;
        int pos;
        System.out.println("Menu Hapus Data Mahasiswa");
        System.out.println("Kode : "); kode = input.nextLine();
        pos = cariData(kode);
        
        if(pos < 0) {
            System.out.println("Kode tidak ditemukan");
        } else {
            minusArray(pos);
            System.out.println("Data dengan kode : "+kode+"berhasil dihapus.\n");
        }
    }
    
    private void menuCetakByKode() {
        String kode;
        int pos;
        System.out.println("Menu cetak by kode...");
        System.out.println("Kode : "); kode = input.nextLine();
        pos = cariData(kode);
        
        if(pos < 0) {
            System.out.println("Kode tidak ditemukan.\n");
        } else {
            System.out.println("Data yang dicari :");
            arrayMahasiswa[pos].cetak();
            System.out.println("");
        }
    }
    
    private void menuCetakSemua() {
        System.out.println("Menu Cetak Semua...");
        for(int i = 0;i < arrayMahasiswa.length;i++) {
            System.out.println("Data ke-"+(i+1)+" :");
            arrayMahasiswa[i].cetak();
            System.out.println("");
        }
    }
    
    public void menuUtama() {
    int pil = 1;
    while(pil > 0 && pil < 5) {
        System.out.print("Menu utama :\n"
        + "(1) Tambah Data\n"
        + "(2) Hapus Data\n"
        + "(3) Cetak Data by Kode\n"
        + "(4) Cetak Semua\n"
        + "(Lainnya) Keluar\n"
        + "Pilihan :");
        pil = input.nextInt();input.nextLine();
        switch(pil){
            case 1 : menuTambahData(); break;
            case 2 : menuHapusData(); break;
            case 3 : menuCetakByKode(); break;
            case 4 : menuCetakSemua(); break;
            default:
            System.out.println("Terima kasih...");
            BTM.simpankeFile(arrayMahasiswa);
        }
    }
    }
    
    public OlahDataMahasiswa() {
        BTM = new BacaTulisMahasiswa();
        arrayMahasiswa = BTM.simpanKeArray();
        menuUtama();
    }
    
    public static void main(String[] args) {
        new OlahDataMahasiswa();
    }
}
