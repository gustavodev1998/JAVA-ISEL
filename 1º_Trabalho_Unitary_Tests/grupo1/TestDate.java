package trab1.grupo1;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestDate {

    private static final Date testDate = new Date(26, 10, 2020 );

    private void testDayMonthYear( Date dt, int d, int m, int y) {
        assertEquals( d, dt.getDay());
        assertEquals( m, dt.getMonth());
        assertEquals( y, dt.getYear() );
    }

    @Test
    public void testConstructDayMonthYear() {
        testDayMonthYear(testDate, 26, 10, 2020 );
    }

    @Test
    public void testConstructString() {
        testDayMonthYear(new Date("26-01-2020"), 26, 1, 2020 );
        testDayMonthYear(new Date("6-10-2020"), 6, 10, 2020 );
        testDayMonthYear(new Date("26-1-2020"), 26, 1, 2020 );
        testDayMonthYear(new Date("9-4-2020"), 9, 4, 2020 );
    }

    @Test
    public void testToString() {
        assertEquals("26-10-2020", new Date(26, 10, 2020 ).toString() );
        assertEquals("06-10-2020", new Date(6, 10, 2020).toString() );
        assertEquals("26-01-2020", new Date(26, 1, 2020 ).toString());
        assertEquals("09-04-2020", new Date(9, 4, 2020).toString() );
    }

    @Test
    public void testEquals() {
        Date d2 = new Date("26-10-2020" );
        assertTrue( testDate.equals(testDate) );
        assertTrue( testDate.equals( new Date(26, 10, 2020)) );
        assertTrue( testDate.equals( d2 ) );
        assertTrue( d2.equals(testDate) );
        assertFalse( testDate.equals( null) );
        assertFalse( testDate.equals( new Date(27, 10, 2020)) );
        assertFalse( testDate.equals( new Date(26, 11, 2020)) );
        assertFalse( testDate.equals( new Date(26, 10, 2021)) );
    }

    @Test
    public void testCompareTo() {
        //Equals
        assertEquals( 0,  testDate.compareTo(testDate) );
        assertEquals( 0, testDate.compareTo(new Date(26, 10, 2020 )) );
        //Greater
        assertTrue( testDate.compareTo( new Date(25, 10, 2020 ) ) > 0 );
        assertTrue( testDate.compareTo( new Date(27, 9, 2020 ) ) > 0 );
        assertTrue( testDate.compareTo( new Date(27, 12, 2019 ) ) > 0 );
        //Less
        assertTrue( testDate.compareTo( new Date(27, 10, 2020 ) ) < 0 );
        assertTrue( testDate.compareTo( new Date(25, 11, 2020 ) ) < 0 );
        assertTrue( testDate.compareTo( new Date(20, 8, 2021 ) ) < 0 );
    }

    @Test
    public void testNextDate() {
        assertTrue( new Date(27,10,2020).equals(testDate.nextDate(1)) );
        assertEquals( new Date(1,11,2020),  testDate.nextDate(6) );
        assertEquals( new Date(1,12,2020),  testDate.nextDate(36) );
        assertEquals( new Date(25,12,2020),  testDate.nextDate(60) );
        assertEquals( new Date(31,12,2020),  testDate.nextDate(66) );
        assertEquals( new Date(1,1,2021),  testDate.nextDate(67) );
        assertEquals( new Date(6,1,2021),  testDate.nextDate(72) );
    }

    @Test
    public void testtoday() {
        Date s1 = new Date();
        assertEquals( s1, testDate.today());
        assertTrue(s1.equals(testDate.today()));
        assertFalse(new Date(29,10,2019).equals(testDate.today()));
    }

    @Test
    public void testlessDates() {
        Date s1 = new Date();
        Date s2 = new Date(30,10,2025);
        Date s3 = new Date(15,1,2018);
        Date s4 = new Date(10,2,1998);
        Date s5 = new Date(16,5, 2001);

        Date[] dates = {s1,s2,s3,s4,s5};
        Date[] test1 = {s4, s5, s3};
        assertEquals( Arrays.toString(test1), Arrays.toString(testDate.lessDates(dates)) );
        assertTrue( Arrays.toString(test1).equals(Arrays.toString(testDate.lessDates(dates))) );
        assertFalse( Arrays.toString(dates).equals(Arrays.toString(testDate.lessDates(dates))) );
    }

}

