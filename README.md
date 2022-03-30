# Segundo repositorio con el mathservice corriendo:
- https://github.com/eduardoospina/parcialcorte2arep-p2.git

# AREP- ARQUITECTURAS EMPRESARIAL - Parcial Corte 2.

## AUTOR.

> Eduardo Ospina Mejia

## Parcial corte 2 Arep.

### Introduccion.

Diseñe un prototipo de calculadora de microservicios que tenga un servicios de matemáticas con al menos dos funciones 
implementadas y desplegadas en al menos dos instancias virtuales de EC2. Además debe implementar un service proxy que 
recibe las solicitudes de servicios y se las delega a las dos instancias usando un algoritmo de round-robin. Asegúrese 
que se pueden configurar las direcciones y puertos de las instancias en el porxy usando variables de entorno del sistema 
operativo. Cada estudiante debe seleccionar para desarrollar dos funciones matemáticas de acuerdo a los dos últimos
dígitos de su cédula como se especifica en la lista (Si sus dos últimos dígitos de su cédula son el mismo use el 
siguiente dígito que sea diferente). Todas las funciones reciben un solo parámetro de tipo "Double" y retornan una 
parámetro de tipo "Double".

0. log
1. ln
2. sin
3. cos
4. tan
5. acos
6. asin
7. atan
8. sqrt
9. exp (el número de eauler elevado ala potendia del parámetro)

Implemente los servicios para responder al método de solicitud HTTP GET. Deben usar el nombre de la función 
especificado en la lista y el parámetro debe ser pasado en la variable de query con nombre "value".

El proxy debe delegar el llamado a los servicios de backend. El proxy y los servicios se deben implementar en Java 
usando Spark.


Ejemplo de una llamado:

EC2
https://amazonxxx.x.xxx.x.xxx:{port}/cos?value=3.141592

Salida. El formato de la salida y la respuesta debe ser un JSON con el siguiente formato

{

"operation": "cos",

"input":  3.141592,

"output":  -0.999999

}



#### Entregables

1. Proyecto actualizado en github (uno o dos repositorios, incluya referencias al repositorio alterno en el repositorio que entrega)

2. Descripción del proyecto enel README con pantalazos que muestren el funcionamiento.

3. Descripción de como correrlo en EC2.

4. Video de menos de un minuto del funcionamiento (lo puede tomar con el celular una vez funcione)


### Desplegando localmente.

1) clonar el repositorio, ya se a traves de cmd o de GIT: que contiene todos los ejercicios y retos.

2) ingresamos al proyecto clonado y desde cmd hacer uso de mvn para clean y package:

3) se pueden correr lo servidores directamente de las clases main de cada uno de los dos proyectos, que cuando se ponen a correr permite la conecion local. 
al montarlo en aws las direcciones no quedan correctos para local, requieren cmabio. 
   
4) se ejecutan ya sea pro comandos de consola o directamente desde al IDE que corra cad auno de los programas:

```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.RoundRobin"
```



##### Requisitos:
1)   [Java 8](https://www.java.com/download/ie_manual.jsp)
2)   [Maven](https://maven.apache.org/download.cgi)
3)   [Git](https://git-scm.com/downloads)
4)   IDE de java.

### Solucion.

Para solucionar el proyecto, lo primero que toc a hacer es crear el servidor encargado de retornar los dos metodos matematicos
que toca,en mi caso siendo sqrt y atan. y donde se hace uso de spark para acer las peticiones y que retorne las respuestas en 
Json para ser utilizadas mas adelante en el llamdo del proxy. para esto se hace uso de la libreria math y spark, separandolo en 
2 archivos javas que manejan el funcionamiento. 

Al ya tener estos servicios, se crea el servicio de roundrobin, utlizando spark y colas de prioridad para el manejo del 
balanceo de cargas dentro del proyecto. en donde a partir de este se busca hacer llamado al servidor de mathservice para hacer 
las peticiones gets correspondientes para obtener el resultado de la soperaciones matematicas, funcionando como un proxy. 

estos se relaizaron en dos githubs, este y el que se encuentra en el tope del readme, en donde se encuentra el proyecto completo. 

### AWS:

![](https://i.postimg.cc/Wpy9TnHn/Capture1.png)

![](https://i.postimg.cc/y8mnhzYQ/Capture2.png)

![](https://i.postimg.cc/MGtD4bB1/Capture3.png)

![](https://i.postimg.cc/Qttbr9gw/Capture4.png
)
![](https://i.postimg.cc/PxRMfX2x/Capture5.png)

![](https://i.postimg.cc/yx3ykMbT/Capture6.png)

![](https://i.postimg.cc/59XhB6cs/Capture7.png)

![](https://i.postimg.cc/g2W1bsx7/Capture8.png)

![](https://i.postimg.cc/5NcR8gSt/Capture9.png)

![](https://i.postimg.cc/7YgQ9zKn/Capture10.png)

![](https://i.postimg.cc/8zNX0C3Q/Capture11.png)

![](https://i.postimg.cc/pddGP6Rs/Capture12.png)

![](https://i.postimg.cc/wvywmRtJ/Capture13.png)

![](https://i.postimg.cc/FRMDgFc6/Capture14.png)

![](https://i.postimg.cc/kGWwjrvg/Capture15.png)

![](https://i.postimg.cc/wxNWxJYY/Capture16.png)

![](https://i.postimg.cc/tCHBsT9Z/Capture17.png)

![](https://i.postimg.cc/zXS0Krfd/Capture18.png)

![](https://i.postimg.cc/Dwx6pPLL/Capture19.png)

![](https://i.postimg.cc/qR3GRfYx/Capture20.png)

![](https://i.postimg.cc/vTwtxqwF/Capture21.png)

![](https://i.postimg.cc/VsXRP8XY/Capture22.png)

![](https://i.postimg.cc/KzBnbPk9/Capture23.png)

![](https://i.postimg.cc/fysYRVYM/Capture24.png)

![](https://i.postimg.cc/5Nn8fNyM/Capture25.png)

![](https://i.postimg.cc/kgGKG3RR/Capture26.png)

![](https://i.postimg.cc/K8WLgqtq/Capture27.png)




### Arquitectura implementada

La arquitectura implementada es: 


## Construido con
-   HTML
-   javascript
-   java

## Despliegue Heroku:

### Licencia.

Licencia.
