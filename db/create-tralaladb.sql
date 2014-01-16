CREATE DATABASE tralalaDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON tralalaDB.*
           TO root@'%'
           IDENTIFIED BY 'root';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON tralalaDB.*
           TO root@localhost
           IDENTIFIED BY 'root';