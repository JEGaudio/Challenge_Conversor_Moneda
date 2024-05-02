# Challenge_Conversor_Moneda

El siguiente programa esta realizado en respuesta a un desafio que se nos impuso como desarollador backend.

Las premisas del desafio eran las de poder tener unas opciones de conversiones de monedas fijas entre nuestras monedas locales y otras monedas extranjeras y dependiendo de lo que escoja el usuario y los montos ingresados, realice el calculo.

Con respecto a este ultimo, se realizaron varias iteraciones del programa hasta llegar al actual, el cual me di la libertad de ajustar un poco la operacion de este ultimo, con tal de dar un poco mas de flexibilidad y ampliar las opciones para el usuario.

Aspectos importantes de como funciona:
1) Trabaja con una "Base de datos" (un archivo .txt llamado "DB_Conversor" que esta en el mismo directorio del programa). Este .txt servira para cuando el usuario agregue nuevas monedas, estas queden guardadas y se puedan volver a utilizar la proxima vez que se utilice el programa.(Nota: en esta version del programa, por ahora no se pueden eliminar las monedas ya creadas. Si se quisiera hacer eso, habria que acceder a este .txt y eliminarlos manual)
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/f81e9d17-2fcd-4c1e-9f92-c1927a9e8b5c)

2) Tiene la opcion de exportar los calculos realizados, los cuales quedaran guardados en un archivo .txt el cual se llamara "Datos Exportados" + la fecha y hora.
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/a3f2eaf8-1755-4a87-8dad-7a701ed474ef)

3) Utiliza una API de exchangerate para actualizar los valores al dia y por lo tanto, se necesitara colocar una llave en el programa.     https://www.exchangerate-api.com/
En el main de "Principal", reemplazar el valor de "String api" por la llave que tengas de esa pagina (puedes comentar el String api de arriba y quitar el comentario del String api de abajo, colocando tu llave ahi).
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/64ea9ec1-6bdf-4b6a-ba41-9d543d83f06b)

4) Se intento utilizar las clases de herencia para las distintas conversiones y de alguna manera, implementarlas todas hacia el mismo menu. Puede que no haya quedado perfecto, pero cumple con el objetivo y tiene pseudoflexibilidad el codigo en caso de querer agregar algunas otras conversiones.

5) Utiliza JOptionPane como forma de interaccion con el usuario, por lo que todo lo que muestre o solicite sera a traves de estos ultimos (messagedialog, inputdialog, confirmdialog, etc).

6) Para trabajar el JSON que recibimos de la API, se utilizo la libreria "Gson". Si no la tienes descargada, hay que agregarla. https://mvnrepository.com/artifact/com.google.code.gson/gson

Resumen de como opera el programa

Conversion de moneda

Primero te mostrara una ventana con las opciones de conversion que quieras escoger o si quieres, ver el resumen de los calculos que has realizado.
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/cf171719-36a7-4052-979e-6c9efcd0a3ce)
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/aa5a7caa-7ac2-45b1-8c89-b177ba6baa0c)

Nota: En caso de no aparecer este menu principal, puede que te aparezcan dos mensajes de errores, indicando ya sea la falta de conexion a internet o la falta de una llave API.

Al escoger la conversion de moneda, nos preguntara desde que moneda vamos a realizar la conversion
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/a3a5e7c3-15aa-476f-a8d8-c033d18d1e53)

Luego, cuando escojamos alguna moneda, nos preguntara cual es el monto a convertir, señalando que tipo de moneda hemos escogido
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/0a384a8d-a93a-400f-96d9-f1e0cb5e5542)

Al indicar el monto, el programa nos solicitara nuevamente que escojamos una moneda, pero en este caso es la moneda final a la cual queremos convertir, siempre recordandonos cual es el monto inicial y la moneda que hemos escogido.
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/5bc33aaf-68f8-4e0e-a73c-3cd9e72649ec)

Por ultimo nos dara una respuesta de la conversion escogida
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/907a7e16-09b1-401d-8dbc-1c847f452cdf)

Al finalizar cada "ciclo" nos preguntara si deseamos continuar o no para salir o no del loop que tenemos en el main
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/b77f28aa-9153-4722-9606-985af753ec31)

En caso de no salir, volvemos al menu principal.


Agregar una nueva moneda

En la seccion de escoger una moneda, si escogemos "Nueva Moneda", nos preguntara la unidad que queremos agregar
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/3be98ad5-68e1-4e21-b533-f78544dcfab6)

IMPORTANTE: Se necesita agregar en esta parte el nombre de la moneda de 3 letras utilizado internacionalmente
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/7363f537-701f-4470-90a3-291d592e22ec)
La API utiliza esta nomenclatura para entregar los montos y por lo tanto, debemos brindar esto ultimo. En caso de no entregar una palabra acorde, el programa indicara que el parametro ingresado no corresponde y solicitara volver a ingresar.

Cuando se ingrese una opcion adecuada, te preguntara que nombre le deseas colocar a esa moneda. En este ejemplo, vamos a agregar de nombre "Won South Korea" para la moneda "KRW".
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/c1377c74-e7f3-46dc-86ec-d13cbb9c0600)

Una vez se haya agregado con exito, arrojara un mensaje asociado y se volvera al menu principal
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/c2f60626-c4b2-4fbd-8813-ba062aee6baa)

Conversion de distancia

Utiliza un menu similar al del conversor de moneda, primero preguntandonos desde que unidad queremos convertir
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/231bd5a5-23bb-4c2d-832e-745c90975189)

Luego preguntandonos la cantidad
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/0ecd3c85-3095-4b23-95a3-db89e38dea8c)

Y por ultimo preguntandonos la unidad a la cual queremos convertir
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/45fd7cee-9a52-43b2-ba2c-1f645f0bfb40)

Luego nos mostrara el resultado de la conversion antes de enviarnos de vuelta al menu principal
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/e81d6737-30ab-4341-b7c0-f7a64705ce48)

Ver resultados y exportarlos

Al escoger la opcion "Ver calculos realizados", nos mostrara un listado de las conversiones y a la vez nos preguntara si deseamos expotarlos o no.
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/3fadc712-8fa8-4fa9-947d-00cf9fc8b5af)
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/63cc3b49-11c1-4fe4-8871-6e86ccecc2bf)

Si colocamos que "no" simplemente volvera al menu principal. Al colocar que "Si", automaticamente creara el arhivo .txt el cual se llamara "Datos Exportados" + la fecha y hora actual (de esta manera, evitamos que se sobreescriba algun otro calculo previo hacia el mismo .txt).
![image](https://github.com/JEGaudio/Challenge_Conversor_Moneda/assets/140985074/f4c45929-48d2-4c45-a161-439d3dd2da08)
