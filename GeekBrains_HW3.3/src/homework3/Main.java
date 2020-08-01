package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Main.readFile("test1.txt");

        Main.constructorFiles();

        Main.pageReadFile();

    }

    //Задание1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
    public static void readFile(String fileName) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));//буфферизация ввода;
            ByteArrayOutputStream out = new ByteArrayOutputStream();//вывод в массиве байтов;

            int x = in.read();
            while (x != -1) {
                out.write(x);
                x = in.read();
            }

            System.out.println(out.toByteArray());
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Задание2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
    public static void constructorFiles() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        try {
            al.add(new FileInputStream("1.txt"));
            al.add(new FileInputStream("2.txt"));
            al.add(new FileInputStream("3.txt"));
            al.add(new FileInputStream("test.txt"));
            al.add(new FileInputStream("test1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream (Collections.enumeration(al)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));

        int x = in.read();
        while (x != -1) {
            out.write(x);
            x = in.read();
            //System.out.println((char)x);
        }

        in.close();
        out.close();
    }

    //Задание3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
    // Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль. Контролируем время
    // выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.

    public static void pageReadFile(){
        final int pageSize = 1800;
        try {
            RandomAccessFile page = new RandomAccessFile("Shildt.txt", "r");
            Scanner in = new Scanner(System.in);
            System.out.println("Введите страницу:");
            int a = in.nextInt();
            page.seek(a * pageSize);
            byte[] barr = new byte[1800];
            page.read(barr);
            System.out.println(new String(barr));
            page.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Задание4. Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.


}
