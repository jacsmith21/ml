package ca.jacob.cs6735;

import ca.jacob.cs6735.util.Vector;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class VectorTest {
    private static final double DELTA = 1e-10;
    private Vector v;

    @Before
    public void init() {
        v = new Vector(new int[]{1, 2, 3, 4, 4});
    }

    @Test
    public void testInit() {
        Vector v1 = new Vector(new double[]{1., 2., 3., 4., 4.});
        assertEquals(v, v1);

        Vector v2 = new Vector(new String[]{"1", "2", "3", "4", "4"});
        assertEquals(v, v2);
    }

    @Test
    public void testAdd() {
        Vector v1 = new Vector(new int[]{1, 2, 3, 4});
        v1.add(4);
        assertEquals(v, v1);
    }

    @Test
    public void testDropAndToArray() {
        v.remove(3);
        v.remove(0);
        assertArrayEquals(new double[]{2, 3, 4}, v.toArray(), DELTA);
    }

    @Test
    public void testTointArray() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 4}, v.tointArray());
    }

    @Test
    public void testAt() {
        assertEquals(3., v.at(2));
    }

    @Test
    public void testValueOfMaxOccurrance() {
        assertEquals(4., v.valueOfMaxOccurrence());
    }

    @Test
    public void testFill() {
        Vector v1 = new Vector(new int[]{1, 1, 1, 1, 1});
        v.fill(1.);
        assertEquals(v1, v);
    }

    @Test
    public void testDot() {
        double d = 46.;
        assertEquals(d, v.dot(v));
    }

    @Test
    public void testReplace() {
        v.replace(4, 1);
        assertEquals(new Vector(new int[]{1, 2, 3, 1, 1}), v);
    }
}
