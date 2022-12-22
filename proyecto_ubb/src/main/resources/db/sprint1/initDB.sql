--
-- Estructura de tabla para la tabla `alternativa`
--

CREATE TABLE `alternativa` (
  `id` int(11) NOT NULL,
  `texto` varchar(500) NOT NULL,
  `id_pregunta` int(11) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
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
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
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
  `nombre` varchar(250) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_termino` date NOT NULL,
  `min_respuestas` int(11) NOT NULL,
  `max_respuestas` int(11) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `encuesta`
--

INSERT INTO `encuesta` (`id`, `nombre`, `descripcion`, `fecha_inicio`, `fecha_termino`, `min_respuestas`, `max_respuestas`, `visible`, `id_empresa`, `id_categoria`) VALUES
(1, 'Teclado New Exp', 'Soy una descripción de encuesta genérica', '2022-10-01', '2022-10-11', 29, 38, 0, 1, 2),
(2, 'Monitor New World', 'Soy una descripción de encuesta genérica', '2022-10-11', '2022-10-21', 21, 42, 0, 1, 2),
(3, 'Zapateros modernos', 'Soy una descripción de encuesta genérica', '2022-10-21', '2022-11-01', 21, 39, 0, 1, 3),
(4, 'Nueva silla Gaming', 'Soy una descripción de encuesta genérica', '2022-11-01', '2022-11-11', 27, 46, 0, 1, 4),
(5, 'Guantes de portero', 'Soy una descripción de encuesta genérica', '2022-11-11', '2022-11-21', 24, 47, 0, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestado`
--

CREATE TABLE `encuestado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(80) NOT NULL
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
  `texto` varchar(500) NOT NULL,
  `orden` int(11) NOT NULL,
  `obligatoria` tinyint(1) NOT NULL,
  `id_encuesta` int(11) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL,
  `id_pregunta` int(11) NOT NULL,
  `id_alternativa` int(11) NOT NULL,
  `id_encuestado` int(11) NOT NULL
);

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
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `email`, `id_empresa`, `id_rol`) VALUES
(1, 'Sandor', 'Hatherill', 'shatherill0@cam.ac.uk', 1, 5),
(2, 'Hirsch', 'Dinwoodie', 'hdinwoodie1@netlog.com', 1, 1),
(3, 'Averill', 'Ainslie', 'aainslie2@aboutads.info', 1, 2),
(4, 'Kamilah', 'Sher', 'ksher3@disqus.com', 2, 5);

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
  ADD KEY `id_pregunta` (`id_pregunta`,`id_alternativa`,`id_encuestado`),
  ADD KEY `id_encuestado` (`id_encuestado`),
  ADD KEY `id_alternativa` (`id_alternativa`);

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
  ADD KEY `id_empresa` (`id_empresa`,`id_rol`),
  ADD KEY `id_rol` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alternativa`
--
ALTER TABLE `alternativa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `preferencias_ibfk_1` FOREIGN KEY (`id_encuestado`) REFERENCES `encuestado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `preferencias_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`id_encuestado`) REFERENCES `encuestado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_ibfk_3` FOREIGN KEY (`id_alternativa`) REFERENCES `alternativa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;