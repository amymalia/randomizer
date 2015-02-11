/**
 * This class defines methods for computing pseudo-random numbers, and it defines
 * the state variable that needs to be maintained for use by those methods.
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */
public class Randomizer {
  // Carefully chosen constants from the book "Numerical Recipes in C".
  private static final int modulus = 233280;
  private static final int multiplier = 9301;
  private static final int increment = 49297;
  // The state variable maintained by each Randomizer instance
  private long seed = 1;


  /**
   * The constructor for the Randomizer() class.  It must be passed some
   * arbitrary initial value or "seed" for its pseudo-randomness.
   * @param seed used to randomize
   */
  public Randomizer(long seed) {
    this.seed = seed;
  }


  /**
   * This method computes a pseudo-random number between 0 and 1 using a very
   * simple algorithm.
   * @return a random float
   */
  public float randomFloat() {
    seed = (seed * multiplier + increment) % modulus;
    return (float) seed / (float) modulus;
  }


  /**
   *
   * This method computes a pseudo-random integer between 0 and specified
   * maximum.  It uses randomFloat() above.
   * @param max used to generate random int
   * @return a random int
   */
  public int randomInt(int max) {
    return Math.round(max * randomFloat());
  }

  /**
   * Simple test program: prints 10 random integers.
   * Note how the Randomizer object is seeded using the current time.
   */
  public static class Test {
    public static void main(String[] args) {
      Randomizer rand = new Randomizer(new java.util.Date().getTime());
      for (int i = 0; i < 10; i++) {
        System.out.println(rand.randomInt(100));
      }
    }
  }
}