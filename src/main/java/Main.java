import static LFSR.Funktionen.*;

public class Main {
    public static void main(String[] args) {
        uebung();
    }

    public static void uebung() {
        // Aufgabe 1 a
        char[] koeff = binString2arr("1101"); // 1*x^3 + 1*x^2 + 0*x + 1*1
        char[] init = binString2arr("100");
        String s = nRounds(init, koeff, 20, false);
        System.out.println("1a: " + s + "\n");
        // Aufgabe 1 b
        init = binString2arr("011");
        s = nRounds(init, koeff, 20, false);
        System.out.println("1b: " + s + "\n");

        // Aufgabe 2
        koeff = binString2arr("110110001");
        init = binString2arr("11111111");
        s = nRounds(init, koeff, 16, false);
        System.out.println("2: " + s + "\n");

        // Aufgabe 3
        koeff = binString2arr("11001");
        init = binString2arr("1001");
        s = nRounds(init, koeff, 20, false);
        System.out.println("3: " + s);
    }
}
