package performance.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class ListUtilsTest {

    private static final List<String> DATA = Arrays.asList(
            "oka", "okb", "okc", "okd", "oke", "okf", "okg", "okh", "oki", "okj",
            "nga", "ngb", "ngc", "ngd", "nge", "ngf", "ngg", "ngh", "ngi", "ngj");

    @Test
    public void test() throws Exception {
        List<String> result = ListUtils.filter(DATA);
        assertEquals(10, result.size());
    }

    @Test
    public void testStream() throws Exception {
        List<String> result = ListUtils.filterStream(DATA);
        assertEquals(10, result.size());
    }

    @Test
    public void testRx() throws Exception {
        List<String> result = ListUtils.filterRx(DATA);
        assertEquals(10, result.size());
    }

    @Test
    public void testIx() throws Exception {
        List<String> result = ListUtils.filterIx(DATA);
        assertEquals(10, result.size());
    }
}
