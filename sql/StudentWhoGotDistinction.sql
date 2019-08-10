SELECT student_id,count(subject_id),student.name
FROM mark
JOIN student ON mark.student_id = student.id
WHERE student_id IN 
(SELECT student.id
FROM turing_second_batch.mark
JOIN student ON student.id = mark.student_id
JOIN subject ON subject.id = mark.subject_id
WHERE mark >=40
GROUP BY student.id
HAVING COUNT(subject.id)= (SELECT COUNT(*) FROM subject)
ORDER BY SUM(mark.mark) DESC,student.id,subject.id)
AND mark >=80

GROUP BY student_id;