package com.df.spider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URL;

public class SocketSpider {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://cn.hc360.com/js/4/");
			System.out.println(url.getHost());
			Socket socket = new Socket(url.getHost(), 80);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));

			// socket.setSoTimeout(1000);
			bw = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));

			bw.write("GET " + url.getPath() + " HTTP/1.0\r\n");
			bw.write("HOST:" + url.getHost() + "\r\n");
			bw.write("\r\n");// 在行的结束符\r\n之前没有任何数据，说明这时候http head输出给服务器端完成
			bw.flush();// 清空缓存流

			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream(),"gb2312"));
			StringBuilder stringBuilder = new StringBuilder();

			String line = null;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				stringBuilder.append(line + "\n");
			}
			System.out.println(stringBuilder.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
