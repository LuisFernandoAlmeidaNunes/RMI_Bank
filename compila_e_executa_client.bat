@echo off
setlocal

rem export CLASSPATH = $CLASSPATH:src/main/java/org/bank/client
set CLASSPATH=%CLASSPATH%;src\main\java\org\bank\client

REM Ajuste para o caminho do seu arquivo de política
set POLICY_PATH=permissoes.txt

echo Iniciando rmiregistry com política de segurança...

REM Encerra processo antigo (pode variar no Windows)
taskkill /IM rmiregistry.exe /F >nul 2>&1

start "" rmiregistry -J-Djava.rmi.server.hostname=192.168.15.10 -J-Djava.security.policy=%POLICY_PATH% -J-Djava.security.manager

timeout /t 2

echo Compilando arquivos Java...

call mvn compile
echo Código de saída do package: %ERRORLEVEL%

echo Empacotando arquivos Java...

call mvn package
echo Código de saída do package: %ERRORLEVEL%


echo Executando servidor...

start java -Djava.rmi.server.hostname=192.168.15.10 -Djava.security.policy=%POLICY_PATH% -Djava.security.manager Controller

timeout /t 2


echo Executando controle...
rem java -jar Controller.jar
java -cp target\classes org.bank.client.Controller

echo Executando cliente...
java -cp target\classes org.bank.client.Client

rem java -Djava.rmi.server.hostname=192.168.15.10 -Djava.security.policy=%POLICY_PATH% -Djava.security.manager  Client

pause
