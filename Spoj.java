package fei.upce;

public class Spoj {

    private String id;
    private String casVyjezdu;
    private String casPrijezdu;

    public Spoj(String id, String casVyjezdu, String casPrijezdu) {
        this.id = id;
        this.casVyjezdu = casVyjezdu;
        this.casPrijezdu = casPrijezdu;
    }

    public String getId() {
        return id;
    }

    public String getCasVyjezdu() {
        return casVyjezdu;
    }

    public String getCasPrijezdu() {
        return casPrijezdu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCasVyjezdu(int casVyjezdu) {
        this.casVyjezdu = String.valueOf(casVyjezdu);
    }

    public void setCasPrijezdu(int casPrijezdu) {
        this.casPrijezdu = String.valueOf(casPrijezdu);
    }

    @Override
    public String toString() {
        return "Spoj - " + "ID= '" + id + ", casVyjezdu= " + casVyjezdu + " , casPrijezdu=" + casPrijezdu + " , čas jízdy v minutách= " + casJizdyMinuty();
    }

    int casJizdyMinuty() {
        return Cas.prevodStringuNaMinuty(casPrijezdu) - Cas.prevodStringuNaMinuty(casVyjezdu);
    }
}
