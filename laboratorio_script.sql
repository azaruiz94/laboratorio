# Host: localhost  (Version 5.5.21)
# Date: 2019-10-24 16:48:58
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "analisis"
#

DROP TABLE IF EXISTS `analisis`;
CREATE TABLE `analisis` (
  `id` int(11) NOT NULL,
  `costo` double NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `sexo_id` tinyblob NOT NULL,
  `tipo_analisis_id` tinyblob NOT NULL,
  `_valor_referencia_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qniayc6d6tw0mnmook25q7xg` (`nombre`),
  KEY `FK8f98t0ca4nowax4cjvkaoqk38` (`_valor_referencia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "analisis"
#

/*!40000 ALTER TABLE `analisis` DISABLE KEYS */;
INSERT INTO `analisis` VALUES (1,30000,'Glicemia',X'31',X'31',1);
/*!40000 ALTER TABLE `analisis` ENABLE KEYS */;

#
# Structure for table "centro_asistencial"
#

DROP TABLE IF EXISTS `centro_asistencial`;
CREATE TABLE `centro_asistencial` (
  `id` int(11) NOT NULL,
  `ciudad_id` tinyblob,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l7jhhujxs1w7ayjr4pn6d87mv` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "centro_asistencial"
#

/*!40000 ALTER TABLE `centro_asistencial` DISABLE KEYS */;
INSERT INTO `centro_asistencial` VALUES (1,X'31','La Trinidad');
/*!40000 ALTER TABLE `centro_asistencial` ENABLE KEYS */;

#
# Structure for table "ciudad"
#

DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `_departamento_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK71bk8yanxnjvj5ld26nsyaros` (`_departamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "ciudad"
#

/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Encarnacion',1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

#
# Structure for table "departamento"
#

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `_pais_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4muh9ywpaoqfo2eel0xsewl0p` (`_pais_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "departamento"
#

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Encarnacion',1);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;

#
# Structure for table "estado"
#

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "estado"
#

/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Pendiente');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

#
# Structure for table "factura"
#

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `descuento` double DEFAULT NULL,
  `nro_factura` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iegwcct7y1e3nqbx2b0glhwbs` (`nro_factura`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "factura"
#

/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,0,1,30000,1);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

#
# Structure for table "factura_detalle"
#

DROP TABLE IF EXISTS `factura_detalle`;
CREATE TABLE `factura_detalle` (
  `id` int(11) NOT NULL,
  `iva` int(11) DEFAULT NULL,
  `precio_unitario` double DEFAULT NULL,
  `solicitud_detalle` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `_factura_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1u729xsl9kc7c67k19j4ckit` (`_factura_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "factura_detalle"
#

/*!40000 ALTER TABLE `factura_detalle` DISABLE KEYS */;
INSERT INTO `factura_detalle` VALUES (1,10,30000,1,30000,1);
/*!40000 ALTER TABLE `factura_detalle` ENABLE KEYS */;

#
# Structure for table "hibernate_sequence"
#

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "hibernate_sequence"
#

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

#
# Structure for table "iva"
#

DROP TABLE IF EXISTS `iva`;
CREATE TABLE `iva` (
  `id` int(11) NOT NULL,
  `valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "iva"
#

/*!40000 ALTER TABLE `iva` DISABLE KEYS */;
INSERT INTO `iva` VALUES (1,10);
/*!40000 ALTER TABLE `iva` ENABLE KEYS */;

#
# Structure for table "metrica"
#

DROP TABLE IF EXISTS `metrica`;
CREATE TABLE `metrica` (
  `id` int(11) NOT NULL,
  `unidad_medida` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t2itlwrejigxp9cv7mw500rh1` (`unidad_medida`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "metrica"
#

/*!40000 ALTER TABLE `metrica` DISABLE KEYS */;
INSERT INTO `metrica` VALUES (1,'ml');
/*!40000 ALTER TABLE `metrica` ENABLE KEYS */;

#
# Structure for table "pais"
#

DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6yjd7o5t29ban947untn2ir2b` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "pais"
#

/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Paraguay');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;

#
# Structure for table "persona"
#

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `ciudad_id` tinyblob NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_registro` int(11) DEFAULT NULL,
  `ruc_ci` varchar(255) DEFAULT NULL,
  `sexo` tinyblob NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_persona_id` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "persona"
#

/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,X'31','Avda. Caballeo','fulano@gmail.com','Fulano',2344,'123456',X'31','0975655423',X'31');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

#
# Structure for table "sexo"
#

DROP TABLE IF EXISTS `sexo`;
CREATE TABLE `sexo` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "sexo"
#

/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;

#
# Structure for table "solicitud"
#

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE `solicitud` (
  `id` int(11) NOT NULL,
  `centro_asistencial_id` tinyblob,
  `doctor_id` tinyblob,
  `estado_id` tinyblob,
  `paciente_id` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "solicitud"
#

/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES (1,X'31',X'31',X'31',X'31');
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;

#
# Structure for table "solicitud_detalle"
#

DROP TABLE IF EXISTS `solicitud_detalle`;
CREATE TABLE `solicitud_detalle` (
  `id` int(11) NOT NULL,
  `analisis_id` tinyblob,
  `bioquimico` tinyblob,
  `valor_obtenido` varchar(255) DEFAULT NULL,
  `_solicitud_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmyoowhnikg6edaw4i08p8kv43` (`_solicitud_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "solicitud_detalle"
#

/*!40000 ALTER TABLE `solicitud_detalle` DISABLE KEYS */;
INSERT INTO `solicitud_detalle` VALUES (1,X'31',X'31','3',1);
/*!40000 ALTER TABLE `solicitud_detalle` ENABLE KEYS */;

#
# Structure for table "tipo_analisis"
#

DROP TABLE IF EXISTS `tipo_analisis`;
CREATE TABLE `tipo_analisis` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3gst1jkmc5b4o9l6hbu4kv6yp` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tipo_analisis"
#

/*!40000 ALTER TABLE `tipo_analisis` DISABLE KEYS */;
INSERT INTO `tipo_analisis` VALUES (1,'Hemograma');
/*!40000 ALTER TABLE `tipo_analisis` ENABLE KEYS */;

#
# Structure for table "tipo_persona"
#

DROP TABLE IF EXISTS `tipo_persona`;
CREATE TABLE `tipo_persona` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tipo_persona"
#

/*!40000 ALTER TABLE `tipo_persona` DISABLE KEYS */;
INSERT INTO `tipo_persona` VALUES (1,'Bioquimico');
/*!40000 ALTER TABLE `tipo_persona` ENABLE KEYS */;

#
# Structure for table "usuario"
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `estado_id` tinyblob,
  `nombre` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `persona_id` tinyblob,
  PRIMARY KEY (`_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "usuario"
#

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,X'31','fulanitouser','87654321',X'31');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

#
# Structure for table "valor_referencia"
#

DROP TABLE IF EXISTS `valor_referencia`;
CREATE TABLE `valor_referencia` (
  `id` int(11) NOT NULL,
  `max` varchar(255) DEFAULT NULL,
  `min` varchar(255) DEFAULT NULL,
  `_metrica_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3m08n8q5nceot9qw0nwov27ye` (`_metrica_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "valor_referencia"
#

/*!40000 ALTER TABLE `valor_referencia` DISABLE KEYS */;
INSERT INTO `valor_referencia` VALUES (1,'2','7',1);
/*!40000 ALTER TABLE `valor_referencia` ENABLE KEYS */;
