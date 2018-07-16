CREATE TABLE `BICYCLE` (
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(40)         NOT NULL,
    `description` VARCHAR(255)        NULL,
    `price`       DECIMAL(15, 2)      NOT NULL,
    `stock`       BIGINT(20)          NOT NULL,
    `created_at`  TIMESTAMP(3)        NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_at`  TIMESTAMP(3)        NULL     DEFAULT 0,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COMMENT = 'This is just to test how to alter comments';
;
