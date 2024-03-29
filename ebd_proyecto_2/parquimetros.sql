SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `parquimetros`
--
--

CREATE DATABASE IF NOT EXISTS `parquimetros` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `parquimetros`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accede`
--

DROP TABLE IF EXISTS `accede`;
CREATE TABLE IF NOT EXISTS `accede` (
  `legajo` int(11) unsigned NOT NULL,
  `id_parq` int(11) unsigned NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  PRIMARY KEY (`id_parq`,`fecha`,`hora`),
  KEY `legajo` (`legajo`),
  KEY `id_parq` (`id_parq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `accede`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asociado_con`
--

DROP TABLE IF EXISTS `asociado_con`;
CREATE TABLE IF NOT EXISTS `asociado_con` (
  `id_asociado_con` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `legajo` int(11) unsigned NOT NULL,
  `calle` varchar(45) NOT NULL,
  `altura` int(11) unsigned NOT NULL,
  `dia` varchar(2) NOT NULL,
  `turno` varchar(1) NOT NULL,
  PRIMARY KEY (`id_asociado_con`),
  KEY `legajo` (`legajo`),
  KEY `fk_calle_altura` (`calle`,`altura`),
  KEY `altura` (`altura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `asociado_con`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automoviles`
--

DROP TABLE IF EXISTS `automoviles`;
CREATE TABLE IF NOT EXISTS `automoviles` (
  `patente` varchar(6) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `dni` int(11) unsigned NOT NULL,
  PRIMARY KEY (`patente`),
  KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `automoviles`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductores`
--

DROP TABLE IF EXISTS `conductores`;
CREATE TABLE IF NOT EXISTS `conductores` (
  `dni` int(11) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `registro` int(11) unsigned NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `conductores`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cospeles`
--

DROP TABLE IF EXISTS `cospeles`;
CREATE TABLE IF NOT EXISTS `cospeles` (
  `id_cospel` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `saldo` decimal(5,2) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `patente` varchar(6) NOT NULL,
  PRIMARY KEY (`id_cospel`),
  KEY `tipo` (`tipo`),
  KEY `patente` (`patente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2223 ;

--
-- Volcar la base de datos para la tabla `cospeles`
--



-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `estacionados`
--
DROP VIEW IF EXISTS `estacionados`;
CREATE TABLE IF NOT EXISTS `estacionados` (
`calle` varchar(45)
,`altura` int(11) unsigned
,`patente` varchar(6)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacionamientos`
--

DROP TABLE IF EXISTS `estacionamientos`;
CREATE TABLE IF NOT EXISTS `estacionamientos` (
  `id_cospel` int(11) unsigned NOT NULL,
  `id_parq` int(11) unsigned NOT NULL,
  `fecha_ent` date NOT NULL,
  `hora_ent` time NOT NULL,
  `fecha_sal` date DEFAULT NULL,
  `hora_sal` time DEFAULT NULL,
  PRIMARY KEY (`id_parq`,`fecha_ent`,`hora_ent`),
  KEY `id_cospel` (`id_cospel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `estacionamientos`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inspectores`
--

DROP TABLE IF EXISTS `inspectores`;
CREATE TABLE IF NOT EXISTS `inspectores` (
  `legajo` int(11) unsigned NOT NULL,
  `dni` int(11) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `inspectores`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

DROP TABLE IF EXISTS `multa`;
CREATE TABLE IF NOT EXISTS `multa` (
  `numero` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `patente` varchar(6) NOT NULL,
  `id_asociado_con` int(11) unsigned NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `patente` (`patente`),
  KEY `id_asociado_con` (`id_asociado_con`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `multa`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parquimetros`
--

DROP TABLE IF EXISTS `parquimetros`;
CREATE TABLE IF NOT EXISTS `parquimetros` (
  `id_parq` int(11) unsigned NOT NULL,
  `numero` int(11) unsigned NOT NULL,
  `calle` varchar(45) NOT NULL,
  `altura` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id_parq`),
  KEY `altura` (`altura`),
  KEY `fkey_calle_altura` (`calle`,`altura`),
  KEY `calle` (`calle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `parquimetros`
--



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_cospeles`
--

DROP TABLE IF EXISTS `tipos_cospeles`;
CREATE TABLE IF NOT EXISTS `tipos_cospeles` (
  `tipo` varchar(45) NOT NULL,
  `descuento` decimal(3,2) unsigned NOT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `tipos_cospeles`
--


--
-- (Evento) desencadenante `tipos_cospeles`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicaciones`
--

DROP TABLE IF EXISTS `ubicaciones`;
CREATE TABLE IF NOT EXISTS `ubicaciones` (
  `calle` varchar(45) NOT NULL,
  `altura` int(11) unsigned NOT NULL,
  `tarifa` decimal(5,2) unsigned NOT NULL,
  PRIMARY KEY (`calle`,`altura`),
  KEY `altura_` (`altura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `id_cospel` int(11) unsigned NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `saldo` decimal(5,2) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  KEY `id_cospel` (`id_cospel`),
  KEY `tipo` (`tipo`),
  KEY `saldo` (`saldo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Estructura para la vista `estacionados`
--
DROP TABLE IF EXISTS `estacionados`;

CREATE VIEW estacionados AS SELECT calle, altura, patente
	FROM ubicaciones natural join parquimetros natural join cospeles natural join estacionamientos
	WHERE fecha_sal IS NULL AND hora_sal IS NULL;

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `accede`
--
ALTER TABLE `accede`
  ADD CONSTRAINT `accede_ibfk_1` FOREIGN KEY (`legajo`) REFERENCES `inspectores` (`legajo`),
  ADD CONSTRAINT `accede_ibfk_2` FOREIGN KEY (`id_parq`) REFERENCES `parquimetros` (`id_parq`);

--
-- Filtros para la tabla `asociado_con`
--
ALTER TABLE `asociado_con`
  ADD CONSTRAINT `asociado_con_ibfk_3` FOREIGN KEY (`legajo`) REFERENCES `inspectores` (`legajo`),
  ADD CONSTRAINT `fk_calle_altura_ubicaciones` FOREIGN KEY (`calle`, `altura`) REFERENCES `ubicaciones` (`calle`, `altura`);

--
-- Filtros para la tabla `automoviles`
--
ALTER TABLE `automoviles`
  ADD CONSTRAINT `automoviles_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `conductores` (`dni`);

--
-- Filtros para la tabla `cospeles`
--
ALTER TABLE `cospeles`
  ADD CONSTRAINT `cospeles_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipos_cospeles` (`tipo`),
  ADD CONSTRAINT `cospeles_ibfk_2` FOREIGN KEY (`patente`) REFERENCES `automoviles` (`patente`);

--
-- Filtros para la tabla `estacionamientos`
--
ALTER TABLE `estacionamientos`
  ADD CONSTRAINT `estacionamientos_ibfk_1` FOREIGN KEY (`id_cospel`) REFERENCES `cospeles` (`id_cospel`),
  ADD CONSTRAINT `estacionamientos_ibfk_2` FOREIGN KEY (`id_parq`) REFERENCES `parquimetros` (`id_parq`);

--
-- Filtros para la tabla `multa`
--
ALTER TABLE `multa`
  ADD CONSTRAINT `multa_ibfk_1` FOREIGN KEY (`patente`) REFERENCES `automoviles` (`patente`),
  ADD CONSTRAINT `multa_ibfk_2` FOREIGN KEY (`id_asociado_con`) REFERENCES `asociado_con` (`id_asociado_con`);

--
-- Filtros para la tabla `parquimetros`
--
ALTER TABLE `parquimetros`
  ADD CONSTRAINT `ForeingKey_calle_altura_ubicaciones` FOREIGN KEY (`calle`, `altura`) REFERENCES `ubicaciones` (`calle`, `altura`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cospel`) REFERENCES `cospeles` (`id_cospel`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `cospeles` (`tipo`);


-- Usuarios

CREATE USER admin@localhost IDENTIFIED BY 'admin';

CREATE USER venta IDENTIFIED BY 'venta';

CREATE USER inspector IDENTIFIED BY 'inspector';

CREATE USER parquimetro IDENTIFIED BY 'parq';

GRANT ALL PRIVILEGES ON `parquimetros`.* TO 'admin'@'localhost' WITH GRANT OPTION;

GRANT INSERT ON parquimetros.estacionamientos TO parquimetro;
GRANT SELECT ON parquimetros.estacionamientos TO parquimetro;
GRANT SELECT ON parquimetros.cospeles TO parquimetro;
GRANT SELECT ON parquimetros.ubicaciones TO parquimetro;
GRANT SELECT ON parquimetros.parquimetros TO parquimetro;
GRANT EXECUTE ON PROCEDURE parquimetros.conectar to parquimetro;

GRANT INSERT ON parquimetros.cospeles TO venta;
GRANT SELECT ON parquimetros.tipos_cospeles TO venta;
GRANT SELECT ON parquimetros.automoviles TO venta;
GRANT SELECT ON parquimetros.cospeles TO venta;

GRANT SELECT ON parquimetros.inspectores TO inspector;
GRANT SELECT ON parquimetros.parquimetros TO inspector;
GRANT SELECT ON parquimetros.estacionados TO inspector;
GRANT SELECT ON parquimetros.asociado_con TO inspector;

GRANT SELECT, INSERT ON parquimetros.multa TO inspector;
GRANT SELECT, INSERT ON parquimetros.accede TO inspector;



delimiter !
CREATE TRIGGER ventasCreacion
	AFTER INSERT on cospeles
	FOR EACH ROW
	 begin
		declare fecha DATE;
		declare hora TIME;
		SELECT date(now()) into fecha;
		SELECT time(now()) into hora;
		INSERT INTO `ventas` (`id_cospel`, `tipo`, `saldo`, `fecha`, `hora`) VALUES
				(NEW.id_cospel, NEW.tipo, NEW.saldo, fecha, hora);
	end;!
create procedure conectar (IN cospel INT(11), IN parq INT(11))
begin
	declare tiempo FLOAT;
	declare tari FLOAT;
	declare descu FLOAT;
	declare sal DECIMAL(5,2);
	declare fecha,dia_entr DATE;
	declare hora,hora_entr TIME;
	declare cont INT;
	declare entrada DATETIME;
	declare salida DATETIME;
	
		
	SELECT date(now()) into fecha;
	SELECT time(now()) into hora;
	SELECT saldo into sal FROM cospeles WHERE id_cospel = cospel;
	SELECT tarifa into tari FROM parquimetros NATURAL JOIN ubicaciones WHERE id_parq = parq;
	SELECT descuento into descu FROM cospeles NATURAL JOIN tipos_cospeles WHERE id_cospel = cospel;
	SELECT count(id_cospel) into cont from estacionamientos NATURAL JOIN parquimetros WHERE id_cospel=cospel AND id_parq=parq AND hora_sal 			is NULL AND fecha_sal is NULL;
	if cont=0 then
		select truncate(sal/(tari*(1-descu)),0) into tiempo;
		if tiempo>0 then
			INSERT INTO `estacionamientos` (`id_cospel`, `id_parq`, `fecha_ent`, `hora_ent`, `fecha_sal`, `hora_sal`) VALUES
				(cospel, parq, fecha, hora, NULL, NULL);
			SELECT 'Apertura' as operacion, 1 as resulto, tiempo as tiempo;
		else
			SELECT 'Apertura' as operacion, 0 as resulto, 0 as tiempo;
			
		end if;
	else
		SELECT fecha_ent into dia_entr from estacionamientos NATURAL JOIN parquimetros WHERE id_cospel=cospel AND id_parq=parq AND fecha_sal 			is NULL AND hora_sal is NULL;
		SELECT hora_ent into hora_entr from estacionamientos NATURAL JOIN parquimetros WHERE id_cospel=cospel AND id_parq=parq AND hora_sal 			is NULL AND fecha_sal is NULL;
		set entrada = dia_entr;
		SELECT addtime(entrada,hora_entr) into entrada;
		set salida = fecha;
		SELECT addtime(salida,hora) into salida;
		select truncate(time_to_sec(timediff(salida,entrada))/60,0) into tiempo;
		set sal = sal -tiempo*(tari*(1-descu));
		UPDATE `estacionamientos` set fecha_sal = fecha, hora_sal = hora where fecha_sal is null and hora_sal is null and id_cospel = cospel 			and id_parq = parq;
		UPDATE `cospeles` set saldo = sal where id_cospel=cospel;
		SELECT 'Cierre' as operacion, tiempo as tiempo_transcurrido, sal as saldo_nuevo;
	end if;
end; !
delimiter ;
