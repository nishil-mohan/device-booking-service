-- src/main/resources/db/changelog/phone-1.sql

CREATE TABLE phone ( 
   id INT NOT NULL, 
   model VARCHAR(50) NOT NULL, 
   alloted BOOLEAN,
   booked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   booked_by VARCHAR(50));
   
INSERT INTO phone (id, model, alloted) VALUES (1, 'Samsung Galaxy S9', false);
INSERT INTO phone (id, model, alloted) VALUES (2, '2x Samsung Galaxy S8', false);
INSERT INTO phone (id, model, alloted) VALUES (3, 'Motorola Nexus 6', false);
INSERT INTO phone (id, model, alloted) VALUES (4, 'Oneplus 9', false);
INSERT INTO phone (id, model, alloted) VALUES (5, 'Apple iPhone 13', false);
INSERT INTO phone (id, model, alloted) VALUES (6, 'Apple iPhone 12', false);
INSERT INTO phone (id, model, alloted) VALUES (7, 'Apple iPhone 11', false);
INSERT INTO phone (id, model, alloted) VALUES (8, 'iPhone X', false);
INSERT INTO phone (id, model, alloted) VALUES (9, 'Nokia 3310', false);
