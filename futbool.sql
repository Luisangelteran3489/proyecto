-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2018 a las 05:47:09
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `futbool`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `nombre_equipo` varchar(100) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `nombre_estadio` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`nombre_equipo`, `id_equipo`, `nombre_estadio`) VALUES
('America', 2, 'Azteca'),
('Atlas', 18, 'Jalisco'),
('Cruz Azul', 15, 'Azul'),
('Guadalajara', 16, 'Chivas'),
('Leon', 11, 'Leon'),
('Lobos BUAP', 17, 'Olimpico del BUAP'),
('Monterrey', 8, 'BBVA Bancomer'),
('Morelia', 7, 'Morelos'),
('Necaxa', 12, 'Victoria'),
('Pachuca', 10, 'Hidalgo'),
('Puebla', 5, 'Cuauhtemoc'),
('Pumas', 9, 'Oimpico Universitario'),
('Queretaro', 13, 'Corregidora'),
('santos', 1, 'Corona'),
('Tigres', 4, 'Universitario'),
('Tijuana', 6, 'Caliente'),
('Toluca', 3, 'Nemesio Diez'),
('Veracruz', 14, 'Luis \"Piarata\" Fuentes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadio`
--

CREATE TABLE `estadio` (
  `nombre_estadio` varchar(100) NOT NULL,
  `id_estadio` int(11) DEFAULT NULL,
  `id_equipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadio`
--

INSERT INTO `estadio` (`nombre_estadio`, `id_estadio`, `id_equipo`) VALUES
('Azteca', 6, 2),
('Azul', 1, 15),
('BBVA Bancomer', 9, 8),
('Caliente', 14, 6),
('Chivas', 11, 16),
('Corona', 3, 1),
('Corregidora', 7, 13),
('Cuauhtemoc', 10, 5),
('Hidalgo', 13, 10),
('Jalisco', 8, 18),
('Leon', 2, 11),
('Luis \"Pirata\" Fuente', 15, 14),
('Morelos', 18, 7),
('Nemesio Diez', 4, 3),
('Olimpico del BUAP', 16, 17),
('Olimpico Universitario', 5, 9),
('Universitario', 12, 4),
('Victoria', 17, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornadas`
--

CREATE TABLE `jornadas` (
  `id_jornada` int(11) NOT NULL,
  `id_liga` int(11) DEFAULT NULL,
  `partido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jornadas`
--

INSERT INTO `jornadas` (`id_jornada`, `id_liga`, `partido`) VALUES
(1, 2, 1),
(2, 6, 6),
(3, 5, 1),
(4, 6, 1),
(5, 2, 6),
(6, 1, 1),
(7, 5, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liga`
--

CREATE TABLE `liga` (
  `id_liga` int(11) NOT NULL,
  `nombre_liga` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `liga`
--

INSERT INTO `liga` (`id_liga`, `nombre_liga`) VALUES
(1, 'Apertura 2016'),
(2, 'Clausura 2016'),
(3, 'Apertura 2017'),
(4, 'Clausura 2017'),
(5, 'Apertura 2018'),
(6, 'Clausura 2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidos`
--

CREATE TABLE `partidos` (
  `id_partidos` int(11) NOT NULL,
  `equipo_local` varchar(100) DEFAULT NULL,
  `equipo_visitante` varchar(100) DEFAULT NULL,
  `estadio` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `marcador_local` int(11) DEFAULT NULL,
  `marcador_visitante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partidos`
--

INSERT INTO `partidos` (`id_partidos`, `equipo_local`, `equipo_visitante`, `estadio`, `fecha`, `marcador_local`, `marcador_visitante`) VALUES
(1, 'santos', 'america', 'azteca', '2016-01-27', 1, 2),
(2, 'Queretaro', 'Cruz Azul', 'Corregidora', '2017-03-05', 1, 0),
(3, 'America', 'Toluca', 'Azteca', '2017-08-10', 4, 3),
(4, 'Pumas', 'Cruz Azul', 'Azul', '2017-05-16', 2, 1),
(5, 'America', 'Toluca', 'Azteca', '2017-08-10', 4, 3),
(6, 'Monterrey', 'Lobos BUAP', 'BBVA Bancomer', '2017-08-20', 5, 3),
(7, 'Tijuana', 'Pachuca', 'Caliente', '2018-02-05', 1, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`nombre_equipo`,`id_equipo`);

--
-- Indices de la tabla `estadio`
--
ALTER TABLE `estadio`
  ADD PRIMARY KEY (`nombre_estadio`);

--
-- Indices de la tabla `jornadas`
--
ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`id_jornada`),
  ADD KEY `id_liga` (`id_liga`),
  ADD KEY `partido` (`partido`);

--
-- Indices de la tabla `liga`
--
ALTER TABLE `liga`
  ADD PRIMARY KEY (`id_liga`);

--
-- Indices de la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD PRIMARY KEY (`id_partidos`),
  ADD KEY `equipo_local` (`equipo_local`),
  ADD KEY `equipo_visitante` (`equipo_visitante`),
  ADD KEY `estadio` (`estadio`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `jornadas`
--
ALTER TABLE `jornadas`
  ADD CONSTRAINT `jornadas_ibfk_1` FOREIGN KEY (`id_liga`) REFERENCES `liga` (`id_liga`),
  ADD CONSTRAINT `jornadas_ibfk_2` FOREIGN KEY (`partido`) REFERENCES `partidos` (`id_partidos`);

--
-- Filtros para la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD CONSTRAINT `partidos_ibfk_1` FOREIGN KEY (`equipo_local`) REFERENCES `equipos` (`nombre_equipo`),
  ADD CONSTRAINT `partidos_ibfk_2` FOREIGN KEY (`equipo_visitante`) REFERENCES `equipos` (`nombre_equipo`),
  ADD CONSTRAINT `partidos_ibfk_3` FOREIGN KEY (`estadio`) REFERENCES `estadio` (`nombre_estadio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
