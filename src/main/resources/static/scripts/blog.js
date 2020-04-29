const blogId = window.location.pathname.replace('/blogs/', '');
const commentsRoot = document.querySelector('.comments-root');
const commentBodyInput = document.querySelector('#comment-body');
const saveCommentBtn = document.querySelector('#save-comment-btn');
const addCommentBtn = document.querySelector('#add-comment-btn');
const addCommentArea = document.querySelector('.add-comment-area');

addCommentBtn.addEventListener('click', (e) => {
    addCommentArea.className = 'show';
});

saveCommentBtn.addEventListener('click', (e) => {
    axios.post(`/rest/api/v1/blogs/${blogId}/comments`, {
        body: commentBodyInput.value,
        author: 'test',
        creationDate: new Date()
    }).then(response => console.log(`Comment created ==> ${response.data}`))
})

axios.get(`/rest/api/v1/blogs/${blogId}/comments`)
    .then(response => {
        for (let comment of response.data) {
            let commentDiv = document.createElement('div');
            commentDiv.innerHTML = `
            <div class="comment">
                <p>${comment.title}</p>
                <p>${comment.author}</p>
                <p>${comment.body}</p>
                <p>${comment.creationDate}</p>
            </div>
            `;
            commentsRoot.appendChild(commentDiv);
        }
    })
