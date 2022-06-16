CREATE TABLE users
(
    id       LONG AUTO_INCREMENT PRIMARY KEY,
    type     LONG,
    name     VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email    VARCHAR(50),
    phone    VARCHAR(15),
    address  VARCHAR(200),
    is_admin BOOLEAN,
    CONSTRAINT FK_USER_TYPE FOREIGN KEY (type)
    REFERENCES user_type(id)
)
