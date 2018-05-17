package com.javaeasy.learnsockettcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		byte[] addr = new byte[] { 127, 0, 0, 1 };		// 与本机进行通信
		try {
			InetAddress local = InetAddress.getByAddress(addr);
			Socket s = new Socket(local, 7777);
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			PrintWriter out2 = new PrintWriter( new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//String response = br.readLine();
			while ( true) {
				String str = new String();
				out2.println("1");
				str = br.readLine();
				System.out.println(str);
				if (str.equalsIgnoreCase("end")){
					break;
				}
			}
			System.out.println("======下面是服务端发来的消息======");
		//	System.out.println(response);
			System.out.println("================================");
			System.out.println("正在向服务器端发送消息……");
			PrintWriter pw = new PrintWriter(out);
			pw.write("服务器你好，这里是客户端。");
			pw.flush();
			pw.close();
			br.close();
			s.close();
			System.out.println("向服务器端发送消息结束。");
		} catch (UnknownHostException e) {
			System.out.println("无法找到相应的机器，错误信息。" + e.getMessage());
		} catch (IOException e) {
			System.out.println("数据传输出现异常：" + e.getMessage());
		}
	}
}
