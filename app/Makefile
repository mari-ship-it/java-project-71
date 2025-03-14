.DEFAULT_GOAL := build-run

build:
	./gradlew clean build

run:
	./gradlew run

run-dist:
	@./build/install/app/bin/app

build-run: build run

.PHONY: build