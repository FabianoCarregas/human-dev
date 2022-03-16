SELECT DISTINCT s.`name`, s.`ordination`
FROM `Subcategory` s
INNER JOIN `Course` c
ON c.`subcategory_id` = s.`id`
WHERE `active`
ORDER BY `ordination`;

SELECT `instructor`, COUNT(*) AS `quantity`
FROM `Course`
GROUP BY `instructor` ORDER BY `quantity` DESC
limit 1;

SELECT ca.`name`, COUNT(co.`id`) AS `quantity_of_courses`,
COALESCE(SUM(co.`course_time_hours`), 0) AS `estimated_time`
FROM `Category` ca
LEFT JOIN `Subcategory` su ON ca.`id` = su.`category_id`
LEFT JOIN `Course` co ON su.id = co.`subcategory_id`
WHERE ca.`active`
GROUP BY ca.`name`;