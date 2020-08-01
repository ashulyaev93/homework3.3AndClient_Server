package homework3;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;

public class WishesServer {

        public static void main(String args[]) throws Exception {

                ServerSocket sersock = new ServerSocket(5000);
                System.out.println("server is ready");
                Socket sock = sersock.accept();//привязка соединения по номеру порта;

                InputStream istream = sock.getInputStream();//входной поток для получения сообщений;
                DataInputStream dstream = new DataInputStream(istream);// т.к InputStream абстрактный связываем с DataInputStream;

                //чтение сообщения с сокета и возврат;
                String message2 = dstream.readLine();
                System.out.println(message2);

                //закрываем все потоки;
                dstream .close();
                istream.close();
                sock.close();
                sersock.close();
        }
}

