package fei.upce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Statistiky {

        private Spoj[] spoje;

        public Statistiky(Spoj[] spoje) {
            this.spoje = spoje;
        }

        void pridejSpoj(Spoj spoj) {
            Spoj[] novePole = new Spoj[spoje.length + 1];
            for (int i = 0; i < spoje.length; i++) {
                novePole[i] = spoje[i];
            }
            novePole[spoje.length] = spoj;
            spoje = novePole;
        }

        void odeberSpoj(Spoj spoj){
            Spoj[] novePole = new Spoj[spoje.length - 1];
            int index = 0;
            for (Spoj spoj1 : spoje) {
                if (!spoj1.getId().equals(spoj.getId())) {
                    novePole[index] = spoj1;
                    index++;
                }
            }
            spoje = novePole;
        }

        void vypisSpoje() {
            for (Spoj spoj : spoje) {
                System.out.println(spoj);
            }
        }

        Spoj najdiNejrychlejsiSpoj(){
            Spoj nejrychlejsiSpoj = spoje[0];
            for (Spoj spoj : spoje) {
                if (nejrychlejsiSpoj.casJizdyMinuty() > spoj.casJizdyMinuty()) {
                    nejrychlejsiSpoj = spoj;
                }
            }
            return nejrychlejsiSpoj;
        }

        void vypisSpojeOdCasu(Cas cas) {
            for (Spoj spoj : spoje) {
                if (Cas.prevodStringuNaMinuty(spoj.getCasVyjezdu()) > cas.prevedNaMinutyOdPulnoci()) {
                    System.out.println(spoj);
                }
            }
        }
    public static void nactiSpoje(Statistiky statistiky) {
            Scanner vstup = new Scanner(System.in);
            String fileName = "";
            System.out.println("Zadejte cestu k souboru: ");
            fileName = vstup.nextLine();
            String line;
            String csvSplitBy = ";";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);
                    if (data.length == 3) {
                        Spoj spoj = new Spoj(data[0], data[1], data[2]);
                        statistiky.pridejSpoj(spoj);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
}

