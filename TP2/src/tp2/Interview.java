package tp2;

import java.io.*;
import java.util.HashMap;

public final class

Interview {

    /** TODO
     * This function returns if the two texts are similar based on if they have a similar entropy of the HashMap
     * @return boolean based on if the entropy is similar
     */
    public static Double compareEntropies(String filename1, String filename2) throws IOException {
        var hMapFromFilename1 = getFrequencyHashTable(readFile(filename1));
        var hMapFromFilename2 = getFrequencyHashTable(readFile(filename2));
        return Math.abs(calculateEntropy(hMapFromFilename1)-calculateEntropy(hMapFromFilename2));
    }

    /** TODO
     * This function returns the difference in frequencies of two HashMaps which corresponds
     * to the sum of the differences of frequencies for each letter.
     * @return the difference in frequencies of two HashMaps
     */
    public static Integer compareFrequencies(String filename1, String filename2) throws IOException{
        int diff =0;
        var hMapFromFilename1 = getFrequencyHashTable(readFile(filename1));
        var hMapFromFilename2 = getFrequencyHashTable(readFile(filename2));
        for(char c: hMapFromFilename1.keySet()) {
            if (hMapFromFilename2.containsKey(c)) {
                diff+= Math.abs((hMapFromFilename1.get(c)-hMapFromFilename2.get(c)));
            }
            else if (!hMapFromFilename2.containsKey(c)) diff+= hMapFromFilename1.get(c);
        }
        for(char c: hMapFromFilename2.keySet()) {
            if (!hMapFromFilename1.containsKey(c) ) {
                diff+= hMapFromFilename2.get(c);
            }
        }
        return diff;
    }

    /** TODO
     * @return This function returns the entropy of the HashMap
     */
    public static Double calculateEntropy(HashMap<Character, Integer> map){
          double entropy = 0.0;
          double size = 0.0;
        for( double value: map.values())
        {
           size+=value;
        }
          for( double value: map.values()) {
              double frequency = value / size;
              entropy -= (frequency * (Math.log(frequency) / Math.log(2)));
          }
        return  entropy;
    }

    /**
     * This function reads a text file {filename} and returns the appended string of all lines
     * in the text file
     */
    public static String readFile(String filename) throws IOException {
        // we want to read line by line,so we use BufferedReader
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String rawData;
        StringBuilder sb = new StringBuilder();
        while ((rawData = br.readLine()) != null) {
            sb.append(rawData);
        }
        //remove newlines
        return sb.toString().replace('\n', ' ');
    }

    /** TODO
     * This function takes a string as a parameter and creates and returns a HashTable
     * of character frequencies
     */
    public static HashMap<Character, Integer> getFrequencyHashTable(String text) {
       var map =  new HashMap<Character,Integer>();
       char[] charsOfText = text.toCharArray();
       for (char c : charsOfText) {
           if (isAlphabetic(c) && !map.containsKey(c)) map.put(c, 1);
           else if (isAlphabetic(c) && map.containsKey(c)) {
               Integer oldValue = map.get(c);
               map.replace(c, oldValue, oldValue + 1);
           }
       }
       return map;
    }

    /** TODO
     * This function takes a character as a parameter and returns if it is a letter in the alphabet
     */
    public static Boolean isAlphabetic(Character c){
        return (Character.isLetter(c) );
    }
}
