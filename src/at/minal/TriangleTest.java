package at.minal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mbrahmbhatt on 8/26/16.
 */
public class TriangleTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testTriangleIsCreatedProperly() throws InvalidTriangleException {
        Triangle t = new Triangle(12.5,6.7,8.9);
        assertThat(t.getSideA(),is(12.5));
        assertThat(t.getSideB(),is(6.7));
        assertThat(t.getSideC(),is(8.9));
    }

    @Test
    public void testNegativeValuesThrowException() throws InvalidTriangleException {
        expectedEx.expect(InvalidTriangleException.class);
        expectedEx.expectMessage("The sides -12.5, 6.7 and 8.9 cannot be negative or zero.");
        Triangle t = new Triangle(-12.5,6.7,8.9);
    }

    @Test
    public void testInvalidSideSumsThrowException() throws InvalidTriangleException {
        expectedEx.expect(InvalidTriangleException.class);
        expectedEx.expectMessage("The sides 2.5, 4.7 and 8.9 do not form a triangle.");
        Triangle t = new Triangle(2.5,4.7,8.9);
    }

    @Test
    public void testSideZeroThrowException() throws InvalidTriangleException {
        expectedEx.expect(InvalidTriangleException.class);
        expectedEx.expectMessage("The sides 0.0, 4.7 and 8.9 cannot be negative or zero.");
        Triangle t = new Triangle(0,4.7,8.9);
    }

    @Test
    public void testScaleneTriangleIsCreated() throws InvalidTriangleException {
        Triangle t = new Triangle(2.5,6.7,8.9);
        assertThat(t.getType(), is(TriangleTypes.SCALENE));
    }

    @Test
    public void testEquilateralTriangleIsCreated() throws InvalidTriangleException {
        Triangle t = new Triangle(2.5,2.5,2.5);
        assertThat(t.getType(), is(TriangleTypes.EQUILATERAL));
    }

    @Test
    public void testIsocelesTriangleIsCreated() throws InvalidTriangleException {
        Triangle t = new Triangle(2.5,2.5,3.5);
        assertThat(t.getType(), is(TriangleTypes.ISOSCELES));
    }

}