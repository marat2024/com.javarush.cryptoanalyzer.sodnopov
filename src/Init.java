import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Init {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void initMethod() throws IOException {
        System.out.println("Выберите режим работы:");
        System.out.println("1. Шифруем");
        System.out.println("2. Дешифруем");
        System.out.println("3. Метод подбора");
        Scanner scanner = new Scanner(System.in);
        int index;
        while(true) {
            System.out.print("Введи число: ");
            index = scanner.nextInt();

            if (index == 1) {
                Encryption.doEncrypt();
                break;
            } else if (index == 2) {
                Decryption.doDecrypt();
                break;
            } else if (index == 3) {
                BruteForce.doBruteForce();
                break;
            } else {
                System.out.println("Такого режима нет!");
            }
        }
    }

    public static Path check() {
        Path res;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Дайте файл");
            res = Path.of(scanner.nextLine());
            if (Files.notExists(res) || !Files.isRegularFile(res)) {
                System.out.println("Файла не существует. Попробуй еще!");
            } else if(Files.exists(res) || Files.isRegularFile(res)) {
                break;
            }
        }
        return res.toAbsolutePath();
    }

    public static int key() {
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true) {
            System.out.println("Введите ключ! ");
            str = scanner.nextLine();
            char c = str.charAt(0);
            if (!Character.isDigit(c)) {
                System.out.println("Попробуй еще!");
            } else {
                break;
            }
        }
        return Integer.parseInt(str);
    }

    public static int findIndex(char c) {
        int res = 0;
        for (int i = 0; i < ALPHABET.length; i++) {
            if (c == ALPHABET[i]) {
                res = i;
            }
        } return res;
    }

    public static char findChar(int index) {
        char res = ' ';
        for (int i = 0; i < ALPHABET.length; i++) {
            if (index == i) {
                res = ALPHABET[i];
            }
        } return res;
    }

    public static void writeFile(String s) {
        System.out.print("Куда записать файл: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        try {
            File file = new File(name);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] strToBytes = s.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
            System.out.println("Файл записан!");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
