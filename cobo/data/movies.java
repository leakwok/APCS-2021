/* Team Fried Chicken :: Nina Jiang, Lea Kwok, Lindsey Phung
APCS
LAB08 -- America's Next Top Data Scientist
2022-04-06
time spent: 02.3 hrs */

public class movies{

    private String name;
    private double popularity;
    private double count;
    private double voteAvg;

    public movies(String title, double pop, double ct, double avg){
        this.name = title;
        this.popularity = pop;
        this.count = ct;
        this.voteAvg = avg;
    }

    public String getName(){
        return this.name;
    }

    public double getPop(){
        return this.popularity;
    }

    public double getCount(){
        return this.count;
    }

    public double getAvg(){
        return this.voteAvg;
    }



}