INSERT INTO taskpriority (id, name, ordernum) VALUES ('9917b1acdc84467fa1756c4b6637a8b9', 'Blocker', 4);
INSERT INTO taskpriority (id, name, ordernum) VALUES ('b1a3848c4d354f7b8b66f3ba5bda2204', 'Critical', 3);
INSERT INTO taskpriority (id, name, ordernum) VALUES ('df0f05dc71eb47e0b01144b88eda8059', 'Major', 2);
INSERT INTO taskpriority (id, name, ordernum) VALUES ('2e9d247620a545bfa00a555e1c119c8b', 'Minor', 1);
INSERT INTO taskpriority (id, name, ordernum) VALUES ('5f3a7f59959f4566bb82eee555e249cb', 'Trivial', 0);


INSERT INTO tasktype (id, name) VALUES ('c5e23dc5bf104165bbf9cac439c36f53', 'Bug');
INSERT INTO tasktype (id, name) VALUES ('cb320d77a9b8411e8e07fe0db84cfc89', 'Improvement');
INSERT INTO tasktype (id, name) VALUES ('1abf121dc33d436f8673050b1eb8c77d', 'Feature');
INSERT INTO tasktype (id, name) VALUES ('39e519582b3044929dcf34351a755bde', 'Task');


INSERT INTO person (id, email, password, firstname, lastname, removed) VALUES ('139478d1f89c4f18a1c26c9801398a1d', 'david@tasker.ru', 'david@tasker.ru', 'David', 'Biesack', false);
INSERT INTO person (id, email, password, firstname, lastname, removed) VALUES ('03a8b4c99d1841f9bbaf3624e314f8a5', 'adam@tasker.ru', 'adam@tasker.ru', 'Adam', 'Kiezun', false);
INSERT INTO person (id, email, password, firstname, lastname, removed) VALUES ('83243da597c44a44b68cb399fd771dea', 'iulian@tasker.ru', 'iulian@tasker.ru', 'Iulian', 'Dragos', false);
INSERT INTO person (id, email, password, firstname, lastname, removed) VALUES ('63426d71f6f54b48a51bc6125dfafb44', 'martin@tasker.ru', 'martin@tasker.ru', 'Martin', 'Odersky', false);
INSERT INTO person (id, email, password, firstname, lastname, removed) VALUES ('708d81f6aece4079a71e7925f44a2610', 'stu@tasker.ru', 'stu@tasker.ru', 'Stu', 'Hood', false);
INSERT INTO person (id, email, password, firstname, lastname, removed) VALUES ('01fb88d982f74ff0b1a2732941d9a441', 'admin@tasker.ru', 'admin@tasker.ru', 'Admin', 'Admin', false);


INSERT INTO project (id, name, description) VALUES ('73b64ec71b7b4e778dd27a13ad44ae74', 'cassandra', 'Cassandra is a highly scalable, eventually consistent, distributed, structured key-value store');
INSERT INTO project (id, name, description) VALUES ('0be59e7d46db42b0870430d630b8266f', 'playframework', 'The Play Framework combines productivity and performance making it easy to build scalable web applications with Java and Scala');
INSERT INTO project (id, name, description) VALUES ('5543f0c7622f4ed48cccecf7b6b4631b', 'scala', 'Scala is an object-functional programming and scripting language for general software applications.');


INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('b4a5673c3b7842bd9373065c584bde46', 'Optimize simple for loops', 'I would like to suggest the compiler optimize the common case of for loops, that is to use while loops under the covers instead of. ', 40, false, 'cb320d77a9b8411e8e07fe0db84cfc89', '139478d1f89c4f18a1c26c9801398a1d', 'df0f05dc71eb47e0b01144b88eda8059', '5543f0c7622f4ed48cccecf7b6b4631b');
INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('4603b3cfeadb4a3f99427ab0d9aeffe2', 'Parsers not thread-safe', 'JSON.parseFull or parseRaw randomly fails with NPE. In order to get the stacktrace, one must use -Xint flag. It works fine most of the time and randomly fails', 32, true, 'cb320d77a9b8411e8e07fe0db84cfc89', '63426d71f6f54b48a51bc6125dfafb44', 'df0f05dc71eb47e0b01144b88eda8059', '5543f0c7622f4ed48cccecf7b6b4631b');
INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('2b86066f30e447c89524be74b383ccfc', 'Crashes following pointers', 'class DelayedInitTest', 4, false, 'c5e23dc5bf104165bbf9cac439c36f53', '03a8b4c99d1841f9bbaf3624e314f8a5', '9917b1acdc84467fa1756c4b6637a8b9', '5543f0c7622f4ed48cccecf7b6b4631b');
INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('61cb7347e0e54fa897899b657ed875d9', 'Type specific compression', 'Cassandra has a lot of locations that are ripe for type specific compression.', 5, true, '1abf121dc33d436f8673050b1eb8c77d', '708d81f6aece4079a71e7925f44a2610', 'df0f05dc71eb47e0b01144b88eda8059', '0be59e7d46db42b0870430d630b8266f');
INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('c6985f5e56cd4fb69384422903779bf6', 'Lucene based Indexes', 'Secondary indexes (of type KEYS) suffer from a number of limitations in their current form.', 10, true, 'c5e23dc5bf104165bbf9cac439c36f53', '83243da597c44a44b68cb399fd771dea', '9917b1acdc84467fa1756c4b6637a8b9', '73b64ec71b7b4e778dd27a13ad44ae74');
INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('8c587ab3cc3542d2816fa1f185d84c04', 'Secondary Index Storage', 'Currently, both the CF data, and the secondary index data are stored within the same folder on disk', 70, false, '1abf121dc33d436f8673050b1eb8c77d', '63426d71f6f54b48a51bc6125dfafb44', '2e9d247620a545bfa00a555e1c119c8b', '73b64ec71b7b4e778dd27a13ad44ae74');
INSERT INTO task (id, name, description, estimatedtimeinhours, closed, typeid, assigneeid, priorityid, projectid) VALUES ('2b53370b142d49fc8e84a1c6fae3b68b', 'balance utility for vnodes', 'We need a ''balance'' utility similar to move without a token, in the cases where entropy is not your friend and gives you an unbalanced cluster (I''ve seen up to a 7% discrepancy myself)', 3, true, '39e519582b3044929dcf34351a755bde', '03a8b4c99d1841f9bbaf3624e314f8a5', '5f3a7f59959f4566bb82eee555e249cb', '73b64ec71b7b4e778dd27a13ad44ae74');


INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('704e2148087d4eef85d71ed8cf36da19', 'This is a very important performance enhancement for numerical work. ', '2014-02-03 21:08:24', '139478d1f89c4f18a1c26c9801398a1d', 'b4a5673c3b7842bd9373065c584bde46');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('2cef3011712d40d6a82baad963f65c54', '+1 is actually the only thing keeping me from using Scala.', '2014-02-03 21:10:58', '03a8b4c99d1841f9bbaf3624e314f8a5', 'b4a5673c3b7842bd9373065c584bde46');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('907479b5b14c4da19e334d92c64f1150', 'I have nothing specific against the ThreadLocal thing other than general fear and distrust of ThreadLocal. I think you should go ahead.', '2014-02-03 21:16:24', '63426d71f6f54b48a51bc6125dfafb44', '4603b3cfeadb4a3f99427ab0d9aeffe2');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('7dc6e42c648c437ea9f6eeb75c88f780', 'I encountered this when trying to use a Specs2 After context with a data table.', '2014-02-03 21:19:13', '83243da597c44a44b68cb399fd771dea', '2b86066f30e447c89524be74b383ccfc');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('1a1f8d4537074720aca944971a0567e7', '+1 Interesting in it', '2014-02-03 21:20:00', '83243da597c44a44b68cb399fd771dea', 'b4a5673c3b7842bd9373065c584bde46');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('fca0e4ef3236498588d25249a8e2aba0', 'Try to help u.', '2014-02-03 21:20:13', '83243da597c44a44b68cb399fd771dea', '4603b3cfeadb4a3f99427ab0d9aeffe2');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('9e42162a71cc4bd2a3f2056191cdb33c', 'Attaching an example of noop compression.', '2014-02-03 21:24:53', '708d81f6aece4079a71e7925f44a2610', '61cb7347e0e54fa897899b657ed875d9');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('2a9081dd1c514f4682c9a7c328c4e6a1', 'Implemented delta and varint encoding for LongType, and used that primitive to compress the lengths for the AbstractType implementation.', '2014-02-03 21:25:03', '708d81f6aece4079a71e7925f44a2610', '61cb7347e0e54fa897899b657ed875d9');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('0aafa2eb86b946f5b43e4129ee15f46e', 'Rebased for trunk.', '2014-02-03 21:25:10', '708d81f6aece4079a71e7925f44a2610', '61cb7347e0e54fa897899b657ed875d9');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('a43b89e71a6447a3ba89cdb2c06c2283', 'This will be very similar to what''s being added to HBase. We can borrow some design techniques etc.', '2014-02-03 21:27:07', '01fb88d982f74ff0b1a2732941d9a441', 'c6985f5e56cd4fb69384422903779bf6');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('a5983a83bebe4c60b6cdb8c878fe84d6', 'Yes. Look at uses of MessagingService.', '2014-02-03 21:27:26', '708d81f6aece4079a71e7925f44a2610', 'c6985f5e56cd4fb69384422903779bf6');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('19b597e202704cf7a0387c9a633d6e05', 'You can do this without a Cassandra code change by simply implementing your own secondary index columnfamily.', '2014-02-03 21:30:17', '83243da597c44a44b68cb399fd771dea', '2b53370b142d49fc8e84a1c6fae3b68b');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('e1b349c43f9a425c923be0efef8712ac', 'This will be very similar to what''s being added to HBase. We can borrow some design techniques etc.', '2014-02-03 21:31:44', '03a8b4c99d1841f9bbaf3624e314f8a5', '8c587ab3cc3542d2816fa1f185d84c04');
INSERT INTO taskcomment (id, text, created, authorid, taskid) VALUES ('190a2b0a23614b3f8ae3479e7562752a', 'Realtime search will benefit the indexing speed of the Cassandra secondary index.', '2014-02-03 21:32:51', '63426d71f6f54b48a51bc6125dfafb44', '8c587ab3cc3542d2816fa1f185d84c04');


INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('e56ee9b5b32a4354a2a8ce25260c2d16', 'Task analyze', 4, '2014-02-03 21:08:24', '139478d1f89c4f18a1c26c9801398a1d', 'b4a5673c3b7842bd9373065c584bde46');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('d8f6a84cff554e65b5c793826c2027b1', 'Try to fix', 2, '2014-02-03 21:10:58', '03a8b4c99d1841f9bbaf3624e314f8a5', 'b4a5673c3b7842bd9373065c584bde46');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('8b4a2624263f4bc9bda908572d759555', 'Implementation', 2, '2014-02-03 21:16:24', '63426d71f6f54b48a51bc6125dfafb44', '4603b3cfeadb4a3f99427ab0d9aeffe2');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('2614bd99d6084763ba141f126e50981a', 'Implementation', 8, '2014-02-03 21:16:51', '63426d71f6f54b48a51bc6125dfafb44', '4603b3cfeadb4a3f99427ab0d9aeffe2');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('a69408f9c9924007a5b81be0c071db9b', 'Bug reporting', 1, '2014-02-03 21:19:13', '83243da597c44a44b68cb399fd771dea', '2b86066f30e447c89524be74b383ccfc');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('4ab16680a15745fca0c58cbe75593395', 'Small improvements', 1, '2014-02-03 21:20:13', '83243da597c44a44b68cb399fd771dea', '4603b3cfeadb4a3f99427ab0d9aeffe2');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('b72326649d2a4c059bdad28e65da4dbc', 'Implementation', 5, '2014-02-03 21:24:53', '708d81f6aece4079a71e7925f44a2610', '61cb7347e0e54fa897899b657ed875d9');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('eeb87c62afa24eaaa749b5ec7df13cc9', 'Issue fixed', 8, '2014-02-03 21:28:02', '83243da597c44a44b68cb399fd771dea', 'c6985f5e56cd4fb69384422903779bf6');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('496ddb8b3a23459c89b95ab55a4578c5', 'Consulting', 1, '2014-02-03 21:30:17', '83243da597c44a44b68cb399fd771dea', '2b53370b142d49fc8e84a1c6fae3b68b');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('c127f2c6b36f43ef8387c2b82ed339d6', 'Implementation', 4, '2014-02-03 21:31:17', '03a8b4c99d1841f9bbaf3624e314f8a5', '2b53370b142d49fc8e84a1c6fae3b68b');
INSERT INTO worklogentry (id, text, hours, created, authorid, taskid) VALUES ('7f3ca581c1b449bc8317375af9930504', 'Problem analyze', 8, '2014-02-03 21:32:51', '63426d71f6f54b48a51bc6125dfafb44', '8c587ab3cc3542d2816fa1f185d84c04');
