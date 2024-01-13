import java.io.*;
import java.nio.file.Path;

public class Encryption {
    static void doEncrypt() {
        Path path = Init.check();
        int key = Init.key();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path.toFile()));
            String line;
            StringBuilder message = new StringBuilder();
            while((line = bf.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    int charPosition = Init.findIndex(line.charAt(i));
                    int keyVal = (charPosition + key) % 38;
                    char replaceVal = Init.findChar(keyVal);
                    if (i == line.length() - 1) {
                        message.append(replaceVal).append("\n");
                    } else {
                        message.append(replaceVal);
                    }
                }
            }
            System.out.println(message);
            Init.writeFile(message.toString());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
