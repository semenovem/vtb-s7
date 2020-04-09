#!/bin/bash

# генерация сертификатов
# todo сейчас скрипт переходит в директорию, куда должен записать сертификаты
# сделать, что бы не преходил через `cd`. в -out передать полное имя с директорией назначения


# директория с сертификатами (в корне проекта)
CERT_DIR="/assets/cert"

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

# ------------
# конфирурации
path="$ROOT_PATH/assets/openssl-configurations"

ILLEGAL_OPENSSL_CONF="$path/illegal-openssl.conf"
CA_OPENSSL_CONF="$path/ca-openssl.conf"
OPENSSL_CONF="$path/openssl.conf"
CLIENT_OPENSSL_CONF="$path/client-openssl.conf"
SERVER_OPENSSL_CONF="$path/server-openssl.conf"

unset path

DIR="$ROOT_PATH/$CERT_DIR"
mkdir -p "$DIR"

if ! [ -d "$DIR" ]
then
    echo "Error creating directory \"$DIR\""
    exit
fi

cd "$DIR" || exit
# пока так - не нужны предыдущие файлы
rm *


# для тестирования - с неразрешенным доступом
# --------------------------
#openssl req -x509 -newkey rsa:4096 -keyout badserver.key -out badserver.pem \
#  -days 3650 -nodes -config "${ILLEGAL_OPENSSL_CONF}"



# сертификат для разработки
# --------------------------
openssl req -x509 -new -newkey rsa:4096 -nodes -keyout ca.key -out ca.pem \
  -config "${CA_OPENSSL_CONF}" -days 365 -extensions v3_req


# client
# --------------------------
openssl genrsa -out client.key.rsa 4096
openssl pkcs8 -topk8 -in client.key.rsa -out client.key -nocrypt
rm client.key.rsa
openssl req -new -key client.key -out client.csr -config "${CLIENT_OPENSSL_CONF}"


#openssl ca -in client.csr -out client.pem -keyfile ca.key -cert ca.pem -verbose -config "${OPENSSL_CONF}" -days 365 -updatedb
openssl x509 -req -CA ca.pem -CAkey ca.key -CAcreateserial -in client.csr \
  -out client.pem -extensions v3_req -extfile "${CLIENT_OPENSSL_CONF}" -days 365


#  server
# --------------------------
openssl genrsa -out server.key.rsa 4096
openssl pkcs8 -topk8 -in server.key.rsa -out server.key -nocrypt
#rm server.key.rsa
openssl req -new -key server.key -out server.csr -config "${SERVER_OPENSSL_CONF}"



#openssl ca -in server.csr -out server.pem -keyfile ca.key -cert ca.pem -verbose -config "${OPENSSL_CONF}" -days 365 -updatedb
openssl x509 -req -CA ca.pem -CAkey ca.key -CAcreateserial -in server.csr \
  -out server.pem -extensions v3_req -extfile "${SERVER_OPENSSL_CONF}" -days 365


# Clean up:
# ---------
 rm *.rsa
 rm *.csr
 rm ca.srl


# shellcheck disable=SC2164
cd "$START_RATH"
exit

