
public class KarpRabin {

    public static void main(String[] args) {
        Algorithm algo = new Algorithm();
        algo.search("KunalSohamSahilHarsh", "Soham");
    }
}

class Algorithm {

    private final int PRIME = 101;

    public double calculateHash(String str) {
        double hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        int textLength = text.length();
        double textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= (textLength - patternLength); i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i <= textLength - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }

    }

    public double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash += newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }
}
