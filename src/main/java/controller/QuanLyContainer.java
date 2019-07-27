package controller;

import model.Container;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLyContainer implements iContainer {
    @Override
    public void nhapContainer(LinkedList<Container> containerList, LinkedList<Container> containerCoHangList) {
        Scanner scanner = new Scanner(System.in);
        Container container = new Container();
        while (true) {
            int flags=0;
            System.out.println("Moi ban nhap number cua container:");
            String number=scanner.nextLine();
            for(Container con:containerList)
            {
                if(con.getNumber().equals(number)) {
                    flags = 1;
                    break;
                }
            }
            if(flags==1)
            {
                System.out.println("Number da bi trung xin hay nhap lai nhe");
                continue;
            }
            else {
                container.setNumber(number);
                break;
            }
        }
        System.out.println("Nhap chieu cao cua container:");
        container.setChieuCao(scanner.nextInt());
        scanner.nextLine();
        while (true) {
            System.out.println("Nhap trang thai cua Container (Co hang|Khong co hang):");
            String test = scanner.nextLine();
            Pattern p = Pattern.compile("(Co hang|Khong co hang)");
            Matcher matcher = p.matcher(test);
            if (matcher.find()) {
                container.setTrangThai(test);
                break;
            } else {
                System.out.println("Nhap sai roi, xin hay nhap lai:");
                continue;
            }
        }
        if(container.getTrangThai().equals("Co hang"))
        {
            containerCoHangList.add(container);
        }
        containerList.add(container);
        BufferedWriter bf=null;
        FileWriter fw=null;
        try {
            fw = new FileWriter("C:\\Users\\PC_ASUS\\Downloads\\engine\\Container.txt");
            bf = new BufferedWriter(fw);
            for(Container contai2:containerList) {
                bf.write("Number cua container la: " + contai2.getNumber());
                bf.newLine();
                bf.write("Chieu cao cua containerla:" + contai2.getChieuCao());
                bf.newLine();
                bf.write("Trang thai cua container la :" + contai2.getTrangThai());
                bf.newLine();
            }
            System.out.println("hoan thanh");
        }
        catch (Exception e)
        {
            System.err.println(e);
        }finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter ContainerCoHangWr=null;
            FileWriter ContainerCoHang=null;
            try
            {
                ContainerCoHang=new FileWriter("C:\\Users\\PC_ASUS\\Downloads\\engine\\ContainerCoHang.txt");
                ContainerCoHangWr= new BufferedWriter(ContainerCoHang);
                for(Container contai:containerCoHangList)
                {

                        ContainerCoHangWr.write("Number cua container la: " + contai.getNumber());
                        ContainerCoHangWr.newLine();
                        ContainerCoHangWr.write("Chieu cao cua containerla:" + contai.getChieuCao());
                        ContainerCoHangWr.newLine();
                        ContainerCoHangWr.write("Trang thai cua container la :" + contai.getTrangThai());
                        ContainerCoHangWr.newLine();

                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }finally {
                try {
                    ContainerCoHangWr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void hienThiContainer() {
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader("C:\\Users\\PC_ASUS\\Downloads\\engine\\Container.txt");
             br=new BufferedReader(fr);
            String line=br.readLine();
            while (line != null)
            {
                System.out.println(line);
                line=br.readLine();
            }
            br.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    @Override
    public void xoaToanBoFile() {
        FileWriter fr=null;
        try {
            fr=new FileWriter("C:\\Users\\PC_ASUS\\Desktop\\bao cao cho thay\\Container.txt", true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void timContainer(LinkedList<Container> containerList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Xin ban hay nhap container ban can tim");
        String find=scanner.nextLine();
        for(Container contai1:containerList)
        {
            if(contai1.getNumber().equals(find))
            {
                System.out.println("Number cua container:"+contai1.getNumber());
                System.out.println("Chieu cao cua container:"+contai1.getChieuCao());
                System.out.println("Trang thai cua container "+contai1.getTrangThai());
            }
        }
    }
}
