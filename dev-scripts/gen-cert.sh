#!/bin/bash

# генерация сертификатов
# todo сейчас скрипт переходит в директорию, куда должен записать сертификаты
# сделать, что бы не преходил через `cd`. в -out передать полное имя с диреткорией назначения


# ------------
# конфирурации
CLIENT_CONFIG="$ROOT_PATH/$SCRIPT_DIR_NAME/ca-openssl-client.conf"
SERVER_CONFIG="$ROOT_PATH/$SCRIPT_DIR_NAME/ca-openssl-server.conf"

#  директория с сертификатами (в корне проекта)
CERT_DIR="/assets/sert"


START_RATH=$(pwd)
ROOT_PATH=''

SCRIPT_DIR_NAME='dev-scripts'

if [ -d "./$SCRIPT_DIR_NAME" ]; then ROOT_PATH=$(pwd)
else
    if [ -d "../$SCRIPT_DIR_NAME" ]
    then
        cd .. > /dev/null
        ROOT_PATH=$(pwd)
        cd - > /dev/null
    fi
fi

if ! [ "$ROOT_PATH" ]
then
    echo "Sorry! The script can be run from the root of the project or from $SCRIPT_DIR_NAME"
    exit 1
fi

DIR="$ROOT_PATH/$CERT_DIR"

mkdir -p "$DIR"

if ! [ -d "$DIR" ]
then
    echo "Error creating directory \"$DIR\""
    exit
fi

# пока так - не нужны предыдущие файлы
cd "$DIR" || exit
rm *


# --------------
# ca

openssl req -x509 -newkey rsa:4096 -keyout badserver.key -out badserver.pem \
  -days 3650 -nodes -config "$CLIENT_CONFIG"

openssl req -x509 -new -newkey rsa:4096 -nodes -keyout ca.key -out ca.pem \
  -config "$CLIENT_CONFIG" -days 365 -extensions v3_req


openssl genrsa -out client.key.rsa 4096
openssl pkcs8 -topk8 -in client.key.rsa -out client.key -nocrypt
openssl req -new -key client.key -out client.csr -config "$CLIENT_CONFIG"


openssl x509 -req -CA ca.pem -CAkey ca.key -CAcreateserial -in client.csr \
  -out client.pem -days 365




#  server0 is issued by CA:
# ------------------------

openssl genrsa -out server0.key.rsa 4096
openssl pkcs8 -topk8 -in server0.key.rsa -out server0.key -nocrypt
openssl req -new -key server0.key -out server0.csr -config "$SERVER_CONFIG"


openssl x509 -req -CA ca.pem -CAkey ca.key -CAcreateserial -in server0.csr \
  -out server0.pem -days 365


#openssl genrsa -out server1.key.rsa 4096
#openssl pkcs8 -topk8 -in server1.key.rsa -out server1.key -nocrypt
#openssl req -new -key server1.key -out server1.csr -config "$SERVER_CONFIG"

#openssl x509 -req -CA ca.pem -CAkey ca.key -CAcreateserial -in server1.csr \
#  -out server1.pem -extensions req_ext -extfile server1-openssl.cnf -days 365


# shellcheck disable=SC2164
cd "$START_RATH"
exit




# Clean up:
# ---------
# rm *.rsa
# rm *.csr
# rm ca.srl
