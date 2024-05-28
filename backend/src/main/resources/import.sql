INSERT INTO tb_role(authority) VALUES('ROLE_CLIENT');
INSERT INTO tb_role(authority) VALUES('ROLE_ADMIN');

INSERT INTO tb_user(name, email, password, cpf, uri_photo, birth_date) VALUES('João Silva', 'joao.silva@example.com', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '111.11111.11-1', 'photo', '1980-01-01');
INSERT INTO tb_user(name, email, password, cpf, uri_photo, birth_date) VALUES('Maria Santos', 'maria.santos@example.com', 'senha456', '222.22222.22-2', 'photo', '1980-01-02');
INSERT INTO tb_user(name, email, password, cpf, uri_photo, birth_date) VALUES('Paulo Oliveira', 'paulo.oliveira@example.com', 'senha789', '333.33333.33-3', 'photo', '1980-01-03');
INSERT INTO tb_user(name, email, password, cpf, uri_photo, birth_date) VALUES('Ana Pereira', 'ana.pereira@example.com', 'senha012', '444.44444.44-4', 'photo', '1980-01-04');
INSERT INTO tb_user(name, email, password, cpf, uri_photo, birth_date) VALUES('Roberto Almeida', 'roberto.almeida@example.com', 'senha345', '555.55555.55-5', 'photo', '1980-01-05');


INSERT INTO tb_patient (nis, id) VALUES ('11.111.111-1', 1);
INSERT INTO tb_patient (nis, id) VALUES ('22.222.222-2', 2);
INSERT INTO tb_patient (nis, id) VALUES ('33.333.333-3', 3);
INSERT INTO tb_patient (nis, id) VALUES ('44.444.444-4', 4);
INSERT INTO tb_patient (nis, id) VALUES ('55.555.555-5', 5);


INSERT INTO tb_user (name, email, password, cpf, uri_photo, birth_date) VALUES ('Dr. João Silva', 'dr.joao.silva@example.com', 'senha123', '666.666.666-66', 'photo', '1980-01-06');
INSERT INTO tb_user (name, email, password, cpf, uri_photo, birth_date) VALUES ('Dra. Maria Santos', 'dra.maria.santos@example.com', 'senha456', '777.777.777-77', 'photo', '1980-01-07');
INSERT INTO tb_user (name, email, password, cpf, uri_photo, birth_date) VALUES ('Dr. Paulo Oliveira', 'dr.paulo.oliveira@example.com', 'senha789', '888.888.888-88', 'photo', '1980-01-08');
INSERT INTO tb_user (name, email, password, cpf, uri_photo, birth_date) VALUES ('Dra. Ana Pereira', 'dra.ana.pereira@example.com', 'senha012', '999.999.999-99', 'photo', '1980-01-09');
INSERT INTO tb_user (name, email, password, cpf, uri_photo, birth_date) VALUES ('Dr. Roberto Almeida', 'dr.roberto.almeida@example.com', 'senha345', '101.101.101.10', 'photo', '1980-01-10');


INSERT INTO tb_therapist (license, id) VALUES ('LIC123', 6);
INSERT INTO tb_therapist (license, id) VALUES ('LIC456', 7);
INSERT INTO tb_therapist (license, id) VALUES ('LIC789', 8);
INSERT INTO tb_therapist (license, id) VALUES ('LIC012', 9);
INSERT INTO tb_therapist (license, id) VALUES ('LIC345', 10);

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (1, 'Rua das Flores', 'Centro', 'Recife', 1);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (2, 'Avenida Boa Viagem', 'Boa Viagem', 'Recife', 2);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (3, 'Rua do Sol', 'Pina', 'Recife', 3);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (4, 'Avenida Norte', 'Casa Amarela', 'Recife', 4);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (5, 'Rua da Aurora', 'Boa Vista', 'Recife', 5);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (6, 'Rua da União', 'Boa Vista', 'Recife', 6);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (7, 'Avenida Caxangá', 'Madalena', 'Recife', 7);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (8, 'Rua Real da Torre', 'Madalena', 'Recife', 8);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (9, 'Rua Benfica', 'Madalena', 'Recife', 9);
INSERT INTO tb_address(id, street,  district, city, user_id) VALUES (10, 'Avenida Beberibe', 'Água Fria', 'Recife', 10);


INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (1, '81', '912345678', 1);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (2, '81', '912345679', 2);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (3, '81', '912345680', 3);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (4, '81', '912345681', 4);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (5, '81', '912345682', 5);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (6, '81', '912345683', 6);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (7, '81', '912345684', 7);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (8, '81', '912345685', 8);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (9, '81', '912345686', 9);
INSERT INTO tb_telephone(id, ddd, number, user_id) VALUES (10, '81', '912345687', 10);


INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (1, 'Sua encomenda foi enviada', '2024-05-02 10:00:00', false, '/orders/1', 1);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (2, 'Seu pagamento foi aprovado', '2024-05-02 09:30:00', false, '/payments/1', 1);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (3, 'Novo comentário em seu post', '2024-05-02 09:00:00', false, '/posts/1/comments', 2);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (4, 'Novo like em seu post', '2024-05-02 08:30:00', true, '/posts/1/likes', 2);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (5, 'Novo seguidor', '2024-05-02 08:00:00', false, '/followers', 3);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (6, 'Sua reserva foi confirmada', '2024-05-02 07:30:00', true, '/reservations/1', 3);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (7, 'Seu pedido foi entregue', '2024-05-02 07:00:00', false, '/orders/2', 4);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (8, 'Seu ticket foi respondido', '2024-05-02 06:30:00', false, '/tickets/1', 4);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (9, 'Novo match no seu perfil', '2024-05-02 06:00:00', true, '/matches', 5);
INSERT INTO tb_notification(id, text, moment, read, route, user_id) VALUES (10, 'Novo evento na sua cidade', '2024-05-02 05:30:00', false, '/events', 5);

INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-01', 200.00, 1, 60);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-02', 250.00, 1, 45);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-03', 300.00, 2, 60);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-04', 350.00, 2, 45);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-05', 400.00, 3, 60);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-06', 450.00, 3, 45);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-07', 500.00, 0, 60);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-08', 550.00, 0, 45);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-09', 600.00, 1, 60);
INSERT INTO tb_consultation(date, price, status, duration) VALUES ('2024-05-10', 650.00, 1, 45);

INSERT INTO tb_report(consultation_id, date, description) VALUES (1, '2024-05-02 10:00:00', 'Consulta de rotina sem complicações');
INSERT INTO tb_report(consultation_id, date, description) VALUES (2, '2024-05-02 11:00:00', 'Paciente relatou dores de cabeça frequentes');
INSERT INTO tb_report(consultation_id, date, description) VALUES (3, '2024-05-02 12:00:00', 'Consulta de acompanhamento para diabetes');
INSERT INTO tb_report(consultation_id, date, description) VALUES (4, '2024-05-02 13:00:00', 'Consulta de rotina com exames normais');
INSERT INTO tb_report(consultation_id, date, description) VALUES (5, '2024-05-02 14:00:00', 'Paciente com suspeita de hipertensão');
INSERT INTO tb_report(consultation_id, date, description) VALUES (6, '2024-05-02 15:00:00', 'Consulta para dor no peito, encaminhado para cardiologista');
INSERT INTO tb_report(consultation_id, date, description) VALUES (7, '2024-05-02 16:00:00', 'Paciente com alergia alimentar');
INSERT INTO tb_report(consultation_id, date, description) VALUES (8, '2024-05-02 17:00:00', 'Consulta de rotina, paciente com boa saúde');
INSERT INTO tb_report(consultation_id, date, description) VALUES (9, '2024-05-02 18:00:00', 'Consulta para dor nas costas, recomendado fisioterapia');
INSERT INTO tb_report(consultation_id, date, description) VALUES (10, '2024-05-02 19:00:00', 'Paciente com sintomas de gripe, prescrito repouso e hidratação');

INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(1, 1);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(6, 1);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(2, 2);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(7, 2);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(3, 3);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(8, 3);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(4, 4);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(9, 4);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(5, 5);
INSERT INTO tb_user_consultation(user_id, consultation_id) VALUES(10, 5);

