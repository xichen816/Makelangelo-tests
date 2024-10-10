package com.marginallyclever.makelangelo.makeart.tools;

import org.junit.jupiter.api.Test;
import com.marginallyclever.makelangelo.paper.Paper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.marginallyclever.makelangelo.turtle.Turtle;
import java.awt.geom.Rectangle2D;

public class TestResizeTurtleToPaperAction {
    @Test
    public void testResizeTurtleToPaperAction() {
        Paper paper = new Paper();
        paper.setPaperSize(420, 594, 0, 0);
        paper.setPaperMargin(0.95);

        Turtle turtle = new Turtle();

        
    }
}
