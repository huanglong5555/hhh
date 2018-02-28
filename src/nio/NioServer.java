package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
	 public static void main(String[] args) throws Exception {  
		    // 1、初始化一个ServerSocketChannel  
		    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();  
		    InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);  
		    serverSocketChannel.configureBlocking(false);// 设置为非阻塞模式，后续的accept()方法会立刻返回  
		    serverSocketChannel.socket().bind(inetSocketAddress, 1024);// 监听本地9999端口的请求，第二个参数限制可以建立的最大连接数  
		    Selector selector = Selector.open();  
		    /** 
		     * 将通道注册到一个选择器上(非阻塞模式与选择器搭配会工作的更好) 
		     * 注意register()方法的第二个参数。这是一个“interest集合”，意思是在通过Selector监听Channel时对什么事件感兴趣。 
		     * 可以监听四种不同类型的事件：OP_CONNECT，OP_ACCEPT，OP_READ，OP_WRITE 
		     * 如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来：SelectionKey.OP_READ | SelectionKey.OP_WRITE 
		     */  
		    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  
		  
		    // 2、监听连接请求并处理  
		    while (true) {  
		      int connects = selector.select(2000);// 每次最多阻塞2秒  
		  
		      if (connects == 0) {  
		        //System.out.println("没有请求...");  
		        continue;  
		      } else {  
		       // System.out.println("请求来了...");  
		      }  
		  
		      // 获取监听到有连接请求的channel对应的selectionKey  
		      Set<SelectionKey> selectedKeys = selector.selectedKeys();  
		      // 遍历selectionKey来访问就绪的通道  
		      Iterator<SelectionKey> selectedKeyIterator = selectedKeys.iterator();  
		      while (selectedKeyIterator.hasNext()) {  
		        SelectionKey selectionKey = selectedKeyIterator.next();  
		        if (selectionKey.isValid()) {  
		  
		          if (selectionKey.isAcceptable()) {// 接收就绪  
		            ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();  
		            // 返回一个包含新进来的连接SocketChannel，因为前面设置的非阻塞模式，这里会立即返回。  
		            SocketChannel socketChannel = channel.accept();  
		            if (socketChannel == null) {  
		              return;  
		            }  
		            socketChannel.configureBlocking(false);  
		            socketChannel.register(selector, SelectionKey.OP_READ);  
		            System.out.println("连接建立完成");  
		            doWrite(socketChannel, "connection is established");// 连接建立完成，给客户端发消息  
		  
		          } else if (selectionKey.isReadable()) {// 读就绪  
		  
		            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();  
		            ByteBuffer readBuffer = ByteBuffer.allocate(10);  
		            while ((socketChannel.read(readBuffer)) > 0) {// // 读取客户端发送来的消息  
		              readBuffer.flip();  
		              byte[] bytes = new byte[readBuffer.remaining()];  
		              readBuffer.get(bytes);  
		              String body = new String(bytes, "utf-8");  
		              System.out.println(body);
		              doWrite(socketChannel, body);// 将客户端发送的内容原封不动的发回去  
		              readBuffer.clear();  
		            }  
		            //socketChannel.close();//读取数据完毕后关闭连接，如果不关闭一直处于连接状态。  
		  
		          }  
		        }  
		  
		        selectedKeyIterator.remove(); // 注意每次必须手动remove()，下次该通道变成就绪时，Selector会再次将其放入已选择键集中  
		      }  
		    }  
		  }  
		  
		  private static void doWrite(SocketChannel socketChannel, String response) throws IOException {  
		    if (response==null||response.isEmpty()) {  
		      byte[] bytes = response.getBytes();  
		      ByteBuffer writeBuffer = ByteBuffer.allocate(1024);  
		      writeBuffer.put(bytes);  
		      writeBuffer.flip();  
		      // 发送消息到客户端  
		      socketChannel.write(writeBuffer);  
		      writeBuffer.clear();  
		    }  
		  
		  }  
}
