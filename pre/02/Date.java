public class Date{
    public static void main(String[] args){
        String day;
        int date;
        String month;
        int year;
        
        day = "Saturday";
        date = 28;
        month = "August";
        year = 2021;

        System.out.println("American format:");
        System.out.println(day + ", " + month + " " + date + ", " + year);
        
        System.out.println("European format:");
        System.out.println(day + " " + date + " " + month + " " + year);
        
        /*
        System.out.println(date);
        System.out.println(month);
        System.out.println(year); */
    }
}