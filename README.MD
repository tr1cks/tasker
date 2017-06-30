# Tasker

It's my ancient student project. I tried to develop simplest project management system and make some experiments with:
* Java EE stack without heavy-weight technologies like EJB and application containers
* JSF
* CDI
* Hibernate with native SQL queries (sometimes they are necessary for sufficient performance)
* Java Bean Validation

## Features
* Create/edit/delete/view users.
* Create/edit/delete/view projects.
* Create/edit/delete/view tasks in project.
* Add comments to tasks.
* User can report about spend time on task.
* Build simple reports about spend time.

## How to run
1. Setup PostgreSql 9.
2. Create user with credentials "tasker"/"tasker" in it.
3. Create database "tasker" with owner "tasker".
    * By default application automatically create schema objects and destroy all data on each startup.
    * Alternatively you can disable hibernate "hbm2ddl.auto=create" and restore database backup manually from "db-backup" folder.
4. Run application.
    * You can build war and deploy it in any servlet container, like Tomcat 7.
    * Alternatively you can run application by jetty-maven-plugin by jetty:run goal.
5. Enter you application with default user "admin@tasker.ru"/"admin@tasker.ru".

P.s. I definitely don't write my code like this now. :)