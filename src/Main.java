import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите режим работы:");
        System.out.println("1. Шифруем");
        System.out.println("1. Дешифруем");
        System.out.println("3");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        if (index == 1) {
            System.out.println("Дайте файл");
            System.out.println("Дайте ключ");
            Encryption.doEncrypt();

        } else if (index == 2) {
            System.out.println("Дайте файл");
            System.out.println("Дайте ключ");
            Decryption.doDecrypt();

        } else if (index == 3) {
            System.out.println("Дайте файл");
            System.out.println("Дайте ключ");
            BruteForce.doBruteForce();

        } else {
            System.out.println("Такого режима нет!");
        }
    }
}

