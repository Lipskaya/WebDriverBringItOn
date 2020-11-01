package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.example.page.PastebinPage;

public class PastebinTest {
    private static Browser browser;

    @BeforeAll//открывает браузер перед выполнением сценария suite
    public static void setup() {
        browser = Browser.getInstance();
    }

    @AfterAll
    public static void tearDown() {
        browser.stopBrowser();
    }
    @Test
    public void baseTest(){

        PastebinPage page = new PastebinPage();
        page.openPage();
        page.fillCode();
        page.fillBashHighlighting();
        page.fillExpiration();
        page.fillTitle();
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect());
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect());
        Assert.assertTrue("Highlighting is not bash",page.isHighlightingBash());
    }

}
