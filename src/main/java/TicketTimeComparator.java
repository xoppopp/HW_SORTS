import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int travelTime1 = t1.getTimeTo() - t1.getTimeFrom();
        int travelTime2 = t2.getTimeTo() - t2.getTimeFrom();
        if (travelTime1 < travelTime2) {
            return -1;
        } else if (travelTime1 > travelTime2) {
            return 1;
        } else {
            return 0;
        }
    }
}