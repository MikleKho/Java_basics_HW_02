// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_02_1 {
    public static void main(String[] args) throws java.io.IOException {

        Logger logger = Logger.getLogger(task_02_1.class.getName());
        FileHandler fh = new FileHandler("log_01.txt", true);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int n, arr[];
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (10 + (Math.random() * (100 - 10)));
        }
        logger.severe("Задали массив случайных чисел");

        System.out.print("Исходный массив ---> ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        boolean sorted = false;
        int temp, iter_num = 0;
        String str;
        while (!sorted) {
            sorted = true;

            iter_num++;
            str = "Итерация номер " + Integer.toString(iter_num) + "  Массив ---> ";
            for (int i : arr)
                str += Integer.toString(i) + " ";
            logger.severe(str);

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.print("Массив по возрастанию ---> ");
        for (int i : arr)
            System.out.print(i + " ");

    }

}
