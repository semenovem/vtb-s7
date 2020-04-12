#!/bin/bash

cd build/libs/

if [ "$1" == "server" ]
then
    java -cp client-including-all-dependencies.jar ru.vtb.s7.client.mkb.testServer.TestServer
fi

if [ "$1" == "client" ]
then
    java -jar client-including-all-dependencies.jar
fi

cd -
