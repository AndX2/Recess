package ru.yandex.android.andrew.recess;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    int timeInDBPresentation;

    @BeforeClass
    public void setTimeInDBPresentation() {
        timeInDBPresentation = Utils.getTimeForDB(17, 47);
    }
    @Test
    public void getHour() {
        assertEquals(16, Utils.getHourFromDBPresentation(timeInDBPresentation));
    }

    @Test
    public void getMinute() {
        assertEquals(47, Utils.getMinuteFromDBPresentation(timeInDBPresentation));
    }
}