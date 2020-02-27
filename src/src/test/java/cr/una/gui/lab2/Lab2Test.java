package cr.una.gui.lab2;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class Lab2Test {

    private FrameFixture window;
    private JPanelFixture panel;

    public Lab2Test() {
    }

    @Before
    public void setUp() {
        Lab2 frame = GuiActionRunner.execute(Lab2::new);

        window = new FrameFixture(frame);
        window.show();
        panel = window.panel("Form");
        window.resizeTo(new Dimension(250, 350));

    }

    @Test
    public void testVisibleComponents() {
        panel.label("lblFirstName").requireVisible();
        panel.label("lblLastName").requireVisible();
        panel.label("lblFullName").requireVisible();

        panel.label("lblPhone").requireVisible();
        panel.label("lblGender").requireVisible();
        panel.label("lblResult").requireVisible();

        panel.button("ok").requireVisible();
        panel.button("clean").requireVisible();
    }

    @Test
    public void testFullName() {
        panel.textBox("firstName").enterText("Maikol");
        panel.textBox("lastName").enterText("Guzman");
        panel.button("ok").requireVisible();
        panel.button("ok").click();
        panel.label("lblFullName").requireText("Nombre Completo: Maikol Guzman");

    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
