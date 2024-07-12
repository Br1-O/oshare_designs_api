CREATE TABLE IF NOT EXISTS blog_articles(
id BIGINT auto_increment PRIMARY KEY NOT NULL,
title VARCHAR(50) NOT NULL,
summary VARCHAR(255) NOT NULL,
full_article TEXT NOT NULL,
link VARCHAR(100) NOT NULL,
image_url VARCHAR(70) NOT NULL,
author VARCHAR(50) NOT NULL,
views INT(15) NOT NULL default 0,
likes INT(15) NOT NULL default 0,
favorites INT(15) NOT NULL default 0,
is_active TINYINT(1) NOT NULL DEFAULT 1,
date DATE NOT NULL default CURRENT_DATE,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);