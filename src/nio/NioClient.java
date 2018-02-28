package nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NioClient {
	public static void main(String[] args) {
		client();

	}
	public static void client(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try
        {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",9999));
 
            if(socketChannel.finishConnect())
            {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
	public static void socketClient() throws UnknownHostException, IOException{
		//客户端 的功能：1、链接服务器  2、发信息
	    Socket s=new Socket("127.0.0.1",9999);//写服务器端的地址和端口，端口号需要与服务器端代码监听的端口号一致才能建立连接。
	    System.out.println("时间:"+new Date()+"，建立了与服务器的链接");

	    //输出流，服务器接收
	    OutputStream oos=s.getOutputStream();
	    oos.write("夏天来了，天真热！".getBytes());
	    oos.flush();
	   
	    
	    
	    InputStream ins=s.getInputStream();
	    byte[] arr=new byte[128];
	    while(ins.read(arr)!=-1){
	    	System.out.println(new String(arr,"UTF-8"));
	    	 oos.write("收到消息".getBytes());
	    }
	    oos.close();
	    s.close();
	}
	 
}
