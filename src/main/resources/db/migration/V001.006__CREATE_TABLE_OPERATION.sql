CREATE TABLE operation
(
    id                LONG AUTO_INCREMENT PRIMARY KEY,
    property_id       LONG NOT NULL,
    operation_type_id LONG NOT NULL,
    date              DATE,
    CONSTRAINT FK_PROPERTY FOREIGN KEY (property_id)
    REFERENCES property(id),
    CONSTRAINT FK_OPERATION_TYPE FOREIGN KEY (operation_type_id)
    REFERENCES operation_type(id)
)
