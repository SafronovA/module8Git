package com.epam.module5.tests;

import com.epam.module5.steps.FindUserStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindUserTest extends BaseTest {
    private FindUserStep findUserStep;

    @Test(groups = "FindUserTest")
    public void findUserTest(){
        findUserStep = new FindUserStep(driver).findUser();
        Assert.assertTrue(findUserStep.userIsFind());
    }
}
