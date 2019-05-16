public class Main {
    private static final int HX = 0b00010111;
    private static final int FX = 0b10000001;

    public static void main(String[] args) {
        Coder coder = new Coder();
        Channel channel = new Channel();
        Decoder decoder = new Decoder();
        int codeWord = coder.code(0b1001);
        System.out.println(Integer.toBinaryString(codeWord) + " - кодовое слово");
        int codeWordWithError = channel.addError(codeWord, 0b1000000);
        System.out.println(Integer.toBinaryString(codeWordWithError) + " - кодовое слово с ошибкой");
        int decodedWord = decoder.decode(codeWordWithError);
        System.out.println(Integer.toBinaryString(decodedWord) + " - декодированное слово");
    }
}
