package javaOpject;

public class MG {
    static void main(String[] args) {
        // MG ko thể extends MGMaintance được vì MGMaintance là final
        // nhưng khới tạo thì vẫn cho
        MGMaintance mgMaintance = new MGMaintance();
    }
}
