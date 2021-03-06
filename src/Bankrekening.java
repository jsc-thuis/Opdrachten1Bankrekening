import java.math.BigInteger;

public class Bankrekening {
    public boolean isGeldigRekeningNummer(String reknr) {
        boolean eerstecontrole = false;
        boolean tweedecontrole = false;
        // format BE00 0000 0000 0000
        // Elk niet-cijfer wordt eerst geschrapt
        reknr = reknr.replaceAll("\\D", "");    // methode replaceAll van klasse String

        if (reknr.matches("[0-9]{14}")) {       // methode matches van String en reguliere expressie
            // eerste controle
            String deeltalString1 = reknr.substring(2, 12);
            long deeltalGetal1 = Long.parseLong(deeltalString1);
            String controleString1 = reknr.substring(12);
            long controleGetal1 = Long.parseLong(controleString1);
            long rest1 = deeltalGetal1 % 97;
            if (rest1 == controleGetal1) {
                eerstecontrole = true;
            }
            // tweede controle
            String deeltalString2 = reknr.substring(2, 14);
            BigInteger deeltalGetal2 = new BigInteger(deeltalString2 + "111400");
            String controleString2 = reknr.substring(0, 2);
            BigInteger controleGetal2 = new BigInteger(controleString2);
            BigInteger bi97 = new BigInteger("97");
            BigInteger rest2 = deeltalGetal2.divideAndRemainder(bi97)[1];
            BigInteger bi98 = new BigInteger("98");
            if (bi98.subtract(rest2).equals(controleGetal2)) {
                tweedecontrole = true;
            }
        }
        if (eerstecontrole && tweedecontrole) {
            return true;
        } else {
            return false;
        }
    }
}

