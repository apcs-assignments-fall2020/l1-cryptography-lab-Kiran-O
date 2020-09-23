import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        int zero = 0;
        String tre = "";
        for (int k = 0; k < message.length(); k++){
            int shift = key.charAt(zero)+65;
            int gba = message.charAt(k);
            if (zero == key.length()){
                zero = 0;

            }
            if (gba < 91 && gba > (shift + 64)||(gba < 123 && gba > (shift + 96))){
                tre += (char) (gba + shift);
                zero += 1;

            }
            else if (gba < 91 && gba > 64){
                tre += (char) (91 + shift + (gba%65));
                zero += 1;
            
            }
            else if (gba < 123 && gba > 96){
                tre += (char) (123 + shift + (gba%97));
                zero += 1;
            }
            else {
                tre += gba;
            }
            

        }
        return tre;
    }

    public static String decryptVigenere(String message, String key) {
        int zero = 0;
        String tre = "";
        for (int k = 0; k < message.length(); k++){
            int shift = key.charAt(zero)-65;
            int gba = message.charAt(k);
            if (zero == key.length()){
                zero = 0;

            }
            if (gba < 91 && gba > (shift + 64)||(gba < 123 && gba > (shift + 96))){
                tre += (char) (gba - shift);
                zero += 1;

            }
            else if (gba < 91 && gba > 64){
                tre += (char) (91 - shift + (gba%65));
                zero += 1;
            
            }
            else if (gba < 123 && gba > 96){
                tre += (char) (123 - shift + (gba%97));
                zero += 1;
            }
            else {
                tre += gba;
            }
            

        }
        return tre;
        
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
