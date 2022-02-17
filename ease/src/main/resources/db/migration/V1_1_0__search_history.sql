CREATE TABLE "search_history"
(
    "id"                  INT PRIMARY KEY NOT NULL,
    "user"                varchar(255)    NOT NULL,
    "time"                timestamp       NOT NULL,
    "searched_expression" varchar(255)    NOT NULL
)
