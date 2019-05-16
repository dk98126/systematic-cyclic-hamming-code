public class Channel {
    public int addError (int codeWord , int error) {
        return codeWord ^ error;
    }
}
