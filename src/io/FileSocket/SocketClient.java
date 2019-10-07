package io.FileSocket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/10/6
 **/
public class SocketClient implements Runnable {
    private static final String SERVER_IP = "127.0.0.1"; // 服务端IP
    private static final int SERVER_PORT = 8088; // 服务端端口

    private Socket client;

    private FileInputStream fis;

    private DataOutputStream dos;

    private String path;

    public SocketClient(String path) {
        this.path = path;
    }

    public void sendFile() throws IOException {
        try {
            client = new Socket(SERVER_IP, SERVER_PORT);
            File file = new File(path);
            if (file.exists()) {
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());

                // 文件的绝对路径
                dos.writeUTF(path);
                dos.flush();

                // 开始传输文件
                System.out.println("======== 开始传输文件 [" + file.getName() + "]========");
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                    progress += length;
                    System.out.print("| " + (100 * progress / file.length()) + "% |");
                }
                System.out.println();
                System.out.println("======== 文件传输成功 ========");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public static void listAllFiles(File dir) throws IOException {
        if (dir == null || !dir.exists()) {
            return;
        }

        if (dir.isFile()) {
            //System.out.println(dir.getAbsolutePath());
            new Thread(new SocketClient(dir.getAbsolutePath())).start();
            return;
        }

        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    private void closeAll() throws IOException {
        if (fis != null) {
            fis.close();
        }
        if (dos != null) {
            dos.close();
        }
        client.close();
    }


    public static void main(String[] args) {
        try {
            SocketClient.listAllFiles(new File("D:\\test\\data"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            sendFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
