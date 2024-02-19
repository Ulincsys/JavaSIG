
public class Main {
    public static void main(String[] args) {
        String title = "schedule";
        System.out.println(title);

        Week[] weeks = new Week[10];
        for(Week week : weeks) {
            System.out.println(week.topic);
        }
    }
}

class Week {
    protected String topic;
}