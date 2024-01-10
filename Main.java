package fei.upce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Vítám vás v tomto programu pro autobusy!");
        System.out.printf("\nInformace! HH - hodiny | MM - minuty \n");

        Spoj[] spoje = new Spoj[0];
        Statistiky statistiky = new Statistiky(spoje);
        Scanner vstup = new Scanner(System.in);

        //menu
        int volba = 0;
        while (volba != 7) {
            System.out.printf("\n\nVyberte si jednu z možností:\n");
            System.out.printf("1. Načíst spoje ze souboru\n");
            System.out.printf("2. Vypsat všechny spoje\n");
            System.out.printf("3. Vypsat nejrychlejší spoj\n");
            System.out.printf("4. Vypsat spoje od zadaného času\n");
            System.out.printf("5. Přidat spoj\n");
            System.out.printf("6. Odebrat spoj\n");
            System.out.printf("7. Konec\n");
            System.out.printf("Vaše volba: ");

            try {
                volba = Integer.parseInt(vstup.nextLine());

                switch (volba) {
                    case 1:
                        Statistiky.nactiSpoje(statistiky);
                        break;
                    case 2:
                        statistiky.vypisSpoje();
                        break;
                    case 3:
                        System.out.println("Nejrychlejší spoj je: " + statistiky.najdiNejrychlejsiSpoj());
                        break;
                    case 4:
                        System.out.printf("Zadejte čas ve formátu HH:MM: ");
                        String cas = vstup.nextLine();
                        Cas cas1 = new Cas(cas, "");
                        statistiky.vypisSpojeOdCasu(cas1);
                        break;
                    case 5:
                        System.out.printf("Zadejte id spoje: ");
                        String id = vstup.nextLine();
                        System.out.printf("Zadejte čas vyjezdu ve formátu HH:MM: ");
                        String casVyjezdu = vstup.nextLine();
                        System.out.printf("Zadejte čas prijezdu ve formátu HH:MM: ");
                        String casPrijezdu = vstup.nextLine();
                        Spoj spoj = new Spoj(id, casVyjezdu, casPrijezdu);
                        statistiky.pridejSpoj(spoj);
                        break;
                    case 6:
                        statistiky.vypisSpoje();
                        System.out.printf("Zadejte id spoje: ");
                        String idSpoje = vstup.nextLine();
                        Spoj spoj1 = new Spoj(idSpoje, "", "");
                        statistiky.odeberSpoj(spoj1);
                        break;
                    case 7:
                        System.out.printf("Konec programu");
                        break;
                    default:
                        System.out.printf("Neplatná volba!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Chyba: Zadali jste neplatné číslo. Zkuste to znovu.");
            } catch (Exception e) {
                System.out.println("Došlo k chybě: " + e.getMessage());
            }
        }
    }
}