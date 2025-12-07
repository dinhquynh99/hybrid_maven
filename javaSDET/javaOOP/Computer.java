package javaOOP;

public class Computer {
    private String name;
    private String ram;
    private String ssd;
    private String chip;

    public String getRam(){
        return ram;
    }

    public void setRam(String ram){
        this.ram = ram;
    }

    public String getSsd(){
        return ssd;
    }

    public void setSsd(String ssd){
        this.ssd = ssd;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // hàm protected chỉ có những thằng con ms dc dùng nó thôi
    // hàm public thì ai dùng cũng dc
    protected void setChip(String chipName){
        this.chip = chipName;
    }
}
