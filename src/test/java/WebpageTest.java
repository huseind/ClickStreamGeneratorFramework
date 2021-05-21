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

    Website site = new WebsiteBuilder().addPage(new WebpageBuilder().setUrl("mywebsite.com/lol").build()).build();
    Webpage page = new WebpageBuilder().generateRedirectingActions(2, site).build();

    @Test // Testing generating redirecting on a page that belongs to a website.
    public void generateRedirectingActionsOnWebsiteTests(){
        Webpage page = new WebpageBuilder().generateRedirectingActions(2, site).build();
        assertTrue(page.getNumberOfActions() == 2);
    }

    @Test
    public void sumething(){
        site.addWebpage(page);

    }


    @Test // Testing generating actions on a page without a website, redirects to external websites
    public void generateRedirectingActionsTest(){
        assertTrue(new WebsiteBuilder().generateRedirectingActions(10).build().getHomeWebpage().getNumberOfActions() == 10);
    }

}
