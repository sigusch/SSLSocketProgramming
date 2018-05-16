import java.io.*;
import java.net.*;
import java.util.Random;
import javax.net.ssl.*;


public class server {

	public static void main(String[] args) throws IOException {
	
		final int port = 9090;
		int cnt = 0;
		
		SSLServerSocketFactory sslfactory;
		sslfactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
		
		try {
			System .out . println ("Waiting for connection requests on port " + port + "...");
			ServerSocket sslserversocket = sslfactory.createServerSocket(port);
			while (true) {
				Socket socket = sslserversocket.accept();
				(new EchoClientThread(++cnt,socket)).start();
			}
		} catch ( IOException e) {
		System .err . println (e. toString () ) ;
		System . exit (1) ;
		}

	}
		
	static class EchoClientThread extends Thread {
		private int id;
		private Socket socket ;
		
		public EchoClientThread (int id , Socket socket ) {
			this.id = id;
			this.socket = socket ;
		}
		
		public void run () {
			String msg = " EchoServer : connection " + id;
			System.out.println(msg + " established ") ;
			try {
				int x = new Random().nextInt(100);
				InputStream instream = socket.getInputStream ();
				InputStreamReader instreamreader = new InputStreamReader(instream);
				BufferedReader in = new BufferedReader(instreamreader);
				OutputStream outstream = socket.getOutputStream();
				OutputStreamWriter out = new OutputStreamWriter(outstream);
				out.write( msg + "\r\n");
				out.flush();
				String inline = in.readLine();
				System.out.println(inline);
				out.write("OK\n");
				out.flush();
				while (true) {
					inline = in.readLine();
					int guess = Integer.parseInt(inline);
					if (guess > x) {
						out.write("LOWER\n");
						out.flush();
					} else if (guess < x) {
						out.write("GREATER\n");
						out.flush();
					} else {
						out.write("GAME OVER\n");
						out.flush();
						break;
					}
				}
				System.out.println (" connection " + id + " terminated ") ;
				socket.close();
			} catch ( IOException e) {
				System .err . println (e. toString () ) ;
			}
		} 
	} 
}
		

