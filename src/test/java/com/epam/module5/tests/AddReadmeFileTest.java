package com.epam.module5.tests;

import com.epam.module5.steps.AddReadmeFileStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReadmeFileTest extends BaseTest {
    private AddReadmeFileStep addReadmeFileStep;

    @Test(groups = "AddReadmeFileTest", dependsOnGroups = "CreateNewRepository")
    public void addReadmeFile() {
        addReadmeFileStep = new AddReadmeFileStep(driver).addReadmeFile();
        Assert.assertTrue(addReadmeFileStep.readmeFileIsAdded());
    }

}
