package com.dartin.project.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Asus Strix on 15.06.2017.
 */
public class MessageSender implements Runnable {
    private int port;
    private String ip;
    private byte[] message;

    public MessageSender(byte[] message, String ip, int port) {
        this.message = message;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            DatagramPacket packet = new DatagramPacket(message, message.length, InetAddress.getByName(ip), port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            System.out.println("Message sent successfully " + "to ip:" + this.ip + ": " + this.port);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("sending failed");
        }

    }
}
