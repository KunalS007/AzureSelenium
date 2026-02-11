package feb;

import java.io.IOException;

import org.testng.annotations.Test;

public class firstTest extends febBase
{
	//This is testing purpose, i am checking the pull request.
	@Test
	public void browserInt() throws IOException
	{
			driver = initialize();
			driver = loginApp();
			
			first_ g = new first_(driver);
			g.clickOnSearch().click();
	}
}
