package com.fara.entity;

import com.fara.Consumer;

public class Simplekator {

	public Simplekator(int value, Consumer consumer) {
		consumer.message(0, 0, value);
	}

}
