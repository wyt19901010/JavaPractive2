package com.javaeasy.learnsockettcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {								// 服务器端程序
	public static void main(String[] args) {		// main()方法
		try {
			  String str = new String();
			Scanner inn = new Scanner(System.in);


			  ServerSocket ss = new ServerSocket(7777);
											// （1）在本机的7777端口监听
			  System.out.println("服务器端在7777端口监听……"); 
			  Socket s = ss.accept();		// （2）等待客户端连接到7777端口
			  // 如果没有客户端连接过来，accept()方法不会返回
			  System.out.println("已有客户端连接过来，开始进行通信……");
			  InputStream in = s.getInputStream();	// （3）得到输入流
			  OutputStream out = s.getOutputStream();// （4）得到输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//	String response = br.readLine();
			  PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
										// 使用PrintWriter向客户端输出数据
			  System.out.println("正在向客户端发送消息……");
			 // pw.println("aaaa");
		//	pw.println("aaaa");
			  while ( true ) {
			  	System.out.println(br.readLine());
					str = inn.nextLine();
				if	(str.equalsIgnoreCase("end")){
					break;
				}
					System.out.println(str);
					pw.println(str);
			  }
			  pw.write("客户端，你好，这里是服务器端。\r\n");
			  pw.flush();				// 强制发送数据
			  System.out.println("向客户端发送消息完成。");
			  // 使用BufferedReader读取客户端发送来的数据

			  System.out.println("======下面是客户端发来的消息======");
		//	  System.out.println(response);
			  System.out.println("================================");
			  br.close();					// （5）调用close()方法释放资源
			  pw.close();
			  s.close();
			  ss.close();
		} catch (UnknownHostException e) {
			  System.out.println("无法找到相应的机器，错误信息。" + e.getMessage());
		} catch (IOException e) {
			 System.out.println("数据传输出现异常：" + e.getMessage());
		}
	}
}
