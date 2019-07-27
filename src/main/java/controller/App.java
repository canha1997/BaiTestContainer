package controller;

import model.Container;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        LinkedList containerList=new LinkedList();
        LinkedList containerCoHangList=new LinkedList();
     containerQuanLy(containerList,containerCoHangList);

    }
    public static void containerQuanLy(LinkedList<Container> ContainerList,LinkedList<Container> containerCoHangList)
    {
        while (true) {
            QuanLyContainer quanlyContainer = new QuanLyContainer();
            String x;
            System.out.println("Nhap 1: De tao mot container trong list: ");
            System.out.println("Nhap 2: De xuat mot container ra list: ");
            System.out.println("Nhap 3 : De xoa toan bo file");
            System.out.println("Nhap 4 : De co the find mot Container");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ban nhap la: ");
            x = scanner.nextLine();
            switch (x) {
                case "1":
                    quanlyContainer.nhapContainer(ContainerList,containerCoHangList);
                    break;
                case "2":
                    quanlyContainer.hienThiContainer();
                case "3":
                    quanlyContainer.xoaToanBoFile();
                    break;
                case "4":
                    quanlyContainer.timContainer(ContainerList);
                default:
                    break;
            }
        }
    }

}
