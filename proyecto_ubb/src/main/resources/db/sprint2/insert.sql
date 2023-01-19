INSERT INTO `rol` (`id`, `nombre`) VALUES
(1, 'Asistente de Marketing'),
(2, 'Diseñador de Producto'),
(3, 'Analista de Datos'),
(4, 'Administrador'),
(5, 'Analista de Mercado');

INSERT INTO `empresa` (`id`, `nombre`, `email`, `descripcion`) VALUES
(1, 'Gabcube', 'ccrisp0@youku.com', 'Soy una descripción de empresa genérica'),
(2, 'Buzzshare', 'abengtson1@reverbnation.com', 'Soy una descripción de empresa genérica');


INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `email`, `id_empresa`, `id_rol`) VALUES
(1, 'Sandor', 'Hatherill', 'shatherill0@cam.ac.uk', 1, 5),
(2, 'Hirsch', 'Dinwoodie', 'hdinwoodie1@netlog.com', 1, 1),
(3, 'Averill', 'Ainslie', 'aainslie2@aboutads.info', 1, 2),
(4, 'Kamilah', 'Sher', 'ksher3@disqus.com', 2, 5);


