package com.twu.refactoring;

public class N implements DirectionCoordinate {

    public Direction left() {
        return new Direction('W');
    }

    public Direction right() {
        return new Direction('E');
    }
}
