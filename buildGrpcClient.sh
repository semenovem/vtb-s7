#!/bin/bash

# скрипт для запуска билда для реального клиента afsc
# не относится к программе

clear

#bash dev-scripts/gen-cert.sh
gradle clean build

cp assets/cert/* build/libs/

# параметр 100 - для возможности запуска из директории
#if [ "$1" == "100" ]
#then
    # старт сервера из директории
    FILE=build/libs/run-testServer.sh
    touch $FILE
    echo '#!/bin/bash' > $FILE
    echo '' >> $FILE
    echo 'java -cp client-including-all-dependencies.jar ru.vtb.s7.client.mkb.testServer.TestServer' >> $FILE
    unset FILE

    # старт реального клиента из директории
    FILE=build/libs/run-client.sh
    touch $FILE
    echo '#!/bin/bash' > $FILE
    echo '' >> $FILE
    echo 'java -cp client-including-all-dependencies.jar ru.vtb.afsc.Main' >> $FILE
#    echo 'java -jar client-including-all-dependencies.jar' >> $FILE
    unset FILE
#fi

# и сразу стартуем тестовый сервер
bash run.sh client
