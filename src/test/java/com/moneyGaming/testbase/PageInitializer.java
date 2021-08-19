package com.moneyGaming.testbase;

import com.moneyGaming.pages.LoginPage;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;

    public static void initializePageObjects() {
        loginPage=new LoginPage();
    }



}
