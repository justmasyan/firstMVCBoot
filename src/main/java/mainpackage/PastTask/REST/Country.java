package mainpackage.PastTask.REST;

public class Country {
    private String name;
    private double population;

    public static Country of(String name,double population){
        Country c = new Country();
        c.setName(name);
        c.setPopulation(population);
        return c;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
