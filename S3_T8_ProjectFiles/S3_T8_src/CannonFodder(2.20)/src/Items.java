public class Items {

    private String name;
    private double weight;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void printInfo(){
        System.out.println("Name: "+ getName());
        System.out.println("Weight: "+ getWeight());
        System.out.println("Value: "+ getValue());
    }
}
