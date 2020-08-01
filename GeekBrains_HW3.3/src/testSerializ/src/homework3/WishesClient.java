package homework3;

import java.io.Serializable;
import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class WishesClient {

        private static class DataObj implements Serializable {
                private String text;

                public DataObj(String text) {
                        this.text = text;
                }

                @Override
                public String toString() {
                        return "Данные " + text;
                }
        }

        public static void main(String args[]) throws Exception {

                Socket sock = new Socket("127.0.0.1", 5000);// два параметра (адрес сервера и номер порта);

                DataObj dataOut = new DataObj( "Hello client!" );

                OutputStream ostream = sock.getOutputStream();//связываем сокет с потоками;
                DataOutputStream dos = new DataOutputStream(ostream);//отправляем клиентский сокет на другой сокет на сервере;
                dos.writeBytes(dataOut.toString());

                //закрываем все потоки;
                dos.close();
                ostream.close();
                sock.close();
        }
}


