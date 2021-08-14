package com.twu.refactoring;

public class S implements DirectionCoordinate {
    public Direction left() {
        return new Direction('E');
    }

    public Direction right() {
        return new Direction('W');
    }
}
