package com.epam.module5.tests;

import com.epam.module5.steps.AddNewFileToRepositoryStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewFileToRepositoryTest extends BaseTest {
    private AddNewFileToRepositoryStep addNewFileToRepositoryStep;

    @Test(groups = "AddNewFileToRepositoryTest", dependsOnGroups = "AddReadmeFileTest")
    public void addNewFileToRepositoryTest() {
        addNewFileToRepositoryStep = new AddNewFileToRepositoryStep(driver);
        Assert.assertTrue(addNewFileToRepositoryStep.newFileIsAdded());
    }

}
