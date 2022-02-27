import java.util.ArrayList;

public class Cryptor{


    private static String alphabet;

    //the alphabet to use in encrypting or decrypting
    // If the alphabet changes, the output changes even though the message and key are the same
    // every character on the alphabet MUST be written ony once
    public Cryptor(){
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public String getCipherText(String message, String key){
        return "";
    }


    // String türünde bir veri alır ve tüm karakterlerini sayısal değerlere dönüştürür.
    // Takes a String and converts it to its Integer ArrayList representation
    // If there's an character that alphabet doesn't contain, the code treats it as space
    public ArrayList<Integer> toIntegerFormat(String s){

        ArrayList<Integer> integers = new ArrayList<>();
        int index;

        for(int i = 0; i < s.length();i++){

            if(s.charAt(i) == ' ' || getAlphabet().indexOf(s.charAt(i)) == -1){
                integers.add(null);
            }
            else{
                char letter = s.charAt(i);
                index = getAlphabet().indexOf(letter) + 1;
                integers.add(index);
            }


        }


        return integers;

    }

    // Converts ArrayList to String
    public String toStringFormat(ArrayList<Integer> integers){
        String message = "";


        for(Integer integer: integers){
            if(integer != null){
                char letter = getAlphabet().charAt(integer -1);
                message += letter;
            }

            else{
                message += " ";
            }

        }

        return message;
    }


    public static String getAlphabet() {
        return alphabet;
    }
}
