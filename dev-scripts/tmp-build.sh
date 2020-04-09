#!/bin/bash


bash dev-scripts/gen-cert.sh
gradle clean build

cp assets/cert/* build/libs/


FILE=build/libs/server-run.sh
touch $FILE
echo '#!/bin/bash' > $FILE
echo '' >> $FILE
echo 'java -cp client-including-all-dependencies.jar ru.vtb.blockchain.client.mkb.testServer.TestServer' >> $FILE
unset FILE


FILE=build/libs/client-run.sh
touch $FILE
echo '#!/bin/bash' > $FILE
echo '' >> $FILE
echo 'java -jar client-including-all-dependencies.jar' >> $FILE
unset FILE



scp build/libs/* pi@raspberrypi:~/_dev/grpc





