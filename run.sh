#!/bin/bash

cd build/libs/

if [ "$1" == "server" ]
then
#    java -cp client-including-all-dependencies.jar ru.vtb.s7.client.mkb.testServer.TestServer
    bash run-testServer.sh
fi

if [ "$1" == "client" ]
then
#    java -jar client-including-all-dependencies.jar
    bash run-client.sh
fi

cd -
