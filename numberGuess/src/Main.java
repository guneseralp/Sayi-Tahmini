import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        //int number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int right =0;
        int select;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

       
        while (right < 5) {
            System.out.print("Lütfen tahmininizi giriniz : ");
            select = input.nextInt();

            if (select < 0 || select > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (select == number) {
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğiniz sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz !");
                if (select > number) {
                    System.out.println(select + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(select + " sayısı, gizli sayıdan küçüktür.");
                }

                wrong[right++] = select;
                System.out.println("Kalan hak : " + (5 - right));
            }
        }
            if (!isWin) {
                System.out.println("Kaybettiniz ! ");
                if (!isWrong) {
                    System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
                }
            }
    }
}
