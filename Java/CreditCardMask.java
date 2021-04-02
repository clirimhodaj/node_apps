import java.util.Arrays;

public class CreditCardMask {
    
    private static final int ALPHABET_COUNT = 26;
    private static int o = 0;
    private static int x = 0;
    public static void main(String[] args) {
        //String numri = "8291084vnasa325616"; // programi nuk maskon 4 shifrat e fundit 
        //String kodi = maskify(numri);
        String tekst = "xXxxoewrcoOoo";
        System.out.println(getXO1(tekst));
        // System.out.println("Plain eshte " + numri);
        // System.out.println("Kodi eshte :" + kodi);
    }

    public static String maskify(String str) throws IndexOutOfBoundsException {
        String stringu = null;
        String mask = null;
        if(str.length() > 4){
            stringu = str.substring(str.length()-4);
            str = str.substring(0,str.length()-4);
            for(int i = 0 ; i < str.length(); i++){
                str = str.replace(str.charAt(i),'#');
            }
            mask = str + stringu;
        }
        else{
            mask = str;
        }
        return mask;
    }

    public static boolean isPangram(String str){
        if (str == null)
            return false;
        Boolean[] alphabetMarker = new Boolean[ALPHABET_COUNT];
        Arrays.fill(alphabetMarker,false);
        int alphabetIndex = 0;
        String strUpper = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= strUpper.charAt(i) && strUpper.charAt(i) <= 'Z') {
                alphabetIndex = strUpper.charAt(i) - 'A';
                alphabetMarker[alphabetIndex] = true;
            }
        }
        for (boolean index : alphabetMarker) {
            if (!index)
                return false;
        }
        return true;
    }

    public static boolean getXO (String str) {
        str = str.toLowerCase();
        boolean bln = false;
        if(str.contains("o") || str.contains("x")){
            bln = unaza(o,x,str,'o','x');
        }
        else{
            char c1 = str.charAt(0);
            char c2 = 0;
            for(int i = 1; i<str.length(); i++){
                if(str.charAt(i) != c1){
                    c2 = str.charAt(i);
                    break;
                }
            }
            bln = unaza(o, x, str,c1,c2);
        }
        return bln;
      }

      public static boolean unaza(int o, int x, String str, char c1, char c2){
        for(int i=0 ; i < str.length(); i++){
            if(str.charAt(i) == c1){
                o++;
            }
            else if(str.charAt(i) == c2){
                x++;
            }
        }
        return o == x;
      }


      public static boolean getXO1 (String str) {
        str = str.toLowerCase();
        boolean bln = false;
        if(str.contains("o") || str.contains("x")){
           for(int i=0 ; i < str.length(); i++){
             if(str.charAt(i) == 'o'){ 
                o++;
            }
            else if(str.charAt(i) == 'x'){
                x++;
            }
        }
        bln = (o == x)?true :false;
      }
        else{
            bln = true;
        }
        return bln;
      }

    

}
