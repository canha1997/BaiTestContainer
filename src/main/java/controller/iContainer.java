package controller;

import model.Container;

import java.util.LinkedList;

public interface iContainer {
    void nhapContainer(LinkedList<Container> containerList,LinkedList<Container> containerCoHangList);
    void hienThiContainer();
    void xoaToanBoFile();
    void timContainer(LinkedList<Container> containerList);
}
