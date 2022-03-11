select * from Category;

select * from Category where active = 1 order by name;

select * from Subcategory;

select * from Subcategory where active = 1 order by name;

select * from Course;

select * from Course where status = 0;

select * from Subcategory;

select name as nome from Subcategory where subcategory_description = '';
