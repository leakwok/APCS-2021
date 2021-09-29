public class Time {
    public static void main(String[] args){
        int hour;
        int minute;
        int second;

        hour = 17;
        minute = 35;
        second = 23;

        // num seconds since midnight
        double secSinceMidnight;
        secSinceMidnight = 60*60*hour + 60*minute + second;
        System.out.println(secSinceMidnight);

        // percentage of day passed
        double dayPassed = secSinceMidnight / 86400 * 100;
        System.out.println(dayPassed + "%");

        //time passed
        int newHour;
        int newMinute;
        int newSecond;

        newHour = 17;
        newMinute = 47;
        newSecond = 19;

        double newSinceMidnight;
        newSinceMidnight = 60*60*newHour + 60*newMinute + newSecond;

        double timePassed = newSinceMidnight - secSinceMidnight;
        System.out.println(timePassed + " seconds elapsed");
    }
    
}