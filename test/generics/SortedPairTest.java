package generics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SortedPairTest {

    @Test
    public void shouldRetainOrder() {
        SortedPair<Integer> sortedPair = new SortedPair<>(1, 2);

        Assert.assertEquals("Testing First Value", 1, sortedPair.getFirst().intValue());
        Assert.assertEquals(2, sortedPair.getSecond().intValue());
    }

    @Test
    public void shouldFlipOrder() {
        SortedPair<Integer> sortedPair = new SortedPair<>(2, 1);

        Assert.assertEquals(1, sortedPair.getFirst().intValue());
        Assert.assertEquals(2, sortedPair.getSecond().intValue());
    }

}
