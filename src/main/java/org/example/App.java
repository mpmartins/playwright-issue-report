package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            page.addInitScript("const definition = 'Some script'");

            page.navigate("http://playwright.dev");

            String definition = (String) page.evaluate("definition");

            System.out.println(definition);
        }
    }
}
