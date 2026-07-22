SELECT book_id, published_date
FROM book
WHERE published_date > '2021-00-00' AND published_date < '2022-00-00'
AND category = "인문"
ORDER BY published_date