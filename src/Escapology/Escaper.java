package Escapology;

import game.EscapeState;

import java.util.Stack;

/**
 * @author lmignot
 */
public class Escaper {

    private EscapeState state;

    public Escaper(EscapeState state) {
        this.state = state;
    }

    public void getRichAndEscape() {
        RouteFinder routeFinder = new AStarRouteFinder();
        Stack<GreedyNode> route =
                routeFinder.findRoute(state.getCurrentNode(), state.getExit(), state.getVertices());

        while (!route.empty()) {
            GreedyNode current = route.pop();
            state.moveTo(current.getNode());
            if (current.hasGold()) state.pickUpGold();
        }
    }
}
