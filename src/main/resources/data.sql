INSERT INTO FORUM_THREAD(id, title, description, creation_Date) VALUES(1, 'Fruits', 'Fruits I like...', parsedatetime('10-01-2010 10:45:52.690', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO FORUM_THREAD(id, title, description, creation_Date) VALUES(2, 'Vegetables', 'Vegetables I hate...', parsedatetime('10-05-2015 12:12:52.690', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO FORUM_THREAD(id, title, description, creation_Date) VALUES(3, 'Meat', 'Meat I Love...', parsedatetime('10-09-2012 08:32:52.690', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO POST(id, message, creation_Date) VALUES(1, 'Apple', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(2, 'Orange', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(3, 'Pear', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(4, 'Tomato', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(5, 'Salad', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(6, 'Cucumber', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(7, 'Pork', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(8, 'Beef', CURDATE());
INSERT INTO POST(id, message, creation_Date) VALUES(9, 'Chicken', CURDATE());

INSERT INTO FORUM_THREAD_POST_SET VALUES(1, 1);
INSERT INTO FORUM_THREAD_POST_SET VALUES(1, 2);
INSERT INTO FORUM_THREAD_POST_SET VALUES(1, 3);
INSERT INTO FORUM_THREAD_POST_SET VALUES(2, 4);
INSERT INTO FORUM_THREAD_POST_SET VALUES(2, 5);
INSERT INTO FORUM_THREAD_POST_SET VALUES(2, 6);
INSERT INTO FORUM_THREAD_POST_SET VALUES(3, 7);
INSERT INTO FORUM_THREAD_POST_SET VALUES(3, 8);
INSERT INTO FORUM_THREAD_POST_SET VALUES(3, 9);
