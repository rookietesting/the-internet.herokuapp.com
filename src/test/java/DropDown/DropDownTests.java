package DropDown;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropDownTests extends BaseTest {

    @Test
    public void TestSelectedOption(){
        var dropDownPage = homepage.clickDropDown();

        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1,"Incorrect number of selections");
        assertTrue(selectedOptions.contains(option),"Option not selected");

    }
}
