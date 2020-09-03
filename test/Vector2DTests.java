import static org.junit.Assert.assertEquals;

import model.util.Constants;
import model.util.IVector;
import model.util.Vector2D;
import org.junit.*;

/**
 * A class of unit tests for the Vector2D class.
 */
public class Vector2DTests {
  private final Vector2D ZERO_VEC = new Vector2D(0, 0);

  @Test
  public void testAddZeroVector() {
    IVector a = new Vector2D(1.3, -4.3);
    IVector b = ZERO_VEC;

    assertEquals(a, a.add(b));
    assertEquals(a, b.add(a));
  }

  @Test
  public void testAddPositiveVectors() {
    IVector a = new Vector2D(1.0, 1.0);
    IVector b = new Vector2D(0.5, 1.5);

    assertEquals(new Vector2D(1.5, 2.5), a.add(b));
    assertEquals(new Vector2D(1.5, 2.5), b.add(a));
  }

  @Test
  public void testAddNegativeVectors() {
    IVector a = new Vector2D(-1.0, 1.0);
    IVector b = new Vector2D(0.5, -1.5);

    assertEquals(new Vector2D(-0.5, -0.5), a.add(b));
    assertEquals(new Vector2D(-0.5, -0.5), b.add(a));
  }

  @Test
  public void testSubtractSameVector() {
    IVector a = new Vector2D(4.8, -0.3);

    assertEquals(ZERO_VEC, a.subtract(a));
  }

  @Test
  public void testSubtractPositiveVectors() {
    IVector a = new Vector2D(1.0, 1.0);
    IVector b = new Vector2D(0.5, 1.5);

    assertEquals(new Vector2D(0.5, -0.5), a.subtract(b));
    assertEquals(new Vector2D(-0.5, 0.5), b.subtract(a));
  }

  @Test
  public void testAddSubtractInverses() {
    IVector a = new Vector2D(1.0, 1.0);
    IVector b = new Vector2D(0.5, 1.5);

    assertEquals(a, a.add(b).subtract(b));
    assertEquals(a, a.subtract(b).add(b));
  }

  @Test
  public void testScalarMultByZero() {
    IVector a = new Vector2D(1.0, 1.0);
    IVector b = new Vector2D(0.5, 1.5);

    assertEquals(ZERO_VEC, a.scalarProduct(0));
    assertEquals(ZERO_VEC, b.scalarProduct(0));
  }

  @Test
  public void testScalarMultByPositive() {
    IVector a = new Vector2D(1.0, 1.0);
    IVector b = new Vector2D(0.5, 1.5);

    assertEquals(new Vector2D(4.8, 4.8), a.scalarProduct(4.8));
    assertEquals(new Vector2D(0.45, 1.35), b.scalarProduct(0.9));
  }

  @Test
  public void testScalarMultByNegative() {
    IVector a = new Vector2D(1.0, 1.0);
    IVector b = new Vector2D(0.5, 1.5);

    assertEquals(new Vector2D(-0.8, -0.8), a.scalarProduct(-0.8));
    assertEquals(new Vector2D(-1.2, -3.6), b.scalarProduct(-2.4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoUnitVectorOfZeroVector() {
    ZERO_VEC.unitVector();
  }

  @Test
  public void testUnitVectorGivenBigVector() {
    assertEquals(new Vector2D(0.6, 0.8), new Vector2D(3, 4).unitVector());
  }

  @Test
  public void testUnitVectorGivenSmallVector() {
    assertEquals(new Vector2D(-0.6, -0.8), new Vector2D(-0.03, -0.04).unitVector());
  }

  @Test
  public void testDotWithZero() {
    assertEquals(0, ZERO_VEC.dot(new Vector2D(3, 1)), Constants.epsilon);
  }

  @Test
  public void testDotWithYourself() {
    IVector a = new Vector2D(4.8, -9.5);
    assertEquals(Math.pow(a.magnitude(), 2), a.dot(a), Constants.epsilon);
  }

  @Test
  public void testDotWithOtherVector() {
    IVector a = new Vector2D(4.8, -9.5);
    IVector b = new Vector2D(0.6, 2.1);

    assertEquals(-17.07, a.dot(b), Constants.epsilon);
    assertEquals(-17.07, b.dot(a), Constants.epsilon);
  }

  @Test
  public void testMagnitudeZeroVector() {
    assertEquals(0, ZERO_VEC.magnitude(), Constants.epsilon);
  }

  @Test
  public void testMagnitudeNonZeroVectors() {
    assertEquals(5, new Vector2D(4, 3).magnitude(), Constants.epsilon);
    assertEquals(Math.sqrt(5), new Vector2D(-1, 2).magnitude(), Constants.epsilon);
  }
}