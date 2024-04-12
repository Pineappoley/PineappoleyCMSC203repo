package lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradeBookTester {
    GradeBook grade1;
    GradeBook grade2;

    @Before
    public void setUp() {
        grade1 = new GradeBook(5);
        grade2 = new GradeBook(5);

        // Adding scores to both gradebooks
        grade1.addScore(50.0);
        grade1.addScore(75.0);
        grade2.addScore(65.0);
        grade2.addScore(85.0);
    }

    @After
    public void tearDown() {
        grade1 = null;
        grade2 = null;
    }

    @Test
    public void addScoreTest() {
        assertTrue("50.0 75.0".equals(grade1.toString()));
        assertEquals(2, grade1.getScoreSize());

        assertTrue("65.0 85.0".equals(grade2.toString()));
        assertEquals(2, grade2.getScoreSize());
    }

    @Test
    public void testSum() {
        assertEquals(125.0, grade1.sum(), 0.0001);
        assertEquals(150.0, grade2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50.0, grade1.minimum(), 0.001);
        assertEquals(65.0, grade2.minimum(), 0.001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(75.0, grade1.finalScore(), 0.0001); // lowest score is 50
        assertEquals(85.0, grade2.finalScore(), 0.0001); // lowest score is 65
    }
}
