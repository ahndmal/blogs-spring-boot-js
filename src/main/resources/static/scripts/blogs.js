const root = document.querySelector('.root');

axios.get('/rest/api/v1/blogs')
    .then(response => {
        for (let blog of response.data) {
            let blogDiv = document.createElement('div');
            blogDiv.innerHTML = `
                <div class="blog">
                    <p>${blog.author}</p>
                    <a href="/blogs/${blog.id}">${blog.title}</a>
                    <p>${blog.body}</p>
                    <p>${blog.creationDate}</p>
                </div>
            `;
            root.appendChild(blogDiv);
        }
    })