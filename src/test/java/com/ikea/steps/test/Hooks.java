package com.ikea.steps.test;

import com.ikea.pageObjects.Page;
import io.cucumber.java.After;

public class Hooks {
        @After()
        public void afterTakeScreenShot(){
            Page.saveScreenShotPNG();
    }

}
