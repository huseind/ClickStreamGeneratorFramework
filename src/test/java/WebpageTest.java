import CSGFramework.Website.Webpage;
import CSGFramework.Website.WebpageBuilder;
import CSGFramework.Website.Website;
import CSGFramework.Website.WebsiteBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebpageTest {
    @Test
    public void builderTest(){
        assertTrue(new WebpageBuilder().build() instanceof Webpage);
    }

    Website site = new WebsiteBuilder().build();

    @Test
    public void generateRedirectingActionsTests(){
        assertTrue(new WebpageBuilder().generateRedirectingActions(20,site).build().getNumberOfActions() == 20);
    }
}
