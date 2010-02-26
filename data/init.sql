--formato
INSERT INTO formato(id, capacidad, nombre)
VALUES (1, 500, '500 cc');
INSERT INTO formato(id, capacidad, nombre)
VALUES (2, 600, '600 cc');
INSERT INTO formato(id, capacidad, nombre)
VALUES (3, 1000, '1 lt');
INSERT INTO formato(id, capacidad, nombre)
VALUES (4, 1500, '1.5 lts');
INSERT INTO formato(id, capacidad, nombre)
VALUES (5, 2000, '2 lts');
INSERT INTO formato(id, capacidad, nombre)
VALUES (6, 2250, '2.25 lts');
INSERT INTO formato(id, capacidad, nombre)
VALUES (7, 5000, '5 lts');

--producto 
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (1, 'Agua Chica', 1, '1000', '0.6', '100000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (2, 'Agua 600', 2, '1000', '0.7', '90000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (3, 'Agua Lt. y 1/2', 4, '1000', '1.0', '110000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (4, 'Agua Grande', 5, '1000', '1.5', '120000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (5, 'Agua Bidon', 7, '1000', '3.0', '300000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (6, 'Soda Sifon', 5, '1000', '1.2', '250000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (7, 'Soda Botella', 6, '1000', '1.4', '190000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (8, 'Gaseosa Sport', 6, '1000', '2.4', '40000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (9, 'Gaseosa Plena', 1, '1000', '1.0', '115000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (10, 'Saborizada Chica', 1, '1000', '1.8', '80000');
INSERT INTO producto(id, nombre, id_formato, lote_minimo, utilidad, inventario_seguridad)
VALUES (11, 'Saborizada Grande', 4, '1000', '2.0', '112000');

--clientes
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (1, 'Cliente', '1', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (2, 'Cliente', '2', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (3, 'Cliente', '3', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (4, 'Cliente', '4', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (5, 'Cliente', '5', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (6, 'Cliente', '6', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (7, 'Cliente', '7', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (8, 'Cliente', '8', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (9, 'Cliente', '9', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (10, 'Cliente', '10', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (11, 'Cliente', '11', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (12, 'Cliente', '12', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (13, 'Cliente', '13', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (14, 'Cliente', '14', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (15, 'Cliente', '15', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (16, 'Cliente', '16', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (17, 'Cliente', '17', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (18, 'Cliente', '18', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (19, 'Cliente', '19', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (20, 'Cliente', '20', 'xx', '02293422323');
INSERT INTO cliente(id, nombre, apellido, direccion, telefono)
VALUES (21, 'Cliente', '21', 'xx', '02293422323');

--pedidos de enero 2009
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (1, '01/01/2009', 1, 4, 73017);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (2, '01/01/2009', 2, 2, 2344);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (3, '01/01/2009', 3, 15, 7084);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (4, '01/01/2009', 4, 18, 131485);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (5, '01/01/2009', 5, 11, 42837);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (6, '01/01/2009', 6, 1, 139065);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (7, '01/01/2009', 7, 17, 39797);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (8, '01/01/2009', 8, 20, 84311);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (9, '01/01/2009', 9, 8, 92731);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (10, '01/01/2009', 10, 7, 20878);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (11, '01/01/2009', 11, 17, 58685);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (12, '02/01/2009', 1, 13, 86434);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (13, '02/01/2009', 2, 6, 100659);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (14, '02/01/2009', 3, 16, 131088);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (15, '02/01/2009', 4, 5, 132075);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (16, '02/01/2009', 5, 6, 48809);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (17, '02/01/2009', 6, 4, 127976);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (18, '02/01/2009', 7, 10, 72167);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (19, '02/01/2009', 8, 19, 57533);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (20, '02/01/2009', 9, 10, 794);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (21, '02/01/2009', 10, 18, 112924);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (22, '02/01/2009', 11, 14, 53252);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (23, '03/01/2009', 1, 8, 129799);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (24, '03/01/2009', 2, 10, 137669);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (25, '03/01/2009', 3, 12, 147143);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (26, '03/01/2009', 4, 18, 86105);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (27, '03/01/2009', 5, 16, 113195);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (28, '03/01/2009', 6, 20, 132381);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (29, '03/01/2009', 7, 12, 30589);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (30, '03/01/2009', 8, 13, 10420);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (31, '03/01/2009', 9, 20, 72732);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (32, '03/01/2009', 10, 6, 102623);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (33, '03/01/2009', 11, 16, 131073);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (34, '04/01/2009', 1, 12, 63712);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (35, '04/01/2009', 2, 21, 19022);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (36, '04/01/2009', 3, 14, 122884);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (37, '04/01/2009', 4, 7, 73167);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (38, '04/01/2009', 5, 18, 101707);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (39, '04/01/2009', 6, 9, 149951);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (40, '04/01/2009', 7, 6, 148613);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (41, '04/01/2009', 8, 7, 52118);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (42, '04/01/2009', 9, 5, 103637);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (43, '04/01/2009', 10, 5, 66401);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (44, '04/01/2009', 11, 18, 11598);

INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (45, '05/01/2009', 1, 17, 17000);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (46, '05/01/2009', 2, 6, 193500);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (47, '05/01/2009', 3, 10, 1200);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (48, '05/01/2009', 4, 5, 69120);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (49, '05/01/2009', 5, 14, 1848);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (50, '05/01/2009', 6, 13, 34560);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (51, '05/01/2009', 7, 14, 4800);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (52, '05/01/2009', 8, 11, 65400);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (53, '05/01/2009', 9, 16, 32400);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (54, '05/01/2009', 10, 15, 79200);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (55, '05/01/2009', 11, 17, 10800);

INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (56, '06/01/2009', 1, 12, 17318);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (57, '06/01/2009', 2, 5, 104631);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (58, '06/01/2009', 3, 4, 59628);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (59, '06/01/2009', 4, 13, 55619);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (60, '06/01/2009', 5, 14, 52583);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (61, '06/01/2009', 6, 1, 73481);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (62, '06/01/2009', 7, 9, 111732);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (63, '06/01/2009', 8, 3, 140789);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (64, '06/01/2009', 9, 2, 38688);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (65, '06/01/2009', 10, 15, 107810);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (66, '06/01/2009', 11, 20, 140624);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (67, '07/01/2009', 1, 21, 40176);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (68, '07/01/2009', 2, 17, 119610);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (69, '07/01/2009', 3, 13, 145829);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (70, '07/01/2009', 4, 20, 16146);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (71, '07/01/2009', 5, 7, 78153);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (72, '07/01/2009', 6, 2, 61903);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (73, '07/01/2009', 7, 13, 127991);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (74, '07/01/2009', 8, 11, 62739);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (75, '07/01/2009', 9, 2, 144059);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (76, '07/01/2009', 10, 5, 121449);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (77, '07/01/2009', 11, 11, 60766);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (78, '08/01/2009', 1, 20, 126431);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (79, '08/01/2009', 2, 19, 71963);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (80, '08/01/2009', 3, 15, 148169);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (81, '08/01/2009', 4, 6, 26040);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (82, '08/01/2009', 5, 8, 35477);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (83, '08/01/2009', 6, 14, 95014);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (84, '08/01/2009', 7, 3, 105729);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (85, '08/01/2009', 8, 16, 103982);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (86, '08/01/2009', 9, 14, 9701);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (87, '08/01/2009', 10, 8, 13589);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (88, '08/01/2009', 11, 11, 130901);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (89, '09/01/2009', 1, 21, 64936);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (90, '09/01/2009', 2, 6, 60091);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (91, '09/01/2009', 3, 12, 95244);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (92, '09/01/2009', 4, 9, 91053);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (93, '09/01/2009', 5, 20, 70625);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (94, '09/01/2009', 6, 17, 2570);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (95, '09/01/2009', 7, 7, 25358);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (96, '09/01/2009', 8, 9, 132690);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (97, '09/01/2009', 9, 21, 69585);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (98, '09/01/2009', 10, 4, 100525);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (99, '09/01/2009', 11, 6, 49191);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (100, '10/01/2009', 1, 17, 8853);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (101, '10/01/2009', 2, 20, 100166);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (102, '10/01/2009', 3, 3, 142679);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (103, '10/01/2009', 4, 3, 100311);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (104, '10/01/2009', 5, 11, 100460);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (105, '10/01/2009', 6, 14, 9356);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (106, '10/01/2009', 7, 2, 39740);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (107, '10/01/2009', 8, 16, 83070);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (108, '10/01/2009', 9, 2, 48150);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (109, '10/01/2009', 10, 13, 127127);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (110, '10/01/2009', 11, 19, 120642);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (111, '11/01/2009', 1, 3, 23220);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (112, '11/01/2009', 2, 16, 80347);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (113, '11/01/2009', 3, 14, 132107);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (114, '11/01/2009', 4, 3, 95089);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (115, '11/01/2009', 5, 1, 35799);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (116, '11/01/2009', 6, 17, 130772);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (117, '11/01/2009', 7, 2, 118317);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (118, '11/01/2009', 8, 20, 27851);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (119, '11/01/2009', 9, 9, 96841);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (120, '11/01/2009', 10, 12, 109560);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (121, '11/01/2009', 11, 16, 125745);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (122, '12/01/2009', 1, 3, 120875);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (123, '12/01/2009', 2, 9, 91976);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (124, '12/01/2009', 3, 16, 88867);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (125, '12/01/2009', 4, 3, 123528);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (126, '12/01/2009', 5, 15, 28908);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (127, '12/01/2009', 6, 2, 53632);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (128, '12/01/2009', 7, 12, 99467);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (129, '12/01/2009', 8, 5, 76774);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (130, '12/01/2009', 9, 2, 118457);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (131, '12/01/2009', 10, 14, 86852);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (132, '12/01/2009', 11, 18, 20777);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (133, '13/01/2009', 1, 15, 64843);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (134, '13/01/2009', 2, 20, 81415);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (135, '13/01/2009', 3, 15, 119990);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (136, '13/01/2009', 4, 19, 84164);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (137, '13/01/2009', 5, 15, 7271);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (138, '13/01/2009', 6, 2, 82643);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (139, '13/01/2009', 7, 16, 103050);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (140, '13/01/2009', 8, 8, 1912);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (141, '13/01/2009', 9, 21, 87900);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (142, '13/01/2009', 10, 10, 77382);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (143, '13/01/2009', 11, 6, 116272);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (144, '14/01/2009', 1, 15, 11167);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (145, '14/01/2009', 2, 4, 11253);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (146, '14/01/2009', 3, 8, 7726);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (147, '14/01/2009', 4, 12, 38692);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (148, '14/01/2009', 5, 17, 123675);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (149, '14/01/2009', 6, 10, 52968);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (150, '14/01/2009', 7, 8, 31999);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (151, '14/01/2009', 8, 8, 110526);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (152, '14/01/2009', 9, 14, 47288);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (153, '14/01/2009', 10, 7, 17375);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (154, '14/01/2009', 11, 10, 128005);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (155, '15/01/2009', 1, 10, 18154);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (156, '15/01/2009', 2, 11, 37099);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (157, '15/01/2009', 3, 21, 37085);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (158, '15/01/2009', 4, 10, 95232);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (159, '15/01/2009', 5, 3, 6199);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (160, '15/01/2009', 6, 21, 127236);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (161, '15/01/2009', 7, 8, 1317);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (162, '15/01/2009', 8, 20, 120359);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (163, '15/01/2009', 9, 5, 73636);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (164, '15/01/2009', 10, 9, 22126);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (165, '15/01/2009', 11, 16, 125699);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (166, '16/01/2009', 1, 20, 11973);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (167, '16/01/2009', 2, 17, 84771);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (168, '16/01/2009', 3, 19, 17397);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (169, '16/01/2009', 4, 21, 123899);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (170, '16/01/2009', 5, 20, 38301);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (171, '16/01/2009', 6, 9, 70573);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (172, '16/01/2009', 7, 7, 64600);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (173, '16/01/2009', 8, 4, 17778);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (174, '16/01/2009', 9, 14, 51717);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (175, '16/01/2009', 10, 9, 33255);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (176, '16/01/2009', 11, 18, 119347);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (177, '17/01/2009', 1, 13, 121285);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (178, '17/01/2009', 2, 8, 58378);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (179, '17/01/2009', 3, 18, 101437);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (180, '17/01/2009', 4, 5, 9810);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (181, '17/01/2009', 5, 10, 16219);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (182, '17/01/2009', 6, 9, 39497);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (183, '17/01/2009', 7, 14, 124224);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (184, '17/01/2009', 8, 5, 93932);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (185, '17/01/2009', 9, 9, 117927);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (186, '17/01/2009', 10, 10, 11960);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (187, '17/01/2009', 11, 10, 75497);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (188, '18/01/2009', 1, 10, 118928);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (189, '18/01/2009', 2, 13, 35329);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (190, '18/01/2009', 3, 10, 6041);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (191, '18/01/2009', 4, 12, 132204);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (192, '18/01/2009', 5, 16, 21491);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (193, '18/01/2009', 6, 1, 92779);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (194, '18/01/2009', 7, 4, 124572);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (195, '18/01/2009', 8, 8, 76370);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (196, '18/01/2009', 9, 15, 7420);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (197, '18/01/2009', 10, 13, 143303);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (198, '18/01/2009', 11, 13, 136788);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (199, '19/01/2009', 1, 8, 103200);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (200, '19/01/2009', 2, 9, 131148);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (201, '19/01/2009', 3, 19, 19765);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (202, '19/01/2009', 4, 16, 43618);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (203, '19/01/2009', 5, 7, 65220);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (204, '19/01/2009', 6, 13, 82136);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (205, '19/01/2009', 7, 5, 19973);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (206, '19/01/2009', 8, 18, 94631);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (207, '19/01/2009', 9, 8, 58183);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (208, '19/01/2009', 10, 2, 72236);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (209, '19/01/2009', 11, 7, 8812);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (210, '20/01/2009', 1, 11, 121539);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (211, '20/01/2009', 2, 8, 52353);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (212, '20/01/2009', 3, 16, 13076);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (213, '20/01/2009', 4, 4, 99260);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (214, '20/01/2009', 5, 7, 36713);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (215, '20/01/2009', 6, 17, 52708);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (216, '20/01/2009', 7, 11, 48196);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (217, '20/01/2009', 8, 19, 73236);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (218, '20/01/2009', 9, 2, 89173);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (219, '20/01/2009', 10, 19, 63564);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (220, '20/01/2009', 11, 17, 3244);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (221, '21/01/2009', 1, 15, 129886);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (222, '21/01/2009', 2, 13, 106750);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (223, '21/01/2009', 3, 16, 68694);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (224, '21/01/2009', 4, 6, 145312);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (225, '21/01/2009', 5, 7, 47399);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (226, '21/01/2009', 6, 8, 134244);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (227, '21/01/2009', 7, 17, 125778);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (228, '21/01/2009', 8, 7, 141065);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (229, '21/01/2009', 9, 10, 19602);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (230, '21/01/2009', 10, 4, 124411);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (231, '21/01/2009', 11, 5, 112640);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (232, '22/01/2009', 1, 19, 26913);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (233, '22/01/2009', 2, 17, 28906);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (234, '22/01/2009', 3, 11, 118556);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (235, '22/01/2009', 4, 20, 47436);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (236, '22/01/2009', 5, 8, 5999);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (237, '22/01/2009', 6, 21, 43765);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (238, '22/01/2009', 7, 5, 145424);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (239, '22/01/2009', 8, 18, 146003);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (240, '22/01/2009', 9, 4, 115819);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (241, '22/01/2009', 10, 3, 72891);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (242, '22/01/2009', 11, 2, 2711);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (243, '23/01/2009', 1, 8, 116384);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (244, '23/01/2009', 2, 5, 99210);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (245, '23/01/2009', 3, 9, 44037);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (246, '23/01/2009', 4, 21, 21135);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (247, '23/01/2009', 5, 10, 72297);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (248, '23/01/2009', 6, 2, 148247);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (249, '23/01/2009', 7, 15, 111430);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (250, '23/01/2009', 8, 14, 56234);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (251, '23/01/2009', 9, 17, 95502);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (252, '23/01/2009', 10, 16, 84344);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (253, '23/01/2009', 11, 15, 87231);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (254, '24/01/2009', 1, 2, 128197);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (255, '24/01/2009', 2, 10, 5477);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (256, '24/01/2009', 3, 13, 114163);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (257, '24/01/2009', 4, 18, 23241);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (258, '24/01/2009', 5, 9, 29731);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (259, '24/01/2009', 6, 13, 34038);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (260, '24/01/2009', 7, 12, 50955);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (261, '24/01/2009', 8, 7, 114282);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (262, '24/01/2009', 9, 3, 49818);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (263, '24/01/2009', 10, 12, 145929);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (264, '24/01/2009', 11, 2, 66102);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (265, '25/01/2009', 1, 3, 78226);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (266, '25/01/2009', 2, 20, 58535);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (267, '25/01/2009', 3, 4, 125185);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (268, '25/01/2009', 4, 5, 85032);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (269, '25/01/2009', 5, 2, 1460);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (270, '25/01/2009', 6, 6, 73819);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (271, '25/01/2009', 7, 10, 39545);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (272, '25/01/2009', 8, 10, 68917);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (273, '25/01/2009', 9, 11, 35285);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (274, '25/01/2009', 10, 12, 79303);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (275, '25/01/2009', 11, 21, 133855);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (276, '26/01/2009', 1, 20, 17887);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (277, '26/01/2009', 2, 16, 108709);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (278, '26/01/2009', 3, 1, 43472);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (279, '26/01/2009', 4, 8, 139010);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (280, '26/01/2009', 5, 12, 65912);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (281, '26/01/2009', 6, 18, 111976);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (282, '26/01/2009', 7, 12, 79895);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (283, '26/01/2009', 8, 17, 116200);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (284, '26/01/2009', 9, 19, 27042);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (285, '26/01/2009', 10, 18, 144436);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (286, '26/01/2009', 11, 8, 126943);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (287, '27/01/2009', 1, 18, 53573);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (288, '27/01/2009', 2, 8, 35600);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (289, '27/01/2009', 3, 2, 8654);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (290, '27/01/2009', 4, 15, 59798);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (291, '27/01/2009', 5, 7, 110534);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (292, '27/01/2009', 6, 6, 68171);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (293, '27/01/2009', 7, 17, 14412);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (294, '27/01/2009', 8, 12, 137105);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (295, '27/01/2009', 9, 10, 148929);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (296, '27/01/2009', 10, 5, 64838);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (297, '27/01/2009', 11, 9, 103847);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (298, '28/01/2009', 1, 3, 75338);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (299, '28/01/2009', 2, 16, 72097);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (300, '28/01/2009', 3, 3, 9343);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (301, '28/01/2009', 4, 16, 35034);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (302, '28/01/2009', 5, 9, 21465);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (303, '28/01/2009', 6, 14, 134980);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (304, '28/01/2009', 7, 10, 113793);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (305, '28/01/2009', 8, 14, 105313);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (306, '28/01/2009', 9, 8, 145140);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (307, '28/01/2009', 10, 8, 126523);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (308, '28/01/2009', 11, 11, 93322);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (309, '29/01/2009', 1, 11, 136698);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (310, '29/01/2009', 2, 19, 100062);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (311, '29/01/2009', 3, 10, 105515);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (312, '29/01/2009', 4, 20, 146387);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (313, '29/01/2009', 5, 10, 22040);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (314, '29/01/2009', 6, 11, 90671);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (315, '29/01/2009', 7, 7, 19245);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (316, '29/01/2009', 8, 20, 6367);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (317, '29/01/2009', 9, 2, 78224);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (318, '29/01/2009', 10, 8, 78275);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (319, '29/01/2009', 11, 10, 62766);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (320, '30/01/2009', 1, 16, 102269);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (321, '30/01/2009', 2, 16, 88919);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (322, '30/01/2009', 3, 13, 135227);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (323, '30/01/2009', 4, 17, 81209);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (324, '30/01/2009', 5, 3, 71489);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (325, '30/01/2009', 6, 10, 148405);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (326, '30/01/2009', 7, 3, 53099);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (327, '30/01/2009', 8, 11, 97480);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (328, '30/01/2009', 9, 19, 84564);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (329, '30/01/2009', 10, 10, 18364);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (330, '30/01/2009', 11, 14, 90713);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (331, '31/01/2009', 1, 17, 43226);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (332, '31/01/2009', 2, 19, 310);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (333, '31/01/2009', 3, 4, 34298);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (334, '31/01/2009', 4, 11, 144639);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (335, '31/01/2009', 5, 18, 101770);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (336, '31/01/2009', 6, 5, 89754);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (337, '31/01/2009', 7, 7, 48907);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (338, '31/01/2009', 8, 3, 51362);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (339, '31/01/2009', 9, 9, 115130);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (340, '31/01/2009', 10, 3, 68776);
INSERT into pedido(id, fecha_orden, id_producto, id_cliente, cantidad) values (341, '31/01/2009', 11, 16, 122744);



--linea
INSERT into linea(id, nombre, id_ultimo_formato) values (1, 'Linea1_agua', 1);
INSERT into linea(id, nombre, id_ultimo_formato) values (2, 'Linea2_agua', 5);
INSERT into linea(id, nombre, id_ultimo_formato) values (3, 'Linea3_agua', 7);
INSERT into linea(id, nombre, id_ultimo_formato) values (4, 'Linea1_gaseosa', 6);
INSERT into linea(id, nombre, id_ultimo_formato) values (5, 'Linea2_gaseosa', 4);

--tasa produccion
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (1,1,1,10000);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (2,1,4,8000);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (3,1,5,2000);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (4,2,1,10000);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (5,3,4,7500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (6,3,5,1500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (7,4,1,9600);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (8,5,3,580);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (9,6,2,2700);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (10,7,4,7500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (11,8,4,8000);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (12,8,5,1500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (13,9,4,7500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (14,9,5,1500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (15,10,4,7500);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (16,11,4,8000);
INSERT into tasa_produccion(id,id_producto,id_linea,botellas_hora) values (17,11,5,2000);


--inventario
INSERT INTO inventario(id, cantidad, id_producto) VALUES (1, 19800, 1);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (2, 58700, 2);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (3, 3600, 3);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (4, 20160, 4);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (5, 4536, 5);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (6, 9720, 6);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (7, 2400, 7);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (8, 53760, 8);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (9, 57600, 9);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (10, 72000, 10);
INSERT INTO inventario(id, cantidad, id_producto) VALUES (11, 5400, 11);
