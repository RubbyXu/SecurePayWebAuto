package com.securepay.webauto.cucumber;

import com.securepay.webauto.managers.PageObjectManager;

public class TestContext {
    private PageObjectManager pageObjectManager;

    public TestContext() {
        pageObjectManager = new PageObjectManager();
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
