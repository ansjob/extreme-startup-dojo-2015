import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertThat(server.answer(null), equalTo("The FooBars"));
    }

    @Test
    public void should_add_numbers() {
        assertThat(server.answer("what is the sum of 14 and 4"), equalTo("18"));
    }
    @Test
    public void should_plus_numbers() {
        assertThat(server.answer("what is 14 plus 4"), equalTo("18"));

    }  

}
