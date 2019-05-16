public class Coder {
    private static final int FX = 0b10000001;    //x7+1
    private static final int GX = 0b00001011;    //x3+x+1
    private static final int HX = 0b00010111;    //x4+x2+x+1
    private static final int N = 7;
    private static final int K = 4;

    public int code(int infoWord) {
        return (infoWord << (N - K)) ^ getMode(infoWord << (N - K), GX);
    }

    public static int getMode(int word, int polynomial) {
        String wordString = Integer.toBinaryString(word);
        String polynomialString = Integer.toBinaryString(polynomial);
        int wordPower = wordString.length();
        int polynomialPower = polynomialString.length();
        while (wordPower + 1 > polynomialPower) {
            int shiftedPolynomial = polynomial << (wordPower - polynomialPower);
            word = word ^ shiftedPolynomial;
            wordString = Integer.toBinaryString(word);
            wordPower = wordString.length();
        }
        return word;
    }
}
