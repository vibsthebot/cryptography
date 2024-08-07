import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class transpositionWord{
    public int lowestIndex(List<Integer> list){
        int index = 0;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i)<list.get(index)){
                index=i;
            }
        }
        list.add(index, 100);
        return index;
    }
    public static int findIndex(char[] chars, char charToFind){
        for(int i = 0; i<chars.length; i++){
            if (chars[i] == charToFind) return i;
        }
        throw new Error("Input word needs to be all letters");
        
    }

    public static void main(String[] args){
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] letters = Alphabet.toCharArray();
        Scanner scan = new Scanner(System.in);
        System.out.println("Encryption or Decryption? 1 for Encryption, 2 for Decryption");
        int firstString = scan.nextInt();
        if (firstString == 1){
            System.out.println("Plaintext: ");
            String plaintext = scan.next();
            System.out.println("Key: ");
            String keyString = scan.next().toUpperCase();
            int key = keyString.length();
            char[] keyArray = keyString.toCharArray();
            int[] list = new int[key];
            for (int i = 0; i<key; i++){
                list[i] = findIndex(letters, keyArray[i]);
            }
            System.out.println(list);
            char[] charArray = plaintext.toCharArray();
            System.out.println(charArray);
            double numOfCol = (int) Math.ceil((float) charArray.length/ key);
            
            char[][] firstMatrix = new char[(int) numOfCol][key];
            int index = 0;
            //rows
            for (int i=0; i<numOfCol; i++){
                //columns
                for (int j = 0; j<key; j++){
                    if (index>=charArray.length){
                        firstMatrix[i][j] = 'x';
                    } 
                    else {
                        firstMatrix[i][j] = charArray[index];
                    }
                    
                    index++;
                }
                System.out.println(firstMatrix[i]);

            }
            char[][] finalMatrix = new char[key][(int) numOfCol];
            char[] finalArray = new char[((int) numOfCol)*key];
            for (int i=0; i<key; i++){
                //columns
                for (int j = 0; j<numOfCol; j++){
                    finalMatrix[i][j] = firstMatrix[j][i];
                }
                System.out.println(finalMatrix[i]);
            }
            char[][] finalMatrixSorted = new char[finalMatrix.length][(int) numOfCol];
            for (int i = 0; i<finalMatrix.length; i++){
               index = 0;
                for (int j = 0; j<list.length; j++){
                    if (list[j]<list[index]){
                        index=j;
                    }
                }
                System.out.println(list[index]);
                System.out.println(index);
                list[index]=100;
                finalMatrixSorted[i] = finalMatrix[index];
            }


            index = 0;
            for (int i=0; i<key; i++){
                char[] row = finalMatrixSorted[i];
                for (int j = 0; j<numOfCol; j++){
                    finalArray[index] = row[j];
                    index++;
                }
                System.out.println(row);
            }

            System.out.println(finalArray);
        }
        else if (firstString == 2){
            System.out.println("Plaintext: ");
            String plaintext = scan.next();
            System.out.println("Key: ");
            String keyString = scan.next().toUpperCase();
            int key = keyString.length();
            char[] keyArray = keyString.toCharArray();
            int[] list = new int[key];
            for (int i = 0; i<key; i++){
                list[i] = findIndex(letters, keyArray[i]);
            }
            //System.out.println(list);
            char[] charArray = plaintext.toCharArray();
            //System.out.println(charArray);
            double numOfCol = (int) Math.ceil((float) charArray.length/ key);
            
            char[][] firstMatrix = new char[key][(int) numOfCol];
            int index = 0;
            //rows
            for (int i=0; i<key; i++){
                //columns
                for (int j = 0; j<numOfCol; j++){
                    if (index>=charArray.length){
                        firstMatrix[i][j] = 'x';
                    } 
                    else {
                        firstMatrix[i][j] = charArray[index];
                    }
                    
                    index++;
                }
                System.out.println(firstMatrix[i]);

            }
            
            char[][] firstSortedMatrix = new char[key][(int) numOfCol];

            for (int i = 0; i<firstMatrix.length; i++){
                index = 0;
                 for (int j = 0; j<list.length; j++){
                     if (list[j]<list[index]){
                         index=j;
                     }
                 }
                 list[index]=100;
                 firstSortedMatrix[index] = firstMatrix[i];
                 System.out.println(firstSortedMatrix[i]);
             }
            char[][] finalMatrix = new char[(int) numOfCol][key];
            char[] finalArray = new char[((int) numOfCol)*key];
            index = 0;
            for (int i=0; i<numOfCol; i++){
                //columns
                for (int j = 0; j<key; j++){
                    finalMatrix[i][j] = firstSortedMatrix[j][i];
                    finalArray[index] = firstSortedMatrix[j][i];
                    index++;
                }
                System.out.println(finalMatrix[i]);
            }
            System.out.println(finalArray);
        }
    }
}
