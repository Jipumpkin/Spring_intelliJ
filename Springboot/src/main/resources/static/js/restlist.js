async function loadBookList() {
    console.log("OK")
    // 1. fetch().then().then().catch()
    // 2. async/await
    // const response(응답) = 요청;
    const response = await fetch("http://localhost:8082/api/book");
    if (!response.ok) {
        throw new Error("Error fetching book data");
    }
    const books = await response.json();
    console.log(books); // [{ [,,]},{ [,,]} ......

    let html = "";
    books.forEach(book => {
        html += "<tr>";
        html += `<td>${book.id}</td>`;
        html += `<td>${book.title}</td>`;
        html += `<td>${book.price}</td>`;
        html += `<td>${book.author}</td>`;
        html += `<td>${book.page}</td>`;
        // 리뷰 출력
        html += "<td><ul>";
        if (book.reviews && book.reviews.length > 0) {
            book.reviews.forEach(review => {
                html += `<li>${review.content}</li>`;
            });
        } else {
            html += "<li>NO REVIEWS</li>";
        }
        html += "</ul></td>";
        html += "</tr>";
    });

    document.getElementById("list").innerHTML=html;
}

