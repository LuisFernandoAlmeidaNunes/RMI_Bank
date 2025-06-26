
javac -d target/classes src/main/java/org/bank/client/Hello.java src/main/java/org/bank/client/Server.java src/main/java/org/bank/client/Client.java

taskkill /IM rmiregistry.exe /F
rem start rmiregistry -J-Djava.rmi.server.hostname=127.0.0.1 rem rodando no porto 1099

start java -classpath target\classes -Djava.rmi.server.hostname=127.0.0.1 -Djava.rmi.server.codebase=file:target\classes org.bank.client.Server
