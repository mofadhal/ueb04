import java.lang.String;

/**
 * eine class um die Teilsumme und ISBN zu brechnen
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (08.12.2020)
 */
public class MathFunctions {
    private static final long MIN_ISBN = 100000000;
    private static final long MAX_ISBN = 1000000000;

    /**
     * Vorschleife zur berechnung der Teilersumme mit mod 2
     *
     * @param zahl if Bedingung zur Überprüfung der zahl ob sie eine Teilersummme ist
     * @return summe Ausgabe der Summe
     */


    static long berechneTeilersumme(long zahl) {
        long Teilersumme = zahl;
        if(zahl > 0){
        for (int i = 1; i <= zahl/2; i++) {
            if ((zahl % i) == 0) {
                Teilersumme = Teilersumme + i;
            }
        }
       }else {
           throw new IllegalArgumentException("Die Zahl muss positiv sein");
        }
        return Teilersumme;
    }
    
    /**
     * Vorschleife zur berechnung der pruefziffer 
     *
     * @param isbn: isbn is eine 9 stellige zahl und anhand diese zahl wird die 
     *              pruef ziffer wie in blatt beschreibung berechnet
     * @return Die berechnete prüfziffer als String
     */

    static String berechneChecksummeIsbn(long isbn) {

        int checkDigit = 0;
        if (isbn >= MIN_ISBN && isbn < MAX_ISBN) {
            for (int j = 9; j >= 1; j--) {
                checkDigit += j * (isbn % 10);
                isbn /= 10;
            }
            checkDigit %= 11;
        } else {
            throw new IllegalArgumentException("isbn muss = 9 stillige positiv Nummern sein");
        }
        if (checkDigit == 10) {
            return "X";
        }
        return " " + checkDigit;
    }

    /**
     * Method berechneNullstellen
     *
     * @param p A parameter
     * @param q A parameter
     * @return lösung
     */
    public static String berechneNullstellen(double p, double q){

        double x, x1, x2, d;
        d = ((p * p) / 4) - q;
        String lösung = null;

        if ( d > 0.000001 ){
            x1 = ( - p / 2 ) + Math.sqrt(d);
            x2 = ( - p / 2 ) - Math.sqrt(d);
            lösung = "Zwei Nullstellen: " + x1 + "|" + x2;
        }
        else if ( d <= 0.00001 && d >= 0.00001){
            x = ( - p / 2);
            lösung = "Doppelte Nullstelle: " + x;
        }
        else if ( d < -0.000001){
            lösung = "Komplexe Nullstellen";
        }
        return lösung;
    }

    /**
     * Method istSummeVonPotzenten
     *
     * @param n A parameter
     * @return true, falls n = a*a*a*a + b*b*b + c*c
     */
     static boolean istSummeVonPotenzen (long n){
        
         int max = (int)Math.round(Math.sqrt(n));
        for (int a = 1; a <= max ; a++) {
            for (int b = 1; b <= max ; b++) {
                for (int c = 1; c <= max ; c++) {
                    if (n == a*a*a*a + b*b*b + c*c) {
                        return true;
                    }
                }
            }

        }
        return false;
    }


}

    

