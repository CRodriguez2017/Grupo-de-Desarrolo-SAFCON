-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-11-2017 a las 14:21:41
-- Versión del servidor: 5.6.13
-- Versión de PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `prueba`
--
CREATE DATABASE IF NOT EXISTS `prueba` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `prueba`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `id_Docente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Docente` (`id_Docente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `Nombre`, `id_Docente`) VALUES
(1, 'ADSI 62', 1),
(2, 'ADSI 63', 2),
(3, 'ADSI 65', 3),
(4, 'ADSI 55', 4),
(5, 'ADSI 51', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE IF NOT EXISTS `docentes` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`id`, `Nombre`) VALUES
(1, 'Christian Rodriguez'),
(2, 'Sebastian Rodriguez'),
(3, 'Faber Ordoñez'),
(4, 'Jhonatan'),
(5, 'Sotelo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logros`
--

CREATE TABLE IF NOT EXISTS `logros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) DEFAULT NULL,
  `Porcentaje` int(11) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `Periodo` int(11) DEFAULT NULL,
  `id_Materias` int(11) DEFAULT NULL,
  `Tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Periodo` (`Periodo`),
  KEY `id_Materias` (`id_Materias`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `logros`
--

INSERT INTO `logros` (`id`, `Nombre`, `Porcentaje`, `Descripcion`, `Periodo`, `id_Materias`, `Tipo`) VALUES
(1, 'Sumar', 10, 'Aprende a sumar', 1, 2, 'ACADEMICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE IF NOT EXISTS `materias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) DEFAULT NULL,
  `id_Docente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Docente` (`id_Docente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`id`, `Nombre`, `id_Docente`) VALUES
(1, 'Sociales', 1),
(2, 'Matematicas', 2),
(3, 'Español', 3),
(4, 'Ingles', 4),
(5, 'Economia', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE IF NOT EXISTS `periodo` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Porcentaje` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`id`, `Nombre`, `Porcentaje`) VALUES
(1, 'Primer Periodo', 25),
(2, 'Segundo Periodo', 25),
(3, 'Tercer Periodo', 25),
(4, 'Cuarto Periodo', 25);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`id_Docente`) REFERENCES `docentes` (`id`);

--
-- Filtros para la tabla `logros`
--
ALTER TABLE `logros`
  ADD CONSTRAINT `logros_ibfk_1` FOREIGN KEY (`Periodo`) REFERENCES `periodo` (`id`),
  ADD CONSTRAINT `logros_ibfk_2` FOREIGN KEY (`id_Materias`) REFERENCES `materias` (`id`);

--
-- Filtros para la tabla `materias`
--
ALTER TABLE `materias`
  ADD CONSTRAINT `materias_ibfk_1` FOREIGN KEY (`id_Docente`) REFERENCES `docentes` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
