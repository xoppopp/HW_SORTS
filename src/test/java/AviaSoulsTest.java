import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    AviaSouls mng = new AviaSouls();

    Ticket t1 = new Ticket("Москва", "Дубай", 300, 5, 10);   //5
    Ticket t2 = new Ticket("Москва", "Дубай", 200, 5, 12);   //7
    Ticket t3 = new Ticket("Москва", "Дубай", 500, 2, 5);    //3
    Ticket t4 = new Ticket("Дубай", "Москва", 200, 2, 15);   //13
    Ticket t5 = new Ticket("Дубай", "Иваново", 300, 5, 12);   //7


    @Test
    public void testCompareToFirstTicketCheaper() {
        int actual = t4.compareTo(t1);
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToSecondTicketCheaper() {
        int actual = t3.compareTo(t5);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToEqualPrice() {
        int actual = t2.compareTo(t4);
        int expected = 0;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchFewResults() {
        mng.add(t1);
        mng.add(t2);
        mng.add(t3);
        mng.add(t4);
        mng.add(t5);

        Ticket[] actual = mng.search("Москва", "Дубай");
        Ticket[] expected = {t2, t1, t3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneResult() {
        mng.add(t1);
        mng.add(t2);
        mng.add(t3);
        mng.add(t4);
        mng.add(t5);

        Ticket[] actual = mng.search("Дубай", "Москва");
        Ticket[] expected = {t4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoResults() {
        mng.add(t1);
        mng.add(t2);
        mng.add(t3);
        mng.add(t4);
        mng.add(t5);

        Ticket[] actual = mng.search("Иваново", "Москва");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorFirstTimeFaster() {
        TicketTimeComparator comp = new TicketTimeComparator();

        int actual = comp.compare(t1, t2);
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testComparatorSecondTimeFaster() {
        TicketTimeComparator comp = new TicketTimeComparator();

        int actual = comp.compare(t4, t5);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testComparatorEqualTime() {
        TicketTimeComparator comp = new TicketTimeComparator();

        int actual = comp.compare(t2, t5);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByFewResults() {
        mng.add(t1);
        mng.add(t2);
        mng.add(t3);
        mng.add(t4);
        mng.add(t5);
        TicketTimeComparator comp = new TicketTimeComparator();

        Ticket[] actual = mng.searchAndSortBy("Москва", "Дубай", comp);
        Ticket[] expected = {t3, t1, t2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByOneResult() {
        mng.add(t1);
        mng.add(t2);
        mng.add(t3);
        mng.add(t4);
        mng.add(t5);
        TicketTimeComparator comp = new TicketTimeComparator();

        Ticket[] actual = mng.searchAndSortBy("Дубай", "Иваново", comp);
        Ticket[] expected = {t5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByNoResults() {
        mng.add(t1);
        mng.add(t2);
        mng.add(t3);
        mng.add(t4);
        mng.add(t5);
        TicketTimeComparator comp = new TicketTimeComparator();

        Ticket[] actual = mng.searchAndSortBy("Иваново", "Дубай", comp);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}
