package com.javaeasy.learnsocketudp;

import java.io.IOException;							// 引入需要使用的类
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPReceive {
	public static void main(String[] args) {
		try {
			// 构造用于接收数据的DatagramPacket对象
			System.out.println("构建DatagramPacket对象……");
			byte[] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			System.out.println("使用DatagramPacket对象接收数据……");
			// 在7777端口监听，等待接收数据。
			DatagramSocket ds = new DatagramSocket(7777);
			ds.receive(dp);							// 等待数据到来
			System.out.println("数据接收完毕。");
			byte[] recData = dp.getData();			// 分析数据，输出到控制台
			int len = dp.getLength();
			String content = new String(recData, 0, len);
			System.out.println("接收到的数据为：" + content);
			ds.close();								// 关闭，释放资源
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
