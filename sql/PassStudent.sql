SELECT student.id, student.name,COUNT(subject.id),subject.name, SUM(mark.mark)
FROM turing_second_batch.mark
JOIN student ON student.id = mark.student_id
JOIN subject ON subject.id = mark.subject_id
WHERE mark >=40
GROUP BY student.id
HAVING COUNT(subject.id)= (SELECT COUNT(*) FROM subject)
ORDER BY SUM(mark.mark) DESC,student.id,subject.id