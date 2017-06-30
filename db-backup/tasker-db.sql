CREATE TABLE taskpriority
(
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  name VARCHAR(30) NOT NULL,
  ordernum INT NOT NULL
);
CREATE UNIQUE INDEX uk_jxdb8d81l3owpdv335pgc3mpx ON taskpriority ( name );
CREATE UNIQUE INDEX uk_k4dyonj26rpnan2iswe0yq5yq ON taskpriority ( ordernum );

CREATE TABLE tasktype
(
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  name VARCHAR(30) NOT NULL
);
CREATE UNIQUE INDEX uk_pxjpsxp327cmjc4ooremfnnp8 ON tasktype ( name );

CREATE TABLE person
(
  id VARCHAR(255) PRIMARY KEY NOT NULL,
  email VARCHAR(200) NOT NULL,
  password VARCHAR(30) NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  removed BOOL NOT NULL
);
CREATE UNIQUE INDEX uk_585qcyc8qh7bg1fwgm1pj4fus ON person ( email );

CREATE TABLE project
(
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(200)
);
CREATE UNIQUE INDEX uk_iflk2yk9ma95q0q9ovhftpi63 ON project ( name );

CREATE TABLE task
(
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(200) NOT NULL,
  estimatedtimeinhours INT NOT NULL,
  closed BOOL NOT NULL,
  typeid VARCHAR(32) NOT NULL,
  assigneeid VARCHAR(32) NOT NULL,
  priorityid VARCHAR(32) NOT NULL,
  projectid VARCHAR(32) NOT NULL,
  FOREIGN KEY ( assigneeid ) REFERENCES person ( id ),
  FOREIGN KEY ( projectid ) REFERENCES project ( id ),
  FOREIGN KEY ( priorityid ) REFERENCES taskpriority ( id ),
  FOREIGN KEY ( typeid ) REFERENCES tasktype ( id )
);
CREATE UNIQUE INDEX uk_awswgpgqdgcos1g5t6wehc24m ON task ( name );
CREATE INDEX task_assigneeid_idx ON task ( assigneeid );
CREATE INDEX task_priorityid_idx ON task ( priorityid );
CREATE INDEX task_projectid_idx ON task ( projectid );
CREATE INDEX task_typeid_idx ON task ( typeid );

CREATE TABLE taskcomment
(
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  text VARCHAR(200) NOT NULL,
  created TIMESTAMP NOT NULL,
  authorid VARCHAR(32) NOT NULL,
  taskid VARCHAR(32) NOT NULL,
  FOREIGN KEY ( authorid ) REFERENCES person ( id ),
  FOREIGN KEY ( taskid ) REFERENCES task ( id )
);
CREATE INDEX taskcomment_authorid_idx ON taskcomment ( authorid );
CREATE INDEX taskcomment_taskid_idx ON taskcomment ( taskid );

CREATE TABLE worklogentry
(
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  text VARCHAR(200) NOT NULL,
  hours INT NOT NULL,
  created TIMESTAMP NOT NULL,
  authorid VARCHAR(32) NOT NULL,
  taskid VARCHAR(32) NOT NULL,
  FOREIGN KEY ( authorid ) REFERENCES person ( id ),
  FOREIGN KEY ( taskid ) REFERENCES task ( id )
);
CREATE INDEX worklogentry_authorid_idx ON worklogentry ( authorid );
CREATE INDEX worklogentry_taskid_idx ON worklogentry ( taskid );

