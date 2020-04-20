package ru.vtb.afsc.mon;

public interface Monitorable {

    default MBeanDefinition getMBeanDefinition() {
        return null;
    }

    void reset();
}
