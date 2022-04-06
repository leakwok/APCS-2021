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