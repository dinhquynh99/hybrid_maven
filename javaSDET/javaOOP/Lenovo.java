package javaOOP;

public class Lenovo extends Computer {
    static void main(){
        Lenovo thinkPadX1Carbon = new Lenovo();
        thinkPadX1Carbon.setName("Lenovo ThinkPad X1 Carbon");
        thinkPadX1Carbon.setRam("8GB");
        thinkPadX1Carbon.setSsd("356GB");
        System.out.println(thinkPadX1Carbon.getName());
        System.out.println(thinkPadX1Carbon.getRam());
        System.out.println(thinkPadX1Carbon.getSsd());

        Lenovo ideaPad = new Lenovo();
        ideaPad.setName("Lenovo IdeaPad");
        ideaPad.setRam("16GB");
        ideaPad.setSsd("512GB");
        System.out.println( ideaPad.getName());
        System.out.println(ideaPad.getRam());
        System.out.println(ideaPad.getSsd());
    }
}
