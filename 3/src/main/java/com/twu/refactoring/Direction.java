package com.twu.refactoring;

import java.util.HashMap;
import java.util.Optional;

public class Direction {
    private final char direction;
    private final HashMap<Character, DirectionCoordinate> directions = new HashMap<>();

    public void initDirections() {
        directions.put('N', new N());
        directions.put('E', new E());
        directions.put('W', new W());
        directions.put('S', new S());
    }
    public Direction(char direction) {
        this.direction = direction;
        initDirections();
    }

    public Direction turnRight() {
        DirectionCoordinate directionCoordinate = Optional.ofNullable(directions.get(direction)).orElseThrow(IllegalArgumentException::new);
        return directionCoordinate.right();
    }

    public Direction turnLeft() {
        DirectionCoordinate directionCoordinate = Optional.ofNullable(directions.get(direction)).orElseThrow(IllegalArgumentException::new);
        return directionCoordinate.left();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
