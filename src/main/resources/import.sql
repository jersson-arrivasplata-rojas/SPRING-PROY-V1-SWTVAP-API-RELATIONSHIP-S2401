
INSERT INTO "public"."swtvap_clients" (id, name, address, phone, cellphone, country_code, email, whatsapp, details,source_aggregate) VALUES (1,'Mayra Sanchez','Av. Los Heroes 1203,San Juan de Miraflores,Lima', '011745684','961075081','+51','msanchez90@gmail.com',true,'All ok', 0);
INSERT INTO "public"."swtvap_clients" (id, name, address, phone, cellphone, country_code, email, whatsapp, details,source_aggregate) VALUES (2,'Pedro Trujillo','Av. Defensores del Morro 152,Chorrillos, Lima', '011984848','961478981','+51','p_trujillo@gmail.com',false,'All ok', 1);
INSERT INTO "public"."swtvap_clients" (id, name, address, phone, cellphone, country_code, email, whatsapp, details,source_aggregate) VALUES (3,'Franklin Gomez','Av. del Pinar 650,Miraflores, Lima', '018123562','900514845','+51','fgomez_123@gmail.com',false,'All ok', 0);

-- Actualizar los valores de Clients y Provider al insert
INSERT INTO "public"."swtvap_providers" (id, name, address, phone, cellphone, country_code, email, whatsapp, details, status) VALUES (1,'CHARSAC','Av. del Pinar 650,Miraflores, Lima', '018123562','900514845','+51','fgomez_123@gmail.com', true,'All ok', 1);
INSERT INTO "public"."swtvap_providers" (id, name, address, phone, cellphone, country_code, email, whatsapp, details, status) VALUES (2,'PRINSAC','Av. Defensores del Morro 152,Chorrillos, Lima, Lima', '018123562','900514845','+51','prinsac@gmail.com', true,'All ok', 0);
INSERT INTO "public"."swtvap_providers" (id, name, address, phone, cellphone, country_code, email, whatsapp, details, status) VALUES (3,'MAGENSA','Av. Argentina 990, Cercado de Lima, Lima', '014334848','900514845','+51','magensa@magensa.com', false,'All ok', 1);
