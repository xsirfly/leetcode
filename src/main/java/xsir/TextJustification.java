package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int wordNums = 0, currentLen = 0, res = 0, mod = 0, currentIndex = 0;
        List<String> result = new ArrayList<>();
        while (currentIndex < words.length) {
            currentLen += words[currentIndex].length();
            if (currentLen > maxWidth) {
                StringBuilder line = new StringBuilder();
                int spaceLen = (maxWidth - currentLen + words[currentIndex].length() + wordNums);
                res = wordNums - 1 == 0 ? 0 : spaceLen / (wordNums - 1);
                mod = wordNums - 1 == 0 ? spaceLen : spaceLen % (wordNums - 1);
                for (int i = currentIndex - wordNums; i < currentIndex - 1; i++) {
                    line.append(words[i]);
                    int spaceNum = (res + (mod-- > 0 ? 1 : 0));
                    for (int j = 0; j < spaceNum; j++) {
                        line.append(" ");
                    }
                }
                line.append(words[currentIndex - 1]);
                for (int i  = 0; i < mod; i++) {
                    line.append(" ");
                }
                result.add(line.toString());
                currentLen = 0;
                wordNums = 0;
            } else {
                wordNums++;
                currentLen++;
                currentIndex++;
            }
        }
        StringBuilder lastLine = new StringBuilder();
        for (int i = currentIndex - wordNums; i < currentIndex - 1; i++) {
            lastLine.append(words[i]);
            lastLine.append(" ");
        }
        lastLine.append(words[currentIndex - 1]);
        for (int i = 0; i < maxWidth - currentLen + 1; i++) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
}
