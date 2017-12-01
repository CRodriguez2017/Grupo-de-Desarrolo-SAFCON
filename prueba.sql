-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-11-2017 a las 22:43:56
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(11) NOT NULL,
  `id_Logro` int(11) DEFAULT NULL,
  `Porcentaje` double DEFAULT NULL,
  `id_Curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id`, `Nombre`, `id_Logro`, `Porcentaje`, `id_Curso`) VALUES
(1, 'Implementa ', 3, 30, 3),
(2, 'Usa Ciclos', 3, 30, 3),
(3, 'Condcionale', 3, 40, 3),
(4, 'Metodo Main', 4, 30, 3),
(5, 'Crea Frame', 4, 30, 3),
(6, 'Usa Interna', 4, 40, 3),
(7, 'Hola Mundo', 7, 30, 3),
(8, 'Index.php', 7, 30, 3),
(9, 'Resuelve Lo', 7, 40, 3),
(10, 'Estructura ', 8, 30, 3),
(11, 'Etiquetas C', 8, 30, 3),
(12, 'Sessiones', 8, 40, 3),
(13, 'Nuevo', 3, 0, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividadxestudiante`
--

CREATE TABLE `actividadxestudiante` (
  `id_AutoIncremente` int(11) NOT NULL,
  `id_Act` int(11) DEFAULT NULL,
  `id_Estudiante` int(11) DEFAULT NULL,
  `Nota` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actividadxestudiante`
--

INSERT INTO `actividadxestudiante` (`id_AutoIncremente`, `id_Act`, `id_Estudiante`, `Nota`) VALUES
(1, 1, 5, 3),
(2, 2, 5, 9),
(3, 3, 5, 5),
(4, 4, 5, NULL),
(5, 5, 5, NULL),
(6, 6, 5, NULL),
(7, 7, 5, NULL),
(8, 8, 5, NULL),
(9, 9, 5, NULL),
(10, 10, 5, NULL),
(11, 11, 5, NULL),
(12, 12, 5, NULL),
(13, 1, 6, 2),
(14, 2, 6, 1),
(15, 3, 6, 8),
(16, 4, 6, NULL),
(17, 5, 6, NULL),
(18, 6, 6, 9),
(19, 7, 6, NULL),
(20, 8, 6, NULL),
(21, 9, 6, NULL),
(22, 10, 6, NULL),
(23, 11, 6, NULL),
(24, 12, 6, NULL),
(25, 1, 7, 13),
(26, 2, 7, 1),
(27, 3, 7, 8),
(28, 4, 7, NULL),
(29, 5, 7, NULL),
(30, 6, 7, NULL),
(31, 7, 7, NULL),
(32, 8, 7, NULL),
(33, 9, 7, NULL),
(34, 10, 7, NULL),
(35, 11, 7, NULL),
(36, 12, 7, NULL),
(37, 13, 6, 3),
(38, 13, 5, 4),
(39, 13, 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Jornada` varchar(40) NOT NULL,
  `id_Docente_Lider` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `Nombre`, `Jornada`, `id_Docente_Lider`) VALUES
(1, 'ADSI31', 'Mañana', 3),
(2, 'ADSI63', 'Tarde', 4),
(3, 'ADSI62', 'Tarde', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE `docente` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `docente`
--

INSERT INTO `docente` (`id`) VALUES
(2),
(3),
(4),
(8),
(9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentexcursoxmateria`
--

CREATE TABLE `docentexcursoxmateria` (
  `id_AutoIncremente` int(11) NOT NULL,
  `id_Docente` int(11) DEFAULT NULL,
  `id_Curso` int(11) DEFAULT NULL,
  `id_Materia` int(11) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `docentexcursoxmateria`
--

INSERT INTO `docentexcursoxmateria` (`id_AutoIncremente`, `id_Docente`, `id_Curso`, `id_Materia`, `fecha`) VALUES
(1, 2, 3, 1, '0000-00-00'),
(2, 3, 3, 2, '0000-00-00'),
(3, 4, 3, 4, '0000-00-00'),
(4, 2, 2, 1, '0000-00-00'),
(5, 2, 1, 1, '0000-00-00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `id_AutoIncremente` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `id_Curso` int(11) NOT NULL,
  `id_Acudiente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`id_AutoIncremente`, `id`, `id_Curso`, `id_Acudiente`) VALUES
(1, 5, 3, 0),
(2, 6, 3, 0),
(3, 7, 3, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logros`
--

CREATE TABLE `logros` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(11) NOT NULL,
  `tipo_Logro` varchar(20) DEFAULT NULL,
  `id_Materia` int(11) DEFAULT NULL,
  `id_Periodo` int(11) DEFAULT NULL,
  `Porcentaje` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `logros`
--

INSERT INTO `logros` (`id`, `Nombre`, `tipo_Logro`, `id_Materia`, `id_Periodo`, `Porcentaje`) VALUES
(1, 'Examen Fina', 'Institucional', 1, 1, 35),
(2, 'Disciplina', 'Institucional', 1, 1, 15),
(3, 'Logicas', 'Academico', 1, 1, 25),
(4, 'Gestor Fram', 'Academico', 1, 1, 25),
(5, 'Examen Fina', 'Institucional', 2, 1, 35),
(6, 'Disciplina', 'Institucional', 2, 1, 15),
(7, 'Logicas en ', 'Academico', 2, 1, 25),
(8, 'Crea Pagina', 'Academico', 2, 1, 25),
(9, 'Examen Fina', 'Institucional', 4, 1, 35),
(10, 'Disciplina', 'Institucional', 4, 1, 15),
(11, 'Lectura', 'Academico', 4, 1, 25),
(12, 'Crea Pagina', 'Escritura', 4, 1, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logroxestudiante`
--

CREATE TABLE `logroxestudiante` (
  `id_AutoIncremente` int(11) NOT NULL,
  `id_Logro` int(11) DEFAULT NULL,
  `id_Estudiante` int(11) DEFAULT NULL,
  `Nota` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `logroxestudiante`
--

INSERT INTO `logroxestudiante` (`id_AutoIncremente`, `id_Logro`, `id_Estudiante`, `Nota`) VALUES
(1, 2, 6, 8),
(2, 2, 5, 2),
(3, 2, 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`id`, `Nombre`) VALUES
(1, 'Java'),
(2, 'PHP'),
(3, 'Bases D'),
(4, 'Ingles'),
(5, 'Ambielta'),
(6, 'Comunicaiones'),
(7, 'Etica'),
(8, 'Algoritmia'),
(9, 'Deporte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiaxestudiantexperiodo`
--

CREATE TABLE `materiaxestudiantexperiodo` (
  `id_AutoIncremente` int(11) NOT NULL,
  `id_Materia` int(11) DEFAULT NULL,
  `id_Estudiante` int(11) DEFAULT NULL,
  `Nota` double DEFAULT NULL,
  `Observaciones` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Porcentaje` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`id`, `Nombre`, `Porcentaje`) VALUES
(1, 'Periodo 1', NULL),
(2, 'Periodo 2', NULL),
(3, 'Periodo 3', NULL),
(4, 'Periodo 4', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `Nombre`) VALUES
(1, 'Administrador'),
(2, 'Docente'),
(3, 'Gestion'),
(4, 'Acudiente'),
(5, 'Estudiante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `Documento` bigint(20) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `PrimerApellido` varchar(25) NOT NULL,
  `SegundoApellido` varchar(25) DEFAULT NULL,
  `User` varchar(40) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `id_Rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Documento`, `Nombre`, `PrimerApellido`, `SegundoApellido`, `User`, `Password`, `id_Rol`) VALUES
(1, 1144041538, 'Jonatan', 'Rojas', 'Reina', 'jjrr13', 'soloJJ', 1),
(2, 1144041537, 'Jonatan', 'Velazco', 'Garcia', 'jonavela', '123', 2),
(3, 1144041536, 'Eneresto', 'Campos', 'Trivvias', 'misterenest', '123', 2),
(4, 1144041535, 'Mauricio', 'Tapaz', 'Oto', 'english', '123', 2),
(5, 1144041534, 'Cristian', 'Rodriguez', 'Negro', 'guillermino', '123', 5),
(6, 1144041533, 'Sebastian', 'Rodriguez', 'Negro2', 'gafitas', '123', 5),
(7, 1144041532, 'John', 'Sotelo', 'neg', 'genio', '123', 5),
(8, 1144041530, 'Andres', 'Montoya', 'Rodriguez', 'el de la 53', '123', 2),
(9, 1144041529, 'Sergio', 'Casas', 'Master', 'secama', '123', 2);

--
-- Disparadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `insertDoc` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
    	IF(new.id_Rol=2) THEN 
        	INSERT INTO docente VALUES (new.id);
        END IF;
	END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_Logro` (`id_Logro`),
  ADD KEY `id_Curso` (`id_Curso`);

--
-- Indices de la tabla `actividadxestudiante`
--
ALTER TABLE `actividadxestudiante`
  ADD PRIMARY KEY (`id_AutoIncremente`),
  ADD KEY `id_Estudiante` (`id_Estudiante`),
  ADD KEY `actxest_materias` (`id_Act`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_Docente_Lider` (`id_Docente_Lider`);

--
-- Indices de la tabla `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `docentexcursoxmateria`
--
ALTER TABLE `docentexcursoxmateria`
  ADD PRIMARY KEY (`id_AutoIncremente`),
  ADD KEY `id_Docente` (`id_Docente`),
  ADD KEY `id_Curso` (`id_Curso`),
  ADD KEY `id_Materia` (`id_Materia`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_AutoIncremente` (`id_AutoIncremente`),
  ADD KEY `id_Acudiente` (`id_Acudiente`),
  ADD KEY `id_Curso` (`id_Curso`);

--
-- Indices de la tabla `logros`
--
ALTER TABLE `logros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `logros_materias` (`id_Materia`),
  ADD KEY `periodo_logro` (`id_Periodo`);

--
-- Indices de la tabla `logroxestudiante`
--
ALTER TABLE `logroxestudiante`
  ADD UNIQUE KEY `id` (`id_AutoIncremente`),
  ADD KEY `id_Estudiante` (`id_Estudiante`),
  ADD KEY `logxest_logros` (`id_Logro`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materiaxestudiantexperiodo`
--
ALTER TABLE `materiaxestudiantexperiodo`
  ADD UNIQUE KEY `id_Auto_Increment` (`id_AutoIncremente`),
  ADD KEY `id_Estudiante` (`id_Estudiante`),
  ADD KEY `matxestxper_materias` (`id_Materia`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Documento` (`Documento`),
  ADD UNIQUE KEY `User` (`User`),
  ADD KEY `id_Rol` (`id_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `actividadxestudiante`
--
ALTER TABLE `actividadxestudiante`
  MODIFY `id_AutoIncremente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `docentexcursoxmateria`
--
ALTER TABLE `docentexcursoxmateria`
  MODIFY `id_AutoIncremente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `id_AutoIncremente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `logros`
--
ALTER TABLE `logros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `logroxestudiante`
--
ALTER TABLE `logroxestudiante`
  MODIFY `id_AutoIncremente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `materiaxestudiantexperiodo`
--
ALTER TABLE `materiaxestudiantexperiodo`
  MODIFY `id_AutoIncremente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `periodo`
--
ALTER TABLE `periodo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`id_Logro`) REFERENCES `logros` (`id`),
  ADD CONSTRAINT `actividad_ibfk_2` FOREIGN KEY (`id_Curso`) REFERENCES `cursos` (`id`);

--
-- Filtros para la tabla `actividadxestudiante`
--
ALTER TABLE `actividadxestudiante`
  ADD CONSTRAINT `actividadxestudiante_ibfk_2` FOREIGN KEY (`id_Estudiante`) REFERENCES `estudiante` (`id`),
  ADD CONSTRAINT `actxest_materias` FOREIGN KEY (`id_Act`) REFERENCES `actividad` (`id`);

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`id_Docente_Lider`) REFERENCES `docente` (`id`);

--
-- Filtros para la tabla `docente`
--
ALTER TABLE `docente`
  ADD CONSTRAINT `docente_usuario` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `docentexcursoxmateria`
--
ALTER TABLE `docentexcursoxmateria`
  ADD CONSTRAINT `docentexcursoxmateria_ibfk_1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`),
  ADD CONSTRAINT `docentexcursoxmateria_ibfk_4` FOREIGN KEY (`id_Curso`) REFERENCES `cursos` (`id`),
  ADD CONSTRAINT `docentexcursoxmateria_ibfk_5` FOREIGN KEY (`id_Materia`) REFERENCES `materias` (`id`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `estudiante_ibfk_2` FOREIGN KEY (`id_Curso`) REFERENCES `cursos` (`id`);

--
-- Filtros para la tabla `logros`
--
ALTER TABLE `logros`
  ADD CONSTRAINT `logros_materias` FOREIGN KEY (`id_Materia`) REFERENCES `materias` (`id`),
  ADD CONSTRAINT `periodo_logro` FOREIGN KEY (`id_Periodo`) REFERENCES `periodo` (`id`);

--
-- Filtros para la tabla `logroxestudiante`
--
ALTER TABLE `logroxestudiante`
  ADD CONSTRAINT `logroxestudiante_ibfk_2` FOREIGN KEY (`id_Estudiante`) REFERENCES `estudiante` (`id`),
  ADD CONSTRAINT `logxest_logros` FOREIGN KEY (`id_Logro`) REFERENCES `logros` (`id`);

--
-- Filtros para la tabla `materiaxestudiantexperiodo`
--
ALTER TABLE `materiaxestudiantexperiodo`
  ADD CONSTRAINT `materiaxestudiantexperiodo_ibfk_2` FOREIGN KEY (`id_Estudiante`) REFERENCES `estudiante` (`id`),
  ADD CONSTRAINT `matxestxper_materias` FOREIGN KEY (`id_Materia`) REFERENCES `materias` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_Rol`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
