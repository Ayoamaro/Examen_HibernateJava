# Examen Hibernate Java
Realiza con hibernate el mapeo correspondiente para crear y trabajar con la base de datos MySQL **ComponentesInfo**.

![](https://github.com/Ayoamaro/Examen_HibernateJava/blob/main/docs/images/diagrama.PNG?raw=true)

El nombre del proyecto **exaInfo_NombreAlumno**. Deberá aparecer tu nombre en la ejecución y como comentario en cada uno de los ficheros del proyecto.

Tener en cuenta que la clave de la tabla **Componentes** es autonumérica y la clave de la tabla categorías es **char(7)**.

Entre la tabla **DesComponente** y **Componentes** la relación es de uno a uno, pueden existir Componentes sin descripción de componente, pero no lo contrario.

Un componente tendrá una sola **Categoría**, pero una categoría podrá tener varios componentes.

Añádele el programa de mapeo de la base de datos realizada las siguientes operaciones, haz todas las visualizaciones por consola y pon los datos directamente, no hace falta que los pidas al usuario, pero si pon todos los casos de prueba posibles:

1. Inserta 2 componentes, un componente CON descripción y otro SIN descripción.
2. Elimina un componente determinado. Indicar "Componente eliminado", "Componente NO eliminado" o "Componente inexistente". SI tiene descripción de componente también lo eliminarás.
3. Visualiza todos los datos de la tabla **Componentes**, más la descripción del componente, el que la tenga.
4. Visualiza todos los nombres de la tabla **Categorías** (todas las categorías, aunque no tengan componentes) y todos los nombres de los componentes que tiene.
5. Visualiza lo anterior más la descripción del componente del componente que la tenga.

*Realiza un menú de opciones (consola o gráfico) para probar las anteriores operaciones.*