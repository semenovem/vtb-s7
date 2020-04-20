package ru.vtb.afsc;

import ru.vtb.afsc.grpc.Client;

public class Main {
    private MessagingClient msgClient;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        System.out.println("start main");
        try (MessagingClient grpc = new Client().connect()) {

            grpc.offer("1111111111");
            grpc.offer("22222222222");

//            this.msgClient = grpc;
//            try {
//                new Run();
//            } catch(Exception e) {
//                e.getStackTrace();
//            }

        } catch (Exception e) {
            System.out.println("Error");

            e.getStackTrace();
        }
    }

    private void test() {

    }
}


/*

ru.vtb.afsc.bc.InvocationResponse

в блокчейне посмотреть метод "StartPayment" - по нему (в доке) получаем реквизиты платежей


json (получение реквизитов по id транзакции) преобразуется в xml на основании XSD "Реквизиты участников.xsd"


формат xml в скриншотах (на ст.25 ТЗ_ПРОМ_AFSC)


компонент "логирование" - категории: STATE, OPERATION, INTEGRATION,

 */
