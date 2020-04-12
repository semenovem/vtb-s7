package ru.vtb.s7.client.mkb;

import ru.vtb.s7.client.mkb.DaemonEnterText.IHandlers;

public class AdapterExchangeMsgToDaemonEnterText implements IHandlers {
    private ExchangeMsg exchangeMsg;

    public AdapterExchangeMsgToDaemonEnterText(ExchangeMsg exchangeMsg) {
        this.exchangeMsg = exchangeMsg;
    }

    @Override
    public void exit() {
        exchangeMsg.exit();
    }

    @Override
    public void inputText(String str) {
        exchangeMsg.inputText(str);
    }
}
