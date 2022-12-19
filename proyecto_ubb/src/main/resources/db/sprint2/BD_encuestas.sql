--
-- Estructura de tabla para la tabla `alternativa`
--

CREATE TABLE `alternativa` (
  `id` int(11) NOT NULL,
  `texto` varchar(500) NOT NULL,
  `id_pregunta` int(11) 
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL
);

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Deporte'),
(2, 'Tecnología'),
(3, 'Hogar'),
(4, 'Gaming');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `descripcion` varchar(1000) NOT NULL
);

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `nombre`, `email`, `descripcion`) VALUES
(1, 'Gabcube', 'ccrisp0@youku.com', 'Soy una descripción de empresa genérica'),
(2, 'Buzzshare', 'abengtson1@reverbnation.com', 'Soy una descripción de empresa genérica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuesta`
--

CREATE TABLE `encuesta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(500) NOT NULL,
  `descripcion` varchar(2000) NOT NULL,
  `fecha_inicio` date,
  `fecha_termino` date,
  `max_respuestas` int(11),
  `min_respuestas` int(11),
  `visible` tinyint(1) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `encuesta`
--

INSERT INTO `encuesta` (`id`, `nombre`, `descripcion`, `fecha_inicio`, `fecha_termino`, `max_respuestas`, `min_respuestas`, `visible`, `id_empresa`, `id_categoria`) VALUES
(1, 'Teclado New Exp', 'Soy una descripción de encuesta genérica', '2022-10-01', '2022-10-11', 38, 29, 0, 1, 2),
(2, 'Monitor New World', 'Soy una descripción de encuesta genérica', '2022-10-11', '2022-10-21', 42, 21, 0, 1, 2),
(3, 'Zapateros modernos', 'Soy una descripción de encuesta genérica', '2022-10-21', '2022-11-01', 39, 21, 0, 1, 3),
(4, 'Nueva silla Gaming', 'Soy una descripción de encuesta genérica', '2022-11-01', '2022-11-11', 46, 27, 0, 1, 4),
(5, 'Guantes de portero', 'Soy una descripción de encuesta genérica', '2022-11-11', '2022-11-21', 47, 24, 0, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestado`
--

CREATE TABLE `encuestado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `email` varchar(500) NOT NULL
);

--
-- Volcado de datos para la tabla `encuestado`
--

INSERT INTO `encuestado` (`id`, `nombre`, `apellido`, `email`) VALUES
(1, 'Nat', 'McKenna', 'nmckenna0@jigsy.com'),
(2, 'Livvie', 'Catcherside', 'lcatcherside1@cyberchimps.com'),
(3, 'Johnna', 'Fipp', 'jfipp2@angelfire.com'),
(4, 'Devin', 'Linch', 'dlinch3@bluehost.com'),
(5, 'Rourke', 'Aylett', 'raylett4@businessweek.com'),
(6, 'Rosemarie', 'Ralestone', 'rralestone5@soundcloud.com'),
(7, 'Trueman', 'Cromer', 'tcromer6@nih.gov'),
(8, 'Pearla', 'Blackboro', 'pblackboro7@google.it'),
(9, 'Lyell', 'Sheeran', 'lsheeran8@miibeian.gov.cn'),
(10, 'Tanney', 'Ivanenko', 'tivanenko9@simplemachines.org');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preferencias`
--

CREATE TABLE `preferencias` (
  `id_encuestado` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `preferencias`
--

INSERT INTO `preferencias` (`id_encuestado`, `id_categoria`) VALUES
(1, 3),
(1, 4),
(2, 3),
(3, 1),
(3, 2),
(3, 3),
(4, 1),
(5, 2),
(6, 4),
(7, 1),
(7, 3),
(8, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id` int(11) NOT NULL,
  `texto` varchar(1000) NOT NULL,
  `orden` int(11) NOT NULL,
  `obligatoria` tinyint(1) NOT NULL,
  `id_encuesta` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO pregunta (id, texto, orden, obligatoria, id_encuesta) VALUES 
(1, '¿Que tipos de teclado prefiere?', 1, 1, 1),
(2, '¿Que color es su preferido para el teclado?', 2, 1, 1),
(3, '¿Le gustaria que el telcado incorporara luces LED?', 3, 0, 1),
(4, '¿De que material preferie la pantalla de su monitor?', 1, 1, 2),
(5, '¿Cual es su tamaño de pantalla preferido?', 2, 1, 2),
(6, '¿Le gustaria que el monitor tuviera botones?', 3, 0, 2),
(7, '¿Que color le gustaria en los zapateros?', 1, 1, 3),
(8, '¿Le gustaria que fueran a medida o con tamaños estandar?', 2, 1, 3),
(9, '¿Le gustaria que incorporen tecnologia?', 3, 0, 3),
(10, '¿Que color le gustaria en su silla?', 1, 1, 4),
(11, '¿Le gustaria que fuera con altura ajustable?', 2, 1, 4),
(12, '¿Le gustaria que incorporara respaldo reclinable?', 3, 0, 4),
(13, '¿Que material preferie en sus guantes?', 1, 1, 5),
(14, '¿Que tipos de color le gustaria en sus guantes?', 2, 1, 5),
(15, '¿Le gustaria que fueran ajustados?', 3, 0, 5);

--
-- Volcado de datos para la tabla `alternativa`
--

INSERT INTO alternativa (id, texto, id_pregunta) VALUES 
(1, 'Ergonómico', 1),
(2, 'Inalambrico', 1),
(3, 'Negro', 2),
(4, 'Blanco', 2),
(5, 'Si', 3),
(6, 'No', 3),
(7, 'LED', 4),
(8, 'LCD', 4),
(9, '24 pulgadas', 5),
(10, '21.5 pulgadas', 5),
(11, 'Si', 6),
(12, 'No', 6),
(13, 'Madera', 7),
(14, 'Metalico', 7),
(15, 'Zapateros a medida', 8),
(16, 'Medida estandar', 8),
(17, 'Si, es necesario', 9),
(18, 'No necesario', 9),
(19, 'Negro', 10),
(20, 'Blanco', 10),
(21, 'Me gustaria ajustar la altura', 11),
(22, 'No me gustaria ajustar la altura', 11),
(23, 'Si', 12),
(24, 'No', 12),
(25, 'Látex', 13),
(26, 'Neopreno', 13),
(27, 'Fluorecentes', 14),
(28, 'Opacos', 14),
(29, 'Si', 15),
(30, 'No', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `borrador`
--

CREATE TABLE `borrador` (
  `id` int(11) NOT NULL,
  `ultima_edicion` date,
  `finalizado` date,
  `id_encuestado` int(11) NOT NULL,
  `id_encuesta` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `borrador`
--

INSERT INTO borrador (id, ultima_edicion, finalizado, id_encuestado, id_encuesta) VALUES 
(1, '2022-08-11', NULL, 9, 3),
(2, '2022-02-07', NULL, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL,
  `id_pregunta` int(11) NOT NULL,
  `id_alternativa` int(11) NOT NULL,
  `id_borrador` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `respuesta`
--
INSERT INTO respuesta (id, id_pregunta, id_alternativa, id_borrador) VALUES
(1, 4, 8, 2),
(2, 5, 9, 2),
(3, 6, 12, 2),
(4, 7, 13, 1),
(5, 8, 16, 1),
(6, 9, 18, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
);

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`) VALUES
(1, 'Asistente de Marketing'),
(2, 'Diseñador de Producto'),
(3, 'Analista de Datos'),
(4, 'Administrador'),
(5, 'Analista de Mercado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(500) NOT NULL,
  `id_rol` int(11),
  `id_empresa` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `email`, `id_rol`, `id_empresa`) VALUES
(1, 'Sandor', 'Hatherill', 'shatherill0@cam.ac.uk', 5, 1),
(2, 'Hirsch', 'Dinwoodie', 'hdinwoodie1@netlog.com', 1, 1),
(3, 'Averill', 'Ainslie', 'aainslie2@aboutads.info', 2, 1),
(4, 'Kamilah', 'Sher', 'ksher3@disqus.com', 5, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alternativa`
--
ALTER TABLE `alternativa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pregunta` (`id_pregunta`);

--
-- Indices de la tabla `borrador`
--
ALTER TABLE `borrador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_encuestado` (`id_encuestado`,`id_encuesta`),
  ADD KEY `id_encuesta` (`id_encuesta`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_empresa` (`id_empresa`,`id_categoria`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `encuestado`
--
ALTER TABLE `encuestado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preferencias`
--
ALTER TABLE `preferencias`
  ADD KEY `id_encuestado` (`id_encuestado`,`id_categoria`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_encuesta` (`id_encuesta`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pregunta` (`id_pregunta`,`id_alternativa`,`id_borrador`),
  ADD KEY `id_alternativa` (`id_alternativa`),
  ADD KEY `id_borrador` (`id_borrador`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_rol` (`id_rol`,`id_empresa`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alternativa`
--
ALTER TABLE `alternativa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `borrador`
--
ALTER TABLE `borrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `encuesta`
--
ALTER TABLE `encuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `encuestado`
--
ALTER TABLE `encuestado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alternativa`
--
ALTER TABLE `alternativa`
  ADD CONSTRAINT `alternativa_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD CONSTRAINT `encuesta_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `encuesta_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `preferencias`
--
ALTER TABLE `preferencias`
  ADD CONSTRAINT `preferencias_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `preferencias_ibfk_2` FOREIGN KEY (`id_encuestado`) REFERENCES `encuestado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`id_alternativa`) REFERENCES `alternativa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_ibfk_3` FOREIGN KEY (`id_borrador`) REFERENCES `borrador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `borrador`
--
ALTER TABLE `borrador`
  ADD CONSTRAINT `borrador_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `borrador_ibfk_2` FOREIGN KEY (`id_encuestado`) REFERENCES `encuestado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;