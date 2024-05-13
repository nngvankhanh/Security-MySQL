CREATE TABLE IF NOT EXISTS `USER_ROLE` (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT,
    ROLE_ID BIGINT,
    FOREIGN KEY(USER_ID) REFERENCES USER(ID),
    FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ID)
    );