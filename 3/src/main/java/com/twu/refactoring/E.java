package com.twu.refactoring;

public class E implements DirectionCoordinate {
    public Direction left() {
        return new Direction('N');
    }

    public Direction right() {
        return new Direction('N');
    }
}
