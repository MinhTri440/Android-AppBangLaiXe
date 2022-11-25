package tdtu.android.banglaib1;

public class Bienbao {
    private int id;
    private String hinh;
    private String noidung;
    private String loai;

    public Bienbao() {
    }

    public Bienbao(int id, String hinh, String noidung, String loai) {
        this.id = id;
        this.hinh = hinh;
        this.noidung = noidung;
        this.loai = loai;
    }
    public Bienbao( String hinh, String noidung, String loai) {
        this.hinh = hinh;
        this.noidung = noidung;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return "Bienbao{" +
                "id=" + id +
                ", hinh='" + hinh + '\'' +
                ", noidung='" + noidung + '\'' +
                ", loai='" + loai + '\'' +
                '}';
    }
}
