SELECT student.id, student.name, subject.name, SUM(mark.mark) AS total
FROM student
JOIN mark on student.id = mark.student_id
JOIN subject on subject.id = mark.subject_id
WHERE mark.mark >=40
GROUP by student.id
HAVING (COUNT(student.id)) = (SELECT COUNT(*) FROM subject)
ORDER BY student.id, subject.id