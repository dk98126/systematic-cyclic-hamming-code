import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class ToFileTest {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("coderTest.csv"))) {
            Formatter formatter = new Formatter();
            formatter.format("%s;%s;%s;%s", "информационное слово", "кодовое слово", "ошибка", "декодированное слово");
            writer.write(formatter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
