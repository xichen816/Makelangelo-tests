package com.marginallyclever.makelangelo.makeart.tools;

import com.marginallyclever.makelangelo.turtle.MovementType;
import com.marginallyclever.makelangelo.turtle.TurtleMove;
import org.junit.jupiter.api.Test;
import com.marginallyclever.makelangelo.paper.Paper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.marginallyclever.makelangelo.turtle.Turtle;

import java.util.ArrayList;
import java.util.List;

public class TestCenterTurtleToPaperAction {
    @Test
    public void testRun(){
        //case if drawing is already centered on (0, 0), turtle history should not change at all
        CenterTurtleToPaperAction action = new CenterTurtleToPaperAction("TestPaper");

        Turtle turtle = new Turtle();
        turtle.history.clear();

        TurtleMove m1 = new TurtleMove(10, 20, MovementType.TRAVEL);
        TurtleMove m2 = new TurtleMove(-10, -20, MovementType.DRAW_LINE);
        TurtleMove m3 = new TurtleMove(0, 0, MovementType.DRAW_LINE);
        turtle.history.add(m1);
        turtle.history.add(m2);
        turtle.history.add(m3);
        List<TurtleMove> oHist = turtle.history;

        Turtle result = action.run(turtle);
        compareHistory(oHist, result.history);

        //case where no lines are drawn, history should be the same
        turtle.history.clear();

        m1 = new TurtleMove(10, 20, MovementType.TRAVEL);
        m2 = new TurtleMove(-10, -20, MovementType.TRAVEL);
        turtle.history.add(m1);
        turtle.history.add(m2);

        List<TurtleMove> testHist = new ArrayList<>();
        testHist.add(m1);
        testHist.add(m2);

        result = action.run(turtle);
        compareHistory(testHist, result.history);

        //regular case
        turtle.history.clear();

        m1 = new TurtleMove(100, 200, MovementType.TRAVEL);
        m2 = new TurtleMove(120, 230, MovementType.DRAW_LINE);

        turtle.history.add(m1);
        turtle.history.add(m2);

        testHist.clear();
        m1 = new TurtleMove(-10, -15, MovementType.TRAVEL);
        m2 = new TurtleMove(10, 15, MovementType.DRAW_LINE);
        testHist.add(m1);
        testHist.add(m2);

        result = action.run(turtle);
        compareHistory(testHist, result.history);
    }

    private void compareHistory(List<TurtleMove> h1, List<TurtleMove> h2){
        for(int i=0;i<h1.size();i++){
            TurtleMove m1 = h1.get(i);
            TurtleMove m2 = h2.get(i);
            assertEquals(m1.x, m2.x, 0.000001);
            assertEquals(m1.y, m2.y, 0.000001);
            assertEquals(m1.type, m2.type);
        }
    }
}
