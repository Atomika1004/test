public class Programmer {
    private String name;
    private String company;
    private String position;

    public Programmer(String name, String company){
        this.name = name;
        this.company = company;
        position = "intern";
    }

    public String getPosition() {
        return position;
    }
    public void work() {
        if (position.equals("intern")) position = "junior";
        else if (position.equals("junior")) position = "middle";
        else if (position.equals("middle")) position = "senior";
        else if (position.equals("senior")) position = "lead";
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer("Alex", "Apple");
        System.out.println(programmer.getPosition());
        programmer.work();
        System.out.println(programmer.getPosition());
    }
}
