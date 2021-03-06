package io.github.oliviercailloux.or_tools_embedded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		new App().proceed();
	}

	public void proceed() {
		LOGGER.info("Hello World!");
	}
}
