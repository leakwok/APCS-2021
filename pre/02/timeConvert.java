import java.util.Scanner;

public class timeConvert {
    public static void main(String[] args){
        // total number of seconds
        int totalSeconds;
        Scanner in = new Scanner(System.in);

        // user input
        System.out.println("Type the number of seconds: ");
        totalSeconds = in.nextInt();
        System.out.println("You put: " + totalSeconds);

        // calculation

        int hours;
        int minutes;
        int seconds;

        seconds = totalSeconds % 60;
        hours = totalSeconds / 60 / 60;
        minutes = (totalSeconds / 60) % 60; 

        // display
        System.out.printf("%d seconds = %d hours, %d minutes, and %d seconds", totalSeconds, hours, minutes, seconds); 
    }
}