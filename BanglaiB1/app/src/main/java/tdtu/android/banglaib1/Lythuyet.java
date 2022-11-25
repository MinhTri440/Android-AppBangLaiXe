package tdtu.android.banglaib1;

public class Lythuyet {
    private int cau;
    private String de;
    private String hinh;
    private String a;
    private String b;
    private String c;
    private String d;
    private String caudung;
    private int bode;
    private int socau;
    private int cauliet;
    private String traloi;

    public Lythuyet() {
    }

    public Lythuyet(int cau, String de, String hinh, String a, String b, String c, String d, String caudung, int bode, int socau, int cauliet) {
        this.cau = cau;
        this.de = de;
        this.hinh = hinh;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.caudung = caudung;
        this.bode = bode;
        this.socau = socau;
        this.cauliet = cauliet;
    }
    public Lythuyet( String de, String hinh, String a, String b, String c, String d, String caudung, int bode, int socau, int cauliet,String traloi) {
        this.de = de;
        this.hinh = hinh;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.caudung = caudung;
        this.bode = bode;
        this.socau = socau;
        this.cauliet = cauliet;
        this.traloi=traloi;
    }

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public int getCau() {
        return cau;
    }

    public void setCau(int cau) {
        this.cau = cau;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getCaudung() {
        return caudung;
    }

    public void setCaudung(String caudung) {
        this.caudung = caudung;
    }

    public int getBode() {
        return bode;
    }

    public void setBode(int bode) {
        this.bode = bode;
    }

    public int getSocau() {
        return socau;
    }

    public void setSocau(int socau) {
        this.socau = socau;
    }

    public int getCauliet() {
        return cauliet;
    }

    public void setCauliet(int cauliet) {
        this.cauliet = cauliet;
    }

    @Override
    public String toString() {
        return "Lythuyet{" +
                "cau=" + cau +
                ", de='" + de + '\'' +
                ", hinh='" + hinh + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", caudung='" + caudung + '\'' +
                ", bode=" + bode +
                ", socau=" + socau +
                ", cauliet=" + cauliet +
                ", traloi='" + traloi + '\'' +
                '}';
    }
}
