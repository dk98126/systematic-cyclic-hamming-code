public class Decoder {
    private static final int FX = 0b10000001;    //x7+1
    private static final int GX = 0b00001011;    //x3+x+1
    private static final int HX = 0b00010111;    //x4+x2+x+1
    private static final int N = 7;
    private static final int K = 4;
    private static int[] syndromes = new int[7];

    static {
        int error = 0b1;
        for (int i = 0; i < 7; i++) {
            syndromes[i] = Coder.getMode(multiply(error, HX), FX);
            System.out.println(Integer.toBinaryString(syndromes[i]));
            error <<= 1;
        }
    }

    public int decode (int codeWordWithError) {
        int errorIndex = 0;
        int syndrome = Coder.getMode(multiply(codeWordWithError, HX), FX);
        for (int i = 0; i < syndromes.length; i++)
            if (syndrome == syndromes[i]) {
                errorIndex = i;
                break;
            }
        return (codeWordWithError ^ (0b1 << errorIndex)) >> (N-K);
    }

    public static int multiply(int word, int polynomial) {
        byte[] bytes = Integer.toBinaryString(polynomial).getBytes();
        int tmpWord = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == '1')
                tmpWord = tmpWord ^ (word << (bytes.length - i - 1));
        }
        return tmpWord;
    }
}
