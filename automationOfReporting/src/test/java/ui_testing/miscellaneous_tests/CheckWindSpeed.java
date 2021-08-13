package ui_testing.miscellaneous_tests;

import comparator_logic.actions.WebActions;
import org.junit.Assert;
import org.testng.annotations.Test;
import ui_testing.BaseTest;

public class CheckWindSpeed extends BaseTest {

    private WebActions actions;

    @Test
    public void windSpeedValidation(){
        actions=new WebActions(driver);
        Assert.assertTrue(
                Integer.parseInt((String)actions.returnInfo().get(2))<15
        );
    }

}
