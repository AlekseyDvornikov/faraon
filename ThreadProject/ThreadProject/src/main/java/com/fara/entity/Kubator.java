package com.fara.entity;

import com.fara.Consumer;

public class Kubator {

	public Kubator(int value, Consumer consumer) {
		consumer.message((int)Math.pow(value, 3), 0, 0);
	}
}
