--
-- PostgreSQL database dump
--


INSERT INTO modulo VALUES (2, '/main/configuracion/home.xhtml?idMenu=2', 'ACTIVO', '2016-03-18 17:35:15', NULL, 'icon-printer2 Opac80 Fs22', 'Configuración', 'Configuraciones generales', NULL);
INSERT INTO modulo VALUES (1, '/main/cobranza/home.xhtml?idMenu=1', 'ACTIVO', '2016-03-18 17:35:15', NULL, 'icon-printer2 Opac80 Fs22', 'Cobranza', 'Gestion de reclamos', NULL);


--
-- Data for Name: submenu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO submenu VALUES (1, 'ACTIVO', '2016-03-18 17:35:15', NULL, 'icon-uniE675', 'Empresas', 2, NULL);

INSERT INTO submenu VALUES (3, 'ACTIVO', '2016-03-18 17:35:15', NULL, 'icon-uniE675', 'Personas', 2, NULL);
INSERT INTO submenu VALUES (2, 'ACTIVO', '2016-03-18 17:35:15', NULL, 'icon-uniE675', 'Gestión', 1, NULL);


--
-- Data for Name: menuitem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO menuitem VALUES (1, 'ACTIVO', NULL, NULL, 'icon-uniE675', '/main/configuracion/empresa/listado.xhtml', 'Empresa', 1, NULL);
INSERT INTO menuitem VALUES (1, 'ACTIVO', NULL, NULL, 'icon-uniE675', '/main/configuracion/cliente/listado.xhtml', 'Cliente', 3, NULL);
INSERT INTO menuitem VALUES (2, 'ACTIVO', NULL, NULL, 'icon-uniE675', '#', 'Sucursal', 1, NULL);
INSERT INTO menuitem VALUES (3, 'ACTIVO', NULL, NULL, 'icon-uniE675', '#', 'Nueva', 2, NULL);

SELECT pg_catalog.setval('menuitem_id_seq', 3, true);
SELECT pg_catalog.setval('modulo_id_seq', 2, true);
SELECT pg_catalog.setval('submenu_id_seq', 2, true);

