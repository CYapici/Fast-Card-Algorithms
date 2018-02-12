 

import java.util.Random;
import org.springframework.stereotype.Component;

/**
 * generator with non repetitive digits
 * 
 * @author cagatayyapici
 *
 */
@Component
public class OtpGenerator {

  private static final Random random = new Random(new Random().nextLong()
      + System.currentTimeMillis() + new Random(System.currentTimeMillis()).nextLong());


  public String generateNum(int digitCount) {
    if (digitCount < 1)
      digitCount = 1;

    final StringBuilder sb = new StringBuilder();
    int lastGenerated = -1;
    int generated = -1;

    for (int i = 0; i < digitCount; i++) {
      generated = getExcept(lastGenerated, 0, 9);
      sb.append(String.valueOf(generated));
      lastGenerated = generated;
    }
    return sb.toString();
  }

  private int generateRandom(int lower, int upper) {
    final int range = upper - lower + 1;
    return random.nextInt(range) + lower;
  }

  private int getExcept(int toBeExcluded, int lower, int upper) {
    if (lower > toBeExcluded)
      lower = toBeExcluded;

    int generated = generateRandom(lower, upper);
    while (generated == toBeExcluded) {
      generated = generateRandom(lower, upper);
    }
    return generated;
  }
}
