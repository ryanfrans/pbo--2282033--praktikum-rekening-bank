
import java.text.NumberFormat;
import java.util.Locale;

public class Rekening {

    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }

        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }

        saldo -= jumlah;
        return true;
    }

    private String formatRupiah(int jumlah) {
        NumberFormat format =
                NumberFormat.getNumberInstance(new Locale("id", "ID"));

        return "Rp" + format.format(jumlah);
    }

    public void cetakInfo() {
        System.out.printf("%s | %-10s | %s%n",
                nomor, pemilik, formatRupiah(saldo));
    }
}
