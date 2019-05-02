INSERT INTO sgn.Building (idBuilding, accessibility, elevator, idCampus, idInstitute, name, quantityOfBathrooms, campus_idCampus, institute_idInstitute) VALUES (17, true, true, 2, 1, 'B', 4, null, null);
INSERT INTO sgn.Campus (idCampus, city, idInstitute, name, number, state, street, telephone, zip, institute_idInstitute) VALUES (2, 'Juiz de Fora', 1, 'Juiz de Fora', 1283, 'Minas Gerais', 'Rua Bernardo Mascarenhas', '4009-3003', '36080-001', null);
INSERT INTO sgn.Department (idDepartment, description, field, idCampus, idInstitute, idProfessor, campus_idCampus, institute_idInstitute, professor_idProfessor) VALUES (16, 'Departamento de Informática', 'Informática', 2, 1, 14, null, null, null);
INSERT INTO sgn.Institute (idInstitute, name, site) VALUES (1, 'IF Sudeste MG', 'https://www.ifsudestemg.edu.br/');
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (3, 'marcoaparaujo@gmail.com', 'Marco', 'Araujo', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (4, 'hiltonmarins@gmail.com', 'Hilton', 'Marins', 1, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (5, 'eugeniajabour@gmail.com', 'Eugenia', 'Jabour', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (6, 'jabour@gmail.com', 'Filippe', 'Jabour', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (7, 'jhglanzmann@gmail.com', 'José', 'Glanzmann', 1, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (8, 'sandro.fernandes@gmail.com', 'Sandro', 'Fernandes', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (9, 'roberto.ferreira@gmail.com', 'Roberto', 'Ferreira', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (10, 'ricardo.santos@ifsudestemg.edu.br', 'Ricardo', 'Santos', 1, 1);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (11, 'marcelocpsantos@gmail.com', 'Marcelo', 'Santos', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (12, 'silvana.faceroli@ifsudestemg.edu.br', 'Silvana', 'Faceroli', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (13, 'ana.martins@ifsudestemg.edu.br', 'Ana', 'Martins', 2, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (14, 'daves.martins@ifsudestemg.edu.br', 'Daves', 'Martins', 0, 0);
INSERT INTO sgn.Professor (idProfessor, email, firstName, lastName, honorifics, status) VALUES (15, 'emerson.moraes@ifsudestemg.edu.br', 'Emerson', 'Moraes', 0, 0);
INSERT INTO sgn.Program (idProgram, academicLevel, idCampus, idDepartment, idInstitute, name, campus_idCampus, department_idDepartment, institute_idInstitute) VALUES (26, 3, 2, 16, 1, 'Sistemas de Informação', null, null, null);
INSERT INTO sgn.Program (idProgram, academicLevel, idCampus, idDepartment, idInstitute, name, campus_idCampus, department_idDepartment, institute_idInstitute) VALUES (27, 2, 2, 16, 1, 'Desenvolvimento de Sistemas', null, null, null);
INSERT INTO sgn.Room (idRoom, idBuilding, idRoomType, number, quantityOfSeats, building_idBuilding, roomType_idRoomType) VALUES (20, 17, 18, 204, 24, null, null);
INSERT INTO sgn.Room (idRoom, idBuilding, idRoomType, number, quantityOfSeats, building_idBuilding, roomType_idRoomType) VALUES (21, 17, 18, 206, 32, null, null);
INSERT INTO sgn.Room (idRoom, idBuilding, idRoomType, number, quantityOfSeats, building_idBuilding, roomType_idRoomType) VALUES (22, 17, 18, 205, 32, null, null);
INSERT INTO sgn.Room (idRoom, idBuilding, idRoomType, number, quantityOfSeats, building_idBuilding, roomType_idRoomType) VALUES (23, 17, 18, 107, 40, null, null);
INSERT INTO sgn.Room (idRoom, idBuilding, idRoomType, number, quantityOfSeats, building_idBuilding, roomType_idRoomType) VALUES (24, 17, 19, 106, 40, null, null);
INSERT INTO sgn.Room (idRoom, idBuilding, idRoomType, number, quantityOfSeats, building_idBuilding, roomType_idRoomType) VALUES (25, 17, 18, 104, 28, null, null);
INSERT INTO sgn.RoomType (idRoomType, description, name) VALUES (18, '', 'Laboratorio');
INSERT INTO sgn.RoomType (idRoomType, description, name) VALUES (19, '', 'Sala de Aula');
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (28, 2, 16, 1, 26, 18, 'Segurança da Informação', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (29, 2, 16, 1, 26, 19, 'Teoria dos Grafos', 2, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (30, 2, 16, 1, 26, 18, 'Linguagem de Programação I', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (31, 2, 16, 1, 26, 18, 'Linguagem de Programação II', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (32, 2, 16, 1, 26, 18, 'Linguagem de Programação III', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (33, 2, 16, 1, 26, 18, 'Linguagem de Programação IV', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (34, 2, 16, 1, 26, 18, 'Linguagem de Programação V', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (35, 2, 16, 1, 26, 18, 'Algoritmos', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (36, 2, 16, 1, 26, 18, 'Estrutura de Dados', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (37, 2, 16, 1, 26, 19, 'Informatica e Sociedade', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (38, 2, 16, 1, 26, 19, 'Interação Humano Computador', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (39, 2, 16, 1, 26, 18, 'Computação Gráfica', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (40, 2, 16, 1, 26, 19, 'Circuitos Lógicos', 3, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (41, 2, 16, 1, 26, 18, 'Desenvolvimento Web', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (42, 2, 16, 1, 26, 19, 'Fundamentos de Sistemas de Informação', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (43, 2, 16, 1, 26, 19, 'Organização de Computadores', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (44, 2, 16, 1, 26, 19, 'Sistemas Operacionais e Compiladores', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (45, 2, 16, 1, 26, 18, 'Banco de Dados I', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (46, 2, 16, 1, 26, 18, 'Banco de Dados II', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (47, 2, 16, 1, 26, 19, 'Engenharia de Software', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (48, 2, 16, 1, 26, 19, 'Gestão de TI', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (49, 2, 16, 1, 26, 19, 'Modelagem de Sistemas', 4, null, null, null, null, null);
INSERT INTO sgn.Subject (idSubject, idCampus, idDepartment, idInstitute, idProgram, idRoomType, name, quantityOfCredits, campus_idCampus, department_idDepartment, institute_idInstitute, program_idProgram, roomType_idRoomType) VALUES (50, 2, 16, 1, 26, 18, 'Inteligencia Computacional', 4, null, null, null, null, null);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.hibernate_sequence (next_val) VALUES (51);
INSERT INTO sgn.user (id_user, login, password, access_level) VALUES (1, 'admin', 'admin', 'admin');