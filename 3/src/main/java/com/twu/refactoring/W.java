package com.twu.refactoring;

public class W implements DirectionCoordinate {
    public Direction left() {
        return new Direction('S');
    }

    public Direction right() {
        return new Direction('S');
    }
}
