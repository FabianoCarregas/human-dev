SELECT * FROM `Category` WHERE `active` ORDER BY `name`;

SELECT * FROM `Subcategory` WHERE `active` ORDER BY `name`;

SELECT * FROM `Course` WHERE `status` = 0;

SELECT `name` FROM `Subcategory` WHERE `subcategory_description` = '';