# FHHgb.NEP4.SSLSocketProgramming
This project was created during the network programming course. It implements a simple Server - Client communication in form of a number guessing game in Java.

Keystores for this project were created with https://docs.oracle.com/javase/8/docs/technotes/tools/unix/keytool.html

commands for running server and client application

server:

java -Djavax.net.ssl.keyStore={path to server keystore} -Djavax.net.ssl.keyStorePassword={pw} server

client:

java -Djavax.net.ssl.trustStore={path to client keystore} -Djavax.net.ssl.trustStorePassword={pw} client
