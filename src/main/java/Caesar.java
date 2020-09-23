import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        int shift = 3;
        int zero = 0;
        String ynk = "";
        for (int k = 0; k < message.length(); k++){
            char qwe = message.charAt(k);
            if (65 <= qwe && qwe <= 90){
                zero = (qwe + shift - 65)%26;
                ynk += (char) (zero + 65);

            }
            else if (97 <= qwe && qwe <= 122){
                zero = (qwe + shift - 97)%26;
                ynk += (char) (zero +97);
                

            }
            else {
                ynk += qwe;
            }
            

        }
        return ynk;
        
        
    }

    public static String decryptCaesar(String message) {
        int shift = 3;
        int zero = 0;
        String ynk = "";
        for (int k = 0; k < message.length(); k++){
            char qwe = message.charAt(k);
            if ((65 <= qwe && qwe <= 90)||(97 <= qwe && qwe <= 122)){
                if ((65 <= qwe && qwe <= 67)||(97 <= qwe && qwe <= 99)){
                    ynk += (char) (qwe + 23);
                }
                else {
                    ynk += (char) (qwe - 3);
                }
                
                

            }
            
            else {
                ynk += qwe;
            }
            

        }
        return ynk;
        
    }

    public static String encryptCaesarKey(String message, int key) {
        String jkl = "";
        key = key%26;
        for (int k =0; k < message.length(); k++){
            char qax = message.charAt(k);
            if ((65 <= qax && qax <= 90)||(97 <= qax && qax <= 122)){
                if ((qax >= (90-(key-1)) && qax <= 90)||(qax >= 122-(key-1) && qax <= 122)){
                    jkl += (char) (qax-(26-key));
                }
                else {
                    jkl += (char) (qax + key);
                }
            }
            else {
                jkl += qax;
            }
        }
        return jkl;
        
    }

    public static String decryptCaesarKey(String message, int key) {
        int shift = key;
        int zero = 0;
        String wab = "";
        for (int k = 0; k < message.length(); k++){
            char pou = message.charAt(k);
            if (65 <= pou && pou <= 90){
                zero = (pou - shift - 65)%26;
                if (zero < 0){
                    zero = 26 + zero;
                }
                wab += (char) (zero + 65);

            }
            else if (97 <= pou && pou <= 122){
                zero = (pou - shift - 97)%26;
                if (zero < 0){
                    zero = 26 + zero;
                }
                wab += (char) (zero + 97);

            }
            else {
                wab += pou;
            }

        }
        return wab;

        
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
