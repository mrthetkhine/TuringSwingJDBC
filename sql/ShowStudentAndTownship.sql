SELECT stu.id,stu.name as student_name, tw.name 
FROM turing_first_batch.student as stu
JOIN township as tw ON stu.township_id = tw.id;