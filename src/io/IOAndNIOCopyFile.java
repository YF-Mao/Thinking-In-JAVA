package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOAndNIOCopyFile {

	public static void main(String[] args) throws Exception {
        new IOAndNIOCopyFile().testIoCopy();
	}

	public static void nioCopyFile(String resource, String destination)
			throws Exception {
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		//读文件通道
		FileChannel readChannel = fis.getChannel();
		//写文件通道
		FileChannel writeChannel = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);
		while (true) {
			buffer.clear();
			int len = readChannel.read(buffer); // 读入数据
			if (len == -1) {
				break;
			}
			buffer.flip();
			writeChannel.write(buffer); // 写入文件
		}
		readChannel.close();
		writeChannel.close();
	}

	public static void ioCopyFile(String resource, String destination)
			throws Exception {
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		byte[] buffer = new byte[1024 * 8];
		int count = 0;
		while ((count = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, count);
		}
		fos.close();
		fis.close();
	}

	public void testIoCopy() throws Exception {		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			ioCopyFile("C:\\github\\Thinking-In-JAVA\\Blip3.out", "C:\\github\\Thinking-In-JAVA\\Blip3copy1.out");
		}
		System.out.println("io耗时" + (System.currentTimeMillis() - start) + "ms");
      
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			nioCopyFile("C:\\github\\Thinking-In-JAVA\\Blip3.out", "C:\\github\\Thinking-In-JAVA\\Blip3copy2.out");
		}
		System.out.println("nio耗时" + (System.currentTimeMillis() - start) + "ms");
	}
	
}
