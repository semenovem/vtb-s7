package ru.vtb.afsc;

import javax.xml.bind.JAXBException;
import ru.vtb.afsc.dto.XmlTestReq;
import javax.xml.bind.JAXBContext;


public class Run {
    public Run() throws JAXBException {
        XmlTestReq instance = new XmlTestReq();

        JAXBContext.newInstance(XmlTestReq.class).createMarshaller();

        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println(instance);
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");

    }
}
