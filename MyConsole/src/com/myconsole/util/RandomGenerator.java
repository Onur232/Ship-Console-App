package com.myconsole.util;

import java.util.Random;

import com.myconsole.scopeobjects.Direction;

public class RandomGenerator {

	public static int generateNumber(int number) {
		Random random = new Random();
		return random.nextInt(number);
	}

	public static Direction generateDirection() {
		Direction direction = null;
		switch (generateNumber(4)) {
		case 0:
			direction= Direction.NORTH;
			break;
		case 1:
			direction= Direction.SOUTH;
			break;
		case 2:
			direction= Direction.WEST;
			break;
		case 3:
			direction= Direction.EAST;
			break;
		default:
			break;
		}
		return direction;
	}

}
