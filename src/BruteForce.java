import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;

public class BruteForce {
    static void doBruteForce(){
        try {
            Path path = Init.check();
            String line;
            Scanner sc = new Scanner(System.in);
            StringBuilder message = new StringBuilder();
            int count = 1;
            while(count < Init.size()) {
                message = new StringBuilder();
                System.out.println("Ключ: " + count);
                BufferedReader bf = new BufferedReader(new FileReader(path.toFile()));
                while((line = bf.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) {
                        int charPosition = Init.findIndex(line.charAt(i));
                        int keyVal = (charPosition - count + Init.size()) % Init.size();
                        char replaceVal = Init.findChar(keyVal);
                        if (i == line.length() - 1) {
                            message.append(replaceVal).append("\n");
                        } else {
                            message.append(replaceVal);
                        }
                    }
                }
                count++;
                System.out.println(message);
                System.out.println("Продолжать подбор?: Yes / No");
                if (sc.nextLine().equalsIgnoreCase("no")) {
                    break;
                }
            }

            Init.writeFile(message.toString());

        }  catch (Exception e) {
            e.getStackTrace();
        }
    }
}
