package net.haxzee.tictacto;

import net.haxzee.tictacto.gameboard.AbstractGameboard;
import net.haxzee.tictacto.util.Vector2d;

public class Gameboard extends AbstractGameboard {
    public Gameboard() {
    }

    public Gameboard(int xDim, int yDim, int winCon) {
        super(xDim, yDim, winCon);
    }

    @Override
    protected boolean isWon(Vector2d changed) {
        int currentPlayer = getCurrentPlayer();
        // horizontal
        int row = 1;

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(-i, 0);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(i, 0);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        if (row >= getWinCon()) {
            return true;
        }

        // vertical

        row = 1;

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(0, -i);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(0, i);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        if (row >= getWinCon()) {
            return true;
        }


        // diagonal -45

        row = 1;

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(-i, -i);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(i, i);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        if (row >= getWinCon()) {
            return true;
        }

        // diagonal 45

        row = 1;

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(-i, i);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        for (int i = 1; i < getWinCon(); i++) {
            Vector2d add = changed.add(i, -i);
            if (isFieldOfPlayer(currentPlayer, add)) {
                row++;
            } else {
                break;
            }
        }

        return row >= getWinCon();
    }

    @Override
    protected boolean isFieldOfPlayer(int player, Vector2d coord) {
        return isInField(coord) && getField(coord) == player;
    }

    @Override
    protected boolean isInField(int x, int y) {
        return x < getDim().getX() && x >= 0 && y < getDim().getY() && y >= 0;
    }
}
