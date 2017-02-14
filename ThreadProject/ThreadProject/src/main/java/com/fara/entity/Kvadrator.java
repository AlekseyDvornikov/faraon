package com.fara.entity;

import com.fara.Consumer;

public class Kvadrator {

	public Kvadrator(int value, Consumer consumer) {
		consumer.message(0, (int)Math.pow(value, 2), 0);
	}

}
