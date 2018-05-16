# FHHgb.NEP4.SSLSocketProgramming
This project was created during the network programming course.

Keystores for this project were created with https://docs.oracle.com/javase/6/docs/technotes/tools/windows/keytool.html

commands for running server and client application
server:
java -Djavax.net.ssl.keyStore={path to server keystore} -Djavax.net.ssl.keyStorePassword=netzwerk server

client:
java -Djavax.net.ssl.trustStore={path to client keystore} -Djavax.net.ssl.trustStorePassword=netzwerk client
