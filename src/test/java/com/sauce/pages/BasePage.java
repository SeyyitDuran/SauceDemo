package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {//inherit connections

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
