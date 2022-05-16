package LFSR;

public class Funktionen {
    public static char[] binString2arr(String string) {
        string = string.replaceAll(" ", "");
        char[] array = new char[string.length()];
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0') array[i] = 0;
            else if (ch[i] == '1') array[i] = 1;
            else throw new IllegalArgumentException("Der String enthält nicht binäre Zeichen");
        }

        return array;
    }

    public static String arr2binString(char[] array, boolean byteTrenner) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            string.append(Integer.toHexString(array[i]));
            if ((i + 1) % 8 == 0 && byteTrenner) string.append(" ");
        }
        return string.toString();
    }

    public static char oneRound(char[] state, char[] koeffizienten) {
        if (state.length + 1 != koeffizienten.length)
            throw new IllegalArgumentException("koeffizienten muss eins größer sein als state");
        char ergebnis = state[state.length - 1];

        char newInput = 0;
        for (int i = 0; i < state.length; i++) {
            newInput += state[i] & koeffizienten[i + 1];
        }
        newInput %= 2;
        System.arraycopy(state, 0, state, 1, state.length - 1);
        state[0] = newInput;


        return ergebnis;
    }

    public static String nRounds(char[] state, char[] koeffizienten, int rounds) {
        return nRounds(state, koeffizienten, rounds, false);
    }

    public static String nRounds(char[] state, char[] koeffizienten, int rounds, boolean printState) {
        StringBuilder string = new StringBuilder();
        if (printState) System.out.println(" 0: " + arr2binString(state, true));
        for (int i = 1; i <= rounds; i++) {
            string.append(oneRound(state, koeffizienten) == 0 ? "0" : "1");
            if (i % 4 == 0) string.append(" ");
            if (printState) System.out.println((i < 10 ? " " : "") + i + ": " + arr2binString(state, true));
        }


        return string.toString();
    }
}
