import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 12345;
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running and waiting for client...");
        //tạo một đối tượng datagram Socket để liên kết đến 1 cổng cụ thể 8888 trên máy chủ


        byte[] receiveData = new byte[1024];
        // tạo 1 mảng byte để nhận dữ liệu từ gói tin nhận được

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        //Tạo 1 đối tượng datagramPacket để nhận goí tin từ Client

        serverSocket.receive(receivePacket);
        //Nhận gói tin từ client

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();
        //Lấy địa chỉ IP và port của client

        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from client: " + message);
        //Chuyển đổi duwx liệu thành dạng chuỗi

        String responseMessage = "Hello, client!";
        byte[] sendData = responseMessage.getBytes();
        // chuẩn bị dữ liệu gửi đi

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        serverSocket.send(sendPacket);
        serverSocket.close();
    }
}
