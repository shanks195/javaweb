-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- cateory Table Create SQL
CREATE TABLE cateory
(
    `ctgid`    INT            NOT NULL    AUTO_INCREMENT, 
    `ctname`   VARCHAR(45)    NOT NULL, 
    `service`  CHAR(1)        NOT NULL, 
    PRIMARY KEY (ctgid)
);


-- cateory Table Create SQL
CREATE TABLE tag
(
    `tagid`   INT            NOT NULL    AUTO_INCREMENT, 
    `tgname`  VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (tagid)
);


-- cateory Table Create SQL
CREATE TABLE menu
(
    `muid`      INT            NOT NULL    AUTO_INCREMENT, 
    `ctgid`     INT            NOT NULL, 
    `muname`    VARCHAR(45)    NOT NULL, 
    `intro`     VARCHAR(45)    NULL, 
    `details`   TEXT           NULL, 
    `price`     DOUBLE         NOT NULL, 
    `currency`  CHAR(3)        NULL, 
    PRIMARY KEY (muid)
);

ALTER TABLE menu
    ADD CONSTRAINT FK_menu_ctgid_cateory_ctgid FOREIGN KEY (ctgid)
        REFERENCES cateory (ctgid) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- cateory Table Create SQL
CREATE TABLE contact
(
    `coid`      INT            NOT NULL    AUTO_INCREMENT, 
    `coname`    VARCHAR(45)    NOT NULL, 
    `priphone`  VARCHAR(45)    NOT NULL, 
    `subphone`  VARCHAR(45)    NULL, 
    `email`     VARCHAR(45)    NOT NULL, 
    `address`   VARCHAR(45)    NOT NULL, 
    `unused`    BIT            NOT NULL, 
    `opening`   VARCHAR(45)    NULL, 
    `weekday`   VARCHAR(45)    NULL, 
    `weekend`   VARCHAR(45)    NULL, 
    `aboutus`   VARCHAR(45)    NULL, 
    `latitude`  DOUBLE         NULL, 
    `logitude`  DOUBLE         NULL, 
    PRIMARY KEY (coid)
);


-- cateory Table Create SQL
CREATE TABLE book
(
    `bkid`     INT            NOT NULL    AUTO_INCREMENT, 
    `bkname`   VARCHAR(45)    NOT NULL, 
    `bkemail`  VARCHAR(45)    NOT NULL, 
    `bkphone`  VARCHAR(45)    NOT NULL, 
    `bktime`   DATETIME       NOT NULL, 
    `bknum`    INT            NOT NULL, 
    `booking`  VARCHAR(45)    NOT NULL, 
    `bkmemo`   TEXT           NULL, 
    PRIMARY KEY (bkid)
);


-- cateory Table Create SQL
CREATE TABLE post
(
    `pid`      INT            NOT NULL    AUTO_INCREMENT, 
    `title`    VARCHAR(45)    NULL, 
    `byname`   VARCHAR(45)    NULL, 
    `regdate`  DATETIME       NULL, 
    `content`  TEXT           NULL, 
    `visible`  BIT            NULL, 
    `tagid`    INT            NULL, 
    PRIMARY KEY (pid)
);

ALTER TABLE post
    ADD CONSTRAINT FK_post_tagid_tag_tagid FOREIGN KEY (tagid)
        REFERENCES tag (tagid) ON DELETE RESTRICT ON UPDATE RESTRICT;

