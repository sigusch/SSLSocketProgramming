import java.io.*;
import java.net.*;

import javax.net.ssl.SSLSocketFactory;

public class client {

	public static void main(String [] args ) {
		try {
			SSLSocketFactory sslsocketfactory;
			Socket sslsock;
			sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			sslsock = sslsocketfactory.createSocket("10.0.0.4", 9090);
			InputStream instream = sslsock.getInputStream ();
			InputStreamReader instreamreader = new InputStreamReader(instream);
			BufferedReader in = new BufferedReader(instreamreader);
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			OutputStream outstream = sslsock.getOutputStream();
			OutputStreamWriter out = new OutputStreamWriter(outstream);
			String msg = in.readLine();
			System.out.println(msg);
			String outmsg = "HELLO\n";
			out.write(outmsg);
			out.flush();
			msg = in.readLine();
			System.out.println(msg);
			while (outmsg.length() != -1) {
				outmsg = input.readLine();
				out.write(outmsg + "\n");
				out.flush();
				msg = in.readLine();
				System.out.println(msg);
			}
			in.close();
			out.close();
			sslsock . close () ;
		} catch ( IOException e) {
		System.err.println(e.toString () ) ;
		System.exit (1) ;
		}
	} // main


}
