import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder{
    // public static String decode(String morseCode) {
    //   String tekstidekriptuar = MorseCode.get(morseCode);
    //   return tekstidekriptuar;
    // }
    public static String decode(String morseCode) {
        String tekstidekriptuar = MorseCode.get(morseCode);
        return tekstidekriptuar;
      }
      public static class MorseCode {
        public static String get(String code) {
          code = code.trim();
          String[] teksti = code.split(" ");

          StringBuffer buff = new StringBuffer();
          for(String s : teksti){
            if(s.equals("")){
                if(buff.indexOf(" ")==-1)
              buff.append(" ");
            }else
              buff.append(getWordFromLibrary(s));   
          }
          return buff.toString();
        }
    
           private static String getWordFromLibrary(String key) {
            Map<String, String> library = new HashMap<String, String>();
            library.put(".-", "A");
            library.put("-...", "B");
            library.put("-.-.", "C");
            library.put("-..", "D");
            library.put(".", "E");
            library.put("..-.", "F");
            library.put("--.", "G");
            library.put("....", "H");
            library.put("..", "I");
            library.put(".---", "J");
            library.put("-.-", "K");
            library.put(".-..", "L");
            library.put("--", "M");
            library.put("-.", "N");
            library.put("---", "O");
            library.put(".--.", "P");
            library.put("--.-", "Q");
            library.put(".-.", "R");
            library.put("...", "S");
            library.put("-", "T");
            library.put("..-", "U");
            library.put("...-", "V");
            library.put(".--", "W");
            library.put("-..-", "X");
            library.put("-.--", "Y");
            library.put("--..", "Z");
          
            library.put(".----", "1");
            library.put("..---", "2");
            library.put("...--", "3");
            library.put("....-", "4");
            library.put(".....", "5");
            library.put("-....", "6");
            library.put("--...", "7");
            library.put("---..", "8");
            library.put("----.", "9");
            library.put("-----", "0");
    
            return library.get(key);
        
        }
    
        
               }
    
}