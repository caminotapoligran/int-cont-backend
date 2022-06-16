CREATE TABLE property
(
    id           LONG AUTO_INCREMENT PRIMARY KEY,
    name         varchar(45) NOT NULL,
    description  varchar     NOT NULL,
    price        float       NOT NULL,
    user_id      LONG        not null,
    category_id  LONG        not null,
    city         varchar(45) not null,
    neighborhood varchar(45) not null,
    rooms        LONG        not null,
    bathrooms    LONG        not null,
    parking      LONG        not null,
    stratum      LONG        not null,
    area         varchar(15) not null,
    created_at   DATE,
    CONSTRAINT FK_USER FOREIGN KEY (user_id)
        REFERENCES users (id),
    CONSTRAINT FK_CATEGORY FOREIGN KEY (category_id)
        REFERENCES category (id)
)
