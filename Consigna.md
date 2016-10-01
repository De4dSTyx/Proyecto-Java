#Passwords Aceptables

Un password seguro es algo delicado. Los usuarios prefieren passwords que sean fáciles de
recordar (como amigo), pero este password puede ser inseguro. Algunos lugares usan un
generador randomico de passwords (como xvtpzyo), pero los usuarios toman demasiado tiempo
recordándolos y algunas veces lo escriben en una nota pegada en su computador. Una solución
potencial es generar password “pronunciables” que sean relativamente seguros pero fáciles de
recordar.

PassUTU está desarrollando un generador de passwords.

Su trabajo en el departamento de control de calidad es probar el generador y asegurarse de que
los passwords sean aceptables. Para ser aceptable, el password debe satisfacer estas tres
reglas:
	1. Debe contener al menos una vocal.
	2. No debe tener tres vocales consecutivas o tres consonantes consecutivas.
	3. No debe tener dos ocurrencias consecutivas de la misma letra, excepto por „ee‟ o „oo‟.
	(Para el propósito de este problema, las vocales son 'a', 'e', 'i', 'o', y 'u'; todas las demás letras
	son consonantes.)
	
Note que estas reglas no son perfectas; habrán muchas palabras comunes/pronunciables que no
son aceptables.

La entrada consiste en una o más potenciales passwords, uno por línea, seguidas por una línea
conteniendo una palabra 'fin' que señala el fin de la entrada. Cada password tiene como mínimo
una y como máximo veinte letras de largo y está formado solo por letras en minúscula. Por cada
password, despliegue si es o no aceptable, usando el formato mostrado en el ejemplo de salida.

Ejemplo de entrada

	a
	tv
	ptoui
	bontres
	zoggax
	wiinq
	eep
	houctuh
	fin

Ejemplo de salida

	<a> es aceptado.
	<tv> no fue aceptado.
	<ptoui> no fue aceptado.
	<bontres> no fue aceptado.
	<zoggax> no fue aceptado.
	<wiinq> no fue aceptado.
	<eep> es aceptado.
	<houctuh> es aceptado.
