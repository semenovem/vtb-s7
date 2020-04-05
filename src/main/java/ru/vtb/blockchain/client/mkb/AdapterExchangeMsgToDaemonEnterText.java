package ru.vtb.blockchain.client.mkb;

import ru.vtb.blockchain.client.mkb.DaemonEnterText.IHandlers;

public class AdapterExchangeMsgToDaemonEnterText implements IHandlers {
    private ExchangeMsg exchangeMsg;

    public AdapterExchangeMsgToDaemonEnterText(ExchangeMsg exchangeMsg) {
        this.exchangeMsg = exchangeMsg;
    }

    @Override
    public void stopWork() {
        exchangeMsg.stopWork();
    }

    @Override
    public void inputText(String str) {
        exchangeMsg.inputText(str);
    }
}
