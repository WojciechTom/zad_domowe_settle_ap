insert into PERSON(id, First_name, Last_name, uml_img, AMOUNT_OF_EXP) values (1,'Kasia', 'Filemonowicz', 'batman.jpg', 2);
insert into PERSON(id, First_name, Last_name, uml_img, AMOUNT_OF_EXP) values (2,'Basia', 'Kos','maska.jpg', 1);
insert into PERSON(id, First_name, Last_name, uml_img, AMOUNT_OF_EXP) values (3, 'Piotrek', 'Kos','spiderman.jpg', 2);
insert into PERSON(id, First_name, Last_name, uml_img, AMOUNT_OF_EXP) values (4, 'Stanisław', 'Abacki','superman.jpg' , 0 );

insert into Expenditure(id, description, long_description, amount, currency, pay_by_id, split_between_id) values (1, 'noclegi', 'opłacenie 2 noclegów w trasie dla mnie i Basi - słowacja', 1200, 'PLN', 1, '1,2');
insert into Expenditure(id, description, long_description, amount, currency, pay_by_id, split_between_id) values (2, 'transport', 'transport z i do Grecji - bilety lotnicze w okazjonalnej taryfie RAZEM', 2200, 'PLN', 1, '1,2,3,4');
insert into Expenditure(id, description, long_description, amount, currency, pay_by_id, split_between_id) values (3, 'kolacja', 'kolacja na ropoczęcie wycieczki' , 600, 'PLN', 2, '1,2,3,4');
insert into Expenditure(id, description, long_description, amount, currency, pay_by_id, split_between_id) values (4, 'marina korcula', 'Pierwsza marina w Chorwacji - korcula - dla jachtu powyzej 50ft', 200, 'PLN', 3, '1,2,3,4');
insert into Expenditure(id, description, long_description, amount, currency, pay_by_id, split_between_id) values (5, 'pamiatki', 'pamiątkowe magnesy z Chorwwacji dla rodziny' , 100, 'PLN', 3, '3,4');

insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (1, 'PLN', 1, 600, 1);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (2, 'PLN', 1, -600, 2);

insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (3, 'PLN', 2, 1650, 1);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (4, 'PLN', 2, -550, 2);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (5, 'PLN', 2, -550, 3);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (6, 'PLN', 2, -550, 4);

insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (7, 'PLN', 3, -150, 1);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (8, 'PLN', 3, 450, 2);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (9, 'PLN', 3, -150, 3);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (10, 'PLN', 3, -150, 4);

insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (11, 'PLN', 4, -50, 1);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (12, 'PLN', 4, -50, 2);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (13, 'PLN', 4, 150, 3);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (14, 'PLN', 4, -50, 4);

insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (15, 'PLN', 5, 50, 3);
insert into CASH_FLOW(id, currency, exp_id, flow, Person_id) values (16, 'PLN', 5, -50, 4);

