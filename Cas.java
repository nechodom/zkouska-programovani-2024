package fei.upce;

public class Cas {

    private String hodina;
    private String minuta;

    public Cas(String hodina, String minuta) {
        this.hodina = hodina;
        this.minuta = minuta;
    }

    @Override
    public String toString() {
        return "Cas - " + "hodina= " + hodina + ", minuta= " + minuta;
    }

    static int prevodStringuNaMinuty(String time) {
            String[] parts = time.split(":");
            int hodin = Integer.parseInt(parts[0]);
            int minut = Integer.parseInt(parts[1]);
            return hodin * 60 + minut;
        }

    int prevedNaMinutyOdPulnoci() {
        return prevodStringuNaMinuty(hodina + ":" + minuta);
    }

    int spocitejRozdilMinuty(Cas cas) {
        return prevedNaMinutyOdPulnoci() - cas.prevedNaMinutyOdPulnoci();
    }
}
