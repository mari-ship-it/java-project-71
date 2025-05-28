build:
	make -C app build

report:
	make -C app report

test:
	make -C app test

lint:
	make -C app checkstyleMain

sonar:
	make -C app sonar
