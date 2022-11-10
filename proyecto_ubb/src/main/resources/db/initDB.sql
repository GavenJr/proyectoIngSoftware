-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2022 a las 21:53:26
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alternativa`
--

CREATE TABLE `alternativa` (
  `id` int(11) NOT NULL,
  `texto` varchar(100) NOT NULL,
  `id_pregunta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `nombre` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `descripción` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `nombre`, `email`, `descripción`) VALUES
(1, 'Gabcube', 'ccrisp0@youku.com', 'Soy una descripción de empresa genérica'),
(2, 'Buzzshare', 'abengtson1@reverbnation.com', 'Soy una descripción de empresa genérica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuesta`
--

CREATE TABLE `encuesta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `descripción` varchar(200) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_termino` date NOT NULL,
  `min_respuestas` int(11) NOT NULL,
  `max_respuestas` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `encuesta`
--

INSERT INTO `encuesta` (`id`, `nombre`, `descripción`, `fecha_inicio`, `fecha_termino`, `min_respuestas`, `max_respuestas`, `id_empresa`, `id_categoria`) VALUES
(1, 'Nombre de encuesta genérico', 'Soy una descripción de encuesta genérica', '0000-00-00', '0000-00-00', 29, 38, 1, 2),
(2, 'Nombre de encuesta genérico', 'Soy una descripción de encuesta genérica', '0000-00-00', '0000-00-00', 21, 42, 1, 2),
(3, 'Nombre de encuesta genérico', 'Soy una descripción de encuesta genérica', '0000-00-00', '0000-00-00', 21, 39, 1, 3),
(4, 'Nombre de encuesta genérico', 'Soy una descripción de encuesta genérica', '0000-00-00', '0000-00-00', 27, 46, 1, 4),
(5, 'Nombre de encuesta genérico', 'Soy una descripción de encuesta genérica', '0000-00-00', '0000-00-00', 24, 47, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestado`
--

CREATE TABLE `encuestado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Estructura de tabla para la tabla `preferencia`
--

CREATE TABLE `preferencia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preferencia`
--

INSERT INTO `preferencia` (`id`, `nombre`) VALUES
(1, 'Deporte'),
(2, 'Tecnología'),
(3, 'Hogar'),
(4, 'Gaming');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preferencias`
--

CREATE TABLE `preferencias` (
  `id_encuestado` int(11) NOT NULL,
  `id_preferencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preferencias`
--

INSERT INTO `preferencias` (`id_encuestado`, `id_preferencia`) VALUES
(1, 3),
(2, 3),
(3, 1),
(3, 3),
(3, 3),
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
  `texto` varchar(200) NOT NULL,
  `orden` int(11) NOT NULL,
  `obligatoria` tinyint(1) NOT NULL,
  `id_encuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL,
  `id_respuesta_enc` int(11) NOT NULL,
  `id_pregunta` int(11) NOT NULL,
  `id_alternativa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta_encuesta`
--

CREATE TABLE `respuesta_encuesta` (
  `id` int(11) NOT NULL,
  `id_encuestado` int(11) NOT NULL,
  `id_encuesta` int(11) NOT NULL,
  `id_respuesta` int(11) NOT NULL,
  `fecha inicio` date NOT NULL,
  `fecha termino` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `id_rol` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD KEY `id_categoría` (`id_categoria`);

--
-- Indices de la tabla `encuestado`
--
ALTER TABLE `encuestado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preferencia`
--
ALTER TABLE `preferencia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preferencias`
--
ALTER TABLE `preferencias`
  ADD KEY `id_encuestado` (`id_encuestado`,`id_preferencia`),
  ADD KEY `id_preferencia` (`id_preferencia`);

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
  ADD KEY `id_respuesta_enc` (`id_respuesta_enc`,`id_pregunta`),
  ADD KEY `id_alternativa` (`id_alternativa`),
  ADD KEY `id_pregunta` (`id_pregunta`);

--
-- Indices de la tabla `respuesta_encuesta`
--
ALTER TABLE `respuesta_encuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_encuestado` (`id_encuestado`,`id_encuesta`,`id_respuesta`),
  ADD KEY `id_encuesta` (`id_encuesta`),
  ADD KEY `respuesta_encuesta_ibfk_4` (`id_respuesta`);

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
  ADD CONSTRAINT `preferencias_ibfk_2` FOREIGN KEY (`id_preferencia`) REFERENCES `preferencia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`id_alternativa`) REFERENCES `alternativa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta_encuesta`
--
ALTER TABLE `respuesta_encuesta`
  ADD CONSTRAINT `respuesta_encuesta_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_encuesta_ibfk_2` FOREIGN KEY (`id_encuestado`) REFERENCES `encuestado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_encuesta_ibfk_3` FOREIGN KEY (`id`) REFERENCES `respuesta` (`id_respuesta_enc`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_encuesta_ibfk_4` FOREIGN KEY (`id_respuesta`) REFERENCES `respuesta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
