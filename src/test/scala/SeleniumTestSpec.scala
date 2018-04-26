import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{MustMatchers, WordSpec}

class SeleniumTestSpec extends WordSpec with MustMatchers with WebBrowser {

  implicit val webDriver: WebDriver = new ChromeDriver()
  sys.addShutdownHook(webDriver.close())

  "The home page" must {
    "have the correct title and content" in {
      go to "https://www.gov.uk"

      pageTitle mustEqual "Welcome to GOV.UK"
      find(cssSelector("h1")).get.text mustEqual "Welcome to GOV.UK"

      click on linkText("Benefits")
      pageTitle mustEqual "Benefits - GOV.UK"

      goBack()
      pageTitle mustEqual "Welcome to GOV.UK"

    }
  }
}