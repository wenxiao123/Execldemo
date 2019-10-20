public class Menu {
    String nianlingduan;
    String KM_1;
    String CJ_1;
    String CJ_2;
    String KM_2;

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "nianlingduan='" + nianlingduan + '\'' +
                ", KM_1='" + KM_1 + '\'' +
                ", CJ_1='" + CJ_1 + '\'' +
                ", CJ_2='" + CJ_2 + '\'' +
                ", KM_2='" + KM_2 + '\'' +
                ", KM_3='" + KM_3 + '\'' +
                ", CJ_3='" + CJ_3 + '\'' +
                ", KM_4='" + KM_4 + '\'' +
                ", CJ_4='" + CJ_4 + '\'' +
                '}';
    }

    public Menu(String nianlingduan, String KM_1, String CJ_1, String CJ_2, String KM_2, String KM_3, String CJ_3, String KM_4, String CJ_4) {
        this.nianlingduan = nianlingduan;
        this.KM_1 = KM_1;
        this.CJ_1 = CJ_1;
        this.CJ_2 = CJ_2;
        this.KM_2 = KM_2;
        this.KM_3 = KM_3;
        this.CJ_3 = CJ_3;
        this.KM_4 = KM_4;
        this.CJ_4 = CJ_4;
    }

    String KM_3;
    String CJ_3;
    String KM_4;
    String CJ_4;

    public String getNianlingduan() {
        return nianlingduan;
    }

    public void setNianlingduan(String nianlingduan) {
        this.nianlingduan = nianlingduan;
    }

    public String getKM_1() {
        return KM_1;
    }

    public void setKM_1(String KM_1) {
        this.KM_1 = KM_1;
    }

    public String getCJ_1() {
        return CJ_1;
    }

    public void setCJ_1(String CJ_1) {
        this.CJ_1 = CJ_1;
    }

    public String getCJ_2() {
        return CJ_2;
    }

    public void setCJ_2(String CJ_2) {
        this.CJ_2 = CJ_2;
    }

    public String getKM_2() {
        return KM_2;
    }

    public void setKM_2(String KM_2) {
        this.KM_2 = KM_2;
    }

    public String getKM_3() {
        return KM_3;
    }

    public void setKM_3(String KM_3) {
        this.KM_3 = KM_3;
    }

    public String getCJ_3() {
        return CJ_3;
    }

    public void setCJ_3(String CJ_3) {
        this.CJ_3 = CJ_3;
    }

    public String getKM_4() {
        return KM_4;
    }

    public void setKM_4(String KM_4) {
        this.KM_4 = KM_4;
    }

    public String getCJ_4() {
        return CJ_4;
    }

    public void setCJ_4(String CJ_4) {
        this.CJ_4 = CJ_4;
    }
}
