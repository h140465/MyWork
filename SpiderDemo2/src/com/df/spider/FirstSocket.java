package com.df.spider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class FirstSocket {
	public static void main(String args[]) {

		// 判断参数是否为两个，正确的用法为 FirstSocket 网站 页面
//		if (args.length != 2) {
//			System.out
//					.println("Usage : FirstSocket host page\r\nExample:FirstSocket www.google.com /");
//			System.exit(0);
//		}
		String strServer = "wwww.baidu.com"; // 取得第一个参数
		String strPage = "/"; // 取得第二个参数

		try {
			String hostname = strServer;
			int port = 80;
			InetAddress addr = InetAddress.getByName(hostname);
			Socket socket = new Socket("wwww.baidu.com", port); // 建立一个Socket

			// 发送命令
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream(), "UTF8"));
			 wr.write("GET " +strPage+ " HTTP/1.0\r\n");
			 wr.write("HOST:" +strServer+ "\r\n");
			wr.write("\r\n");
			wr.flush();

			// 接收返回的结果
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
