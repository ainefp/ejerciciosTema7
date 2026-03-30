/* =============== Añadir Autores =============== */

    insert into AUTOR (nombre, email, limite_costo_total_cursos) values ('Ainé Figueroa', 'ainefigueroa@gmail.com', 150.0);
    insert into AUTOR (nombre, email, limite_costo_total_cursos) values ('Juan Pérez', 'juanperez@gmail.com', 200.0);

/* =============== Añadir Influencers =============== */

    insert into INFLUENCER (usr_igrm) values ('joaquirodriguez_');
    insert into INFLUENCER (usr_igrm) values ('tatiana__lopez42');
    insert into INFLUENCER (usr_igrm) values ('paquitaa000');

/* =============== Añadir Cursos =============== */

    insert into CURSO (nombre, precio, tematica, autor_id)
    values ('Programación', 50.0, 0, (select id from AUTOR where nombre = 'Ainé Figueroa'));

    insert into CURSO (nombre, precio, tematica, autor_id)
    values ('Redes Locales', 75.0, 1, (select id from AUTOR where nombre = 'Ainé Figueroa'));

    insert into CURSO (nombre, precio, tematica, autor_id)
    values ('Sistemas Informáticos', 60.0, 2, (select id from AUTOR where nombre = 'Juan Pérez'));

/* =============== Añadir Videos =============== */

    insert into VIDEO (descripcion, duracion_segundos, id_youtube, curso_id)
    values ('Introducción a la Programación', 30000, 'nLJhIpKNOSo', (select id from CURSO where nombre = 'Programación'));

    insert into VIDEO (descripcion, duracion_segundos, id_youtube, curso_id)
    values ('Programación Orientada a Objetos', 45000, 'nLJhIpKNOSo', (select id from CURSO where nombre = 'Programación'));

    insert into VIDEO (descripcion, duracion_segundos, id_youtube, curso_id)
    values ('Java Avanzado', 40000, 'nLJhIpKNOSo', (select id from CURSO where nombre = 'Programación'));

    insert into VIDEO (descripcion, duracion_segundos, id_youtube, curso_id)
    values ('Redes Locales Básicas', 15000, 'nLJhIpKNOSo', (select id from CURSO where nombre = 'Redes Locales'));

    insert into VIDEO (descripcion, duracion_segundos, id_youtube, curso_id)
    values ('DNS y DHCP', 25000, 'nLJhIpKNOSo', (select id from CURSO where nombre = 'Redes Locales'));

    insert into VIDEO (descripcion, duracion_segundos, id_youtube, curso_id)
    values ('Sistemas Informáticos para Principiantes', 20000, 'nLJhIpKNOSo', (select id from CURSO where nombre = 'Sistemas Informáticos'));

/* =============== Añadir Promociones =============== */

    insert into PROMOCION (curso_id, influencer_id)
    values (
        (select id from CURSO where nombre = 'Programación'),
        (select id from INFLUENCER where usr_igrm = 'joaquirodriguez_')
    );

    insert into PROMOCION (curso_id, influencer_id)
    values (
        (select id from CURSO where nombre = 'Programación'),
        (select id from INFLUENCER where usr_igrm = 'tatiana__lopez42')
    );

    insert into PROMOCION (curso_id, influencer_id)
    values (
        (select id from CURSO where nombre = 'Redes Locales'),
        (select id from INFLUENCER where usr_igrm = 'tatiana__lopez42')
    );

    insert into PROMOCION (curso_id, influencer_id)
    values (
        (select id from CURSO where nombre = 'Sistemas Informáticos'),
        (select id from INFLUENCER where usr_igrm = 'paquitaa000')
    );

/* =============== Añadir Cursos Simplificados (EJERCICIO 7.8) =============== */

    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Programación', 50.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Bases de Datos', 45.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Desarrollo Web', 60.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Java Avanzado', 70.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Python para Principiantes', 40.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('JavaScript', 55.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('HTML y CSS', 30.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Spring Boot', 75.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Angular', 65.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('React', 65.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Node.js', 60.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Docker', 50.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Kubernetes', 80.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Microservicios', 85.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Arquitectura de Software', 90.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Testing con JUnit', 35.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Git y GitHub', 25.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('DevOps', 70.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Linux', 45.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Ciberseguridad', 85.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Machine Learning', 95.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Inteligencia Artificial', 100.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Big Data', 90.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Hadoop', 75.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Spark', 80.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Power BI', 55.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Tableau', 60.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Excel Avanzado', 40.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Scrum', 30.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Kanban', 30.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Gestión de Proyectos', 65.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('UX/UI Diseño', 50.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Figma', 35.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Photoshop', 45.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Illustrator', 45.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Marketing Digital', 55.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('SEO', 50.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('SEM', 50.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Redes Sociales', 40.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('E-commerce', 60.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('WordPress', 35.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('WooCommerce', 45.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Blockchain', 95.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Criptomonedas', 85.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Realidad Virtual', 90.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Realidad Aumentada', 90.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Desarrollo de Videojuegos', 100.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Programación', 50.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Redes Locales', 75.0);
    insert into CURSO_SIMPLIFICADO (nombre, precio) values ('Sistemas Informáticos', 60.0);