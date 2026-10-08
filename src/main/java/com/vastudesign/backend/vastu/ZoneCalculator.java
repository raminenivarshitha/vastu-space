package com.vastudesign.backend.vastu;

public class ZoneCalculator {

    public Direction calculateZone(
            double roomWidth,
            double roomLength,
            double x,
            double y
    ) {

        double thirdWidth = roomWidth / 3.0;
        double thirdLength = roomLength / 3.0;

        boolean left = x < thirdWidth;
        boolean centerX = x >= thirdWidth && x < (2 * thirdWidth);
        boolean right = x >= (2 * thirdWidth);

        boolean top = y < thirdLength;
        boolean centerY = y >= thirdLength && y < (2 * thirdLength);
        boolean bottom = y >= (2 * thirdLength);

        if (top && left) {
            return Direction.NORTH_WEST;
        }

        if (top && centerX) {
            return Direction.NORTH;
        }

        if (top && right) {
            return Direction.NORTH_EAST;
        }

        if (centerY && left) {
            return Direction.WEST;
        }

        if (centerY && centerX) {
            return Direction.CENTER;
        }

        if (centerY && right) {
            return Direction.EAST;
        }

        if (bottom && left) {
            return Direction.SOUTH_WEST;
        }

        if (bottom && centerX) {
            return Direction.SOUTH;
        }

        return Direction.SOUTH_EAST;
    }
}