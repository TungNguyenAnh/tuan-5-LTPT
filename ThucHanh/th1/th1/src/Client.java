import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIp = "localhost";
        int serverPort = 12345;
        DatagramSocket clientSocket = new DatagramSocket();
        //Tạo địa chỉ IP, Port của server và một đối tượng DatagramSocket để kết nối với máy chủ.


        String message = "Hello, server!";
        byte[] sendData = message.getBytes();
        //Tạo một mảng byte chứa dữ liệu tin nhắn cần gửi


        InetAddress serverAddress = InetAddress.getByName(serverIp);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);
        //Gửi gói tin đến server


        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // Chuẩn bị mảng byte để nhận dữ liệu từ server


        clientSocket.receive(receivePacket);
        // Nhận gói tin từ server


        String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from server: " + responseMessage);
        //Chuyển đổi dữ liệu thành dạng chuỗi và hiển thị


        clientSocket.close();
        // Đóng kết nối DatagramSocket
    }
}
